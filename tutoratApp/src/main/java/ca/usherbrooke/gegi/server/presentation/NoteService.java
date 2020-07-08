package ca.usherbrooke.gegi.server.presentation;

import ca.usherbrooke.gegi.server.business.Inscription;
import ca.usherbrooke.gegi.server.business.Jumelage;
import ca.usherbrooke.gegi.server.business.Utilisateur;
import ca.usherbrooke.gegi.server.persistence.JumelageMapper;
import ca.usherbrooke.gegi.server.persistence.UtilisateurMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("Note")
public class NoteService {
    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    UtilisateurMapper utilisateurMapper;

    @Inject
    JumelageMapper jumelageMapper;

    @Inject
    NoteMapper noteMapper;

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
    public String getNote(@QueryParam("cip") String cip, @QueryParam("statut_id") String statutId,
                            @QueryParam("cours_id") String coursId, @QueryParam("donnee_par") String donneurCip,
                                @QueryParam("note") int note, @QueryParam("commentaire") String commentaire) {
        Gson gson = new Gson();
        return gson.toJson(jumelageMapper.select(cip, statutId, coursId, donneurCip, note, commentaire));
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
    public Response ajouterNote(String json) {
        Gson gson = new Gson();
        Note note;
        try {
            note = gson.fromJson(json, Jumelage.class);
        } catch (JsonSyntaxException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Format du JSON invalide" + e.getLocalizedMessage()).build();
        }
        if (note != null && note.getCip() != null && note.getStatut_id() != null &&
                note.getCours_id() != null && note.getDonnee_par() != null && note.getNote() != null && note.getCommentaire) {
            noteMapper.insertNote(note.getCip(), note.getStatut_id(),
                    note.getCours_id(), note.getDonnee_par(), note.getNote(), note.getCommentaire);
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Fichier JSON est vide ou son contenu est incomplet").build();
        }

        return Response.ok().build();
    }

    /**
     * Un acces à cette page et tout les jumelages de la session en cours disparaitront par magie *pouf*
     * @return Un message OK
     */
    @Path("resetNote")
    @GET
    public Response resetNote() {
        UtilisateurService us = new UtilisateurService();
        String utilisateur = us.getUtilisateur();
        NoteMapper.deleteNote(null, null, null, utilisateur, null, null);

        return Response.ok("Notes supprimée").build();
    }


}