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


    @POST
    @Path("InsertUtilisateur")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public String insertUtilisateur(@FormParam("cip") String cip, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("email") String email)
    {
        utilisateurMapper.insertUtilisateur(cip,nom,prenom,email);
        return "Done :) Passez une merveilleuse journee";
    }

    @GET
    @Path("Utilisateur")
    @Produces("application/json")
    public List<Utilisateur> getUtilisateur(@QueryParam("cip") String cip) {
        //  System.out.println(httpServletRequest.getUserPrincipal().getName());
        List<Utilisateur> utilisateurs = utilisateurMapper.select(httpServletRequest.getUserPrincipal().getName());
        return utilisateurs;
    }



}
