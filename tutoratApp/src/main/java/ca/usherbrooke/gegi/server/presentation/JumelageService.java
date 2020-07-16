package ca.usherbrooke.gegi.server.presentation;

import ca.usherbrooke.gegi.server.business.Inscription;
import ca.usherbrooke.gegi.server.business.Jumelage;
import ca.usherbrooke.gegi.server.business.Utilisateur;
import ca.usherbrooke.gegi.server.persistence.JumelageMapper;
import ca.usherbrooke.gegi.server.persistence.UtilisateurMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Path("jumelages")
public class JumelageService {
    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    UtilisateurMapper utilisateurMapper;

    @Inject
    JumelageMapper jumelageMapper;

    /**
     * Requête permettant d'obtenir les jumelages correspondant aux paramètres
     * @param coursId
     * @param sessionId
     * @param etudiantCIP
     * @param mentorCIP
     * @return Un ArrayJson  contenant tous les jumelages correspondant dans le format:
     *[
     *  {
     *      "cours_id": "GEN101",
     *      "session_id": "E20",
     *      "etudiant": "frev2701",
     *      "mentore_par": "graw3301"
     *  },
     *  {
     *      "cours_id": "GEN400",
     *      "session_id": "E20",
     *      "etudiant": "frev2701",
     *      "mentore_par": "boul0902"
     *  }
     *]
     */
    @GET
    @Produces("application/json")
    public String getJumelages(@QueryParam("cours_id") String coursId, @QueryParam("session_id") String sessionId, @QueryParam("etudiant") String etudiantCIP, @QueryParam("mentore_par") String mentorCIP) {
        Gson gson = new Gson();
        return gson.toJson(jumelageMapper.select(coursId, sessionId, etudiantCIP, mentorCIP));
    }

    /**
     * Requête permettant d'ajouter un jumelage à la base de donnée
     * @param json Un json représentant un jumelage sous le format suivant:
     * {
     *      "cours_id": "GEN101",
     *      "session_id": "E20",
     *      "etudiant": "frev2701",
     *      "mentore_par": "graw3301"
     *  }
     * @return BAD_REQUEST(400) si le JSON est invalide, OK sinon
     */
    @POST
    @Consumes("application/json")
    public Response ajouterJumelage(String json) {
        Gson gson = new Gson();
        Jumelage jumelage;
        try {
            jumelage = gson.fromJson(json, Jumelage.class);
        } catch (JsonSyntaxException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Format du JSON invalide" + e.getLocalizedMessage()).build();
        }
        if (jumelage != null && jumelage.getCours_id() != null && jumelage.getSession_id() != null &&
                jumelage.getEtudiant() != null && jumelage.getMentore_par() != null) {
            jumelageMapper.insertJumelage(jumelage.getCours_id(), jumelage.getSession_id(),
                    jumelage.getEtudiant(), jumelage.getMentore_par());
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Fichier JSON est vide ou son contenu est incomplet").build();
        }

        return Response.ok().build();
    }

    /**
     * Génère les jumelages à partir de toutes les inscriptions du trimestre
     * Important de reset les jumelages avant pour éviter des erreurs de duplicat dans la db
     * @TODO vérifier les jumelages qui existe déjà afin de ne pas avoir à reset
     * @return Une réponse ok, avec le nombre de jumelage effectués
     */
    @Path("makeJumelages")
    @GET
    public Response makeJumelages() {
        resetJumelages();
        UtilisateurService us = new UtilisateurService();
        String sessionCourante = us.getTrimestreCourant();

        List<Inscription> etudiants = utilisateurMapper.getInscriptions(UtilisateurService.ETUDIANT, sessionCourante, null, null);
        List<Inscription> mentors = utilisateurMapper.getInscriptions(UtilisateurService.MENTOR, sessionCourante, null, null);

        Map<String, Integer> coursEnDemande = new HashMap<>();

        //Initier les clés avec les cours qui son demandé par les étudiants
        for (Inscription etudiant : etudiants) {
            coursEnDemande.put(etudiant.getCours_id(), 0);
        }

        //Compte le nombre de mentor disponible pour chaque cours
        for (Inscription mentor : mentors) {
            String cours = mentor.getCours_id();
            if (coursEnDemande.containsKey(cours)) {
                coursEnDemande.put(cours, coursEnDemande.get(cours) + 1);
            }
        }

        //On trie les cours selon le nombre de mentor dispo, pour passer en priorité les cours avec moins de mentor
        List<Map.Entry<String, Integer>> sortedCoursEnDemande = new ArrayList<>(coursEnDemande.entrySet());
        sortedCoursEnDemande.sort(Map.Entry.comparingByValue());

        Set<String> jumeledMentor = new HashSet<>();
        Set<Inscription> jumeledEtudiant = new HashSet<>();

        //Fait les jumelages
        for (Map.Entry cours : sortedCoursEnDemande) {
            String cours_id = (String) cours.getKey();
            for (Inscription mentor : mentors) {
                if (cours_id.equals(mentor.getCours_id()) && !jumeledMentor.contains(mentor.getCip())) {
                    for (Inscription etudiant : etudiants) {
                        if (cours_id.equals(etudiant.getCours_id()) && !jumeledEtudiant.contains(etudiant)) {
                            jumelageMapper.insertJumelage(cours_id, sessionCourante, etudiant.getCip(), mentor.getCip());
                            jumeledMentor.add(mentor.getCip());
                            jumeledEtudiant.add(etudiant);
                            sendNotification(etudiant.getCip());
                            sendNotification(mentor.getCip());
                            break;
                        }
                    }
                }
            }
        }
        return Response.ok(jumeledEtudiant.size() + " jumelages ont ete fait. Voir la base de donnee").build();
    }

    /**
     * Méthode qui permet d'envoyer une notification de création de jumelage à un certain étudiant
     * @param cip : cip de l'étudiant à qui on souhaite faire parvenir la notification
     */
    private void sendNotification(String cip){
        String url = "http://notifius.jplemay.com/users/"+cip+"/notifications";
        String body="{ \n" +
                "\"title\": \"Nouveau Jumelage - Mentorat\",\n" +
                "\"content\": \"Vous avez été jumelé avec un autre étudiant pour un mentorat auquel vous vous êtes inscrit. " +
                "Veuillez consulter la page de TutorAPP pour plus de détails.\",\n" +
                "\"service\": \"MENTORING\"\n" +
                "}";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(url))
                .header("Content-type","application/json; charset=utf-8")
                .build();
      //envoie asynchrone car on ne vérifie pas la réponse
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    }

    /**
     * Un acces à cette page et tout les jumelages de la session en cours disparaitront par magie *pouf*
     * @return Un message OK
     */
    @Path("resetJumelages")
    @GET
    public Response resetJumelages() {
        UtilisateurService us = new UtilisateurService();
        String sessionCourante = us.getTrimestreCourant();
        jumelageMapper.deleteJumelages(null, sessionCourante, null, null);

        return Response.ok("Jumelages supprimée").build();
    }


}
