package ca.usherbrooke.gegi.server.presentation;


import ca.usherbrooke.gegi.server.business.Utilisateur;
import ca.usherbrooke.gegi.server.persistence.UtilisateurMapper;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("")
public class UtilisateurService {

    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    UtilisateurMapper utilisateurMapper;

    @GET
    @Path("Utilisateur")
    @Produces("application/json")

    public List<Utilisateur> getUtilisateur(@QueryParam("cip") String cip) {
        //  System.out.println(httpServletRequest.getUserPrincipal().getName());
        List<Utilisateur> utilisateurs = utilisateurMapper.select(cip);
        return utilisateurs;
    }

    @GET
    @Path("InsertUtilisateur")
    @Produces("text/plain")
    public String insertUtilisateur(@QueryParam("cip") String cip, @QueryParam("nom") String nom,
                                  @QueryParam("prenom") String prenom, @QueryParam("email") String email)
    {
        utilisateurMapper.insertUtilisateur(cip, nom, prenom, email);
        return "Done :) Passez une merveilleuse journee";
    }

}
