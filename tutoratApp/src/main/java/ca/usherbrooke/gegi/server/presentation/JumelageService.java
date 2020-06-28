package ca.usherbrooke.gegi.server.presentation;

import ca.usherbrooke.gegi.server.business.Inscription;
import ca.usherbrooke.gegi.server.persistence.JumelageMapper;
import ca.usherbrooke.gegi.server.persistence.UtilisateurMapper;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("jumelages")
public class JumelageService {
    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    UtilisateurMapper utilisateurMapper;

    @Inject
    JumelageMapper jumelageMapper;

    @Path("makeJumelages")
    @GET
    public Response makeJumelages(){
        UtilisateurService us = new UtilisateurService();
        String sessionCourante = us.getTrimestreCourant();

        List<Inscription> etudiants = utilisateurMapper.getInscriptions(UtilisateurService.ETUDIANT,sessionCourante,null,null);
        List<Inscription> mentors = utilisateurMapper.getInscriptions(UtilisateurService.MENTOR,sessionCourante,null,null);

       Map<String, Integer> coursEnDemande = new HashMap<>();

       //Initier les clés avec les cours qui son demandé par les étudiants
       for(Inscription etudiant : etudiants){
           coursEnDemande.put(etudiant.getCours_id(),0);
       }

       //Compte le nombre de mentor disponible pour chaque cours
       for (Inscription mentor : mentors){
           String cours = mentor.getCours_id();
           if (coursEnDemande.containsKey(cours)){
               coursEnDemande.put(cours,coursEnDemande.get(cours)+1);
           }
       }

       //On trie les cours selon le nombre de mentor dispo, pour passer en priorité les cours avec moins de mentor
        List<Map.Entry<String, Integer>> sortedCoursEnDemande = new ArrayList<>(coursEnDemande.entrySet());
        sortedCoursEnDemande.sort(Map.Entry.comparingByValue());

        Set<String> jumeledMentor = new HashSet<>();
        Set<Inscription> jumeledEtudiant = new HashSet<>();

        //Fait les jumelages
        for (Map.Entry cours : sortedCoursEnDemande){
            String cours_id = (String) cours.getKey();
            for (Inscription mentor : mentors){
                if(cours_id.equals(mentor.getCours_id()) && !jumeledMentor.contains(mentor.getCip())){
                    for(Inscription etudiant :etudiants){
                        if (cours_id.equals(etudiant.getCours_id()) && !jumeledEtudiant.contains(etudiant)){
                            jumelageMapper.insertJumelage(cours_id,sessionCourante,etudiant.getCip(),mentor.getCip());
                            jumeledMentor.add(mentor.getCip());
                            jumeledEtudiant.add(etudiant);
                            break;
                        }
                    }
                }
            }
        }


        return Response.ok(jumeledEtudiant.size() + " jumelages ont ete fait. Voir la base de donnee").build();
    }

    @Path("resetJumelages")
    @GET
    public Response resetJumelages(){
        UtilisateurService us = new UtilisateurService();
        String sessionCourante = us.getTrimestreCourant();
        jumelageMapper.deleteJumelages(null, sessionCourante,null,null);

        return Response.ok("Jumelages supprimée").build();
    }



}
