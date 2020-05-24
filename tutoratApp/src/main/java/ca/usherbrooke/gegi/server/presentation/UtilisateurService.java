package ca.usherbrooke.gegi.server.presentation;


import ca.usherbrooke.gegi.server.business.Utilisateur;
import ca.usherbrooke.gegi.server.persistence.UtilisateurMapper;
import com.sun.tools.javac.Main;
import org.jasig.cas.client.authentication.AttributePrincipal;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@Path("")
public class UtilisateurService {

    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    UtilisateurMapper utilisateurMapper;

    @GET
    @Path("inscriptionMentor")
    @Produces("text/html")
    public String inscriptionMentor(){

        Document doc=null;

        try {
            File allo = new File(String.valueOf(httpServletRequest.getServletContext().getRealPath("/inscriptionMentor.html")));
            doc = Jsoup.parse(allo, "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> attributes = ((AttributePrincipal) httpServletRequest.getUserPrincipal()).getAttributes();

        Element prenom = doc.selectFirst("input[id=champ_prenom]");
        prenom.attr("value", (String) attributes.get("prenom"));

        Element nom = doc.selectFirst("input[id=champ_nom]");
        nom.attr("value", (String) attributes.get("nomFamille"));

        Element email = doc.selectFirst("input[id=champ_email]");
        email.attr("value", (String) attributes.get("courriel"));

        return doc.outerHtml();
    }

    @GET
    @Path("inscriptionMentore")
    @Produces("text/html")
    public String inscriptionMentore(){

        Document doc=null;

        try {
            File allo = new File(String.valueOf(httpServletRequest.getServletContext().getRealPath("/inscriptionMentore.html")));
            doc = Jsoup.parse(allo, "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> attributes = ((AttributePrincipal) httpServletRequest.getUserPrincipal()).getAttributes();

        Element prenom = doc.selectFirst("input[id=champ_prenom]");
        prenom.attr("value", (String) attributes.get("prenom"));

        Element nom = doc.selectFirst("input[id=champ_nom]");
        nom.attr("value", (String) attributes.get("nomFamille"));

        Element email = doc.selectFirst("input[id=champ_email]");
        email.attr("value", (String) attributes.get("courriel"));

        return doc.outerHtml();
    }

    @GET
    @Path("Test")
    @Produces("text/html")
    public String test(){

        Document doc=null;

        try {
             File allo = new File(String.valueOf(httpServletRequest.getServletContext().getRealPath("/index.html")));
            doc = Jsoup.parse(allo, "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> attributes = ((AttributePrincipal) httpServletRequest.getUserPrincipal()).getAttributes();

        Element prenom = doc.selectFirst("input[id=champ_prenom]");
        prenom.attr("value", (String) attributes.get("prenom"));

        Element nom = doc.selectFirst("input[id=champ_nom]");
        nom.attr("value", (String) attributes.get("nomFamille"));

        Element email = doc.selectFirst("input[id=champ_email]");
        email.attr("value", (String) attributes.get("courriel"));

        return doc.outerHtml();
    }

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
