package ca.usherbrooke.gegi.server.presentation;



import ca.usherbrooke.gegi.server.business.CoursDep;
import ca.usherbrooke.gegi.server.business.JsonToObject;
import ca.usherbrooke.gegi.server.business.Utilisateur;
import ca.usherbrooke.gegi.server.persistence.UtilisateurMapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.jasig.cas.client.authentication.AttributePrincipal;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Path("users")
public class UtilisateurService {

    @Context
    HttpServletRequest httpServletRequest;

    @Inject
    UtilisateurMapper utilisateurMapper;

    @POST
    @Consumes("application/json")
    public Response ajouterUtilisateur(String json){
        Gson gson = new Gson();
        Utilisateur user;
        try {
             user = gson.fromJson(json, Utilisateur.class);
        } catch (JsonSyntaxException e){
            return Response.serverError().entity("Format du JSON invalide" + e.getLocalizedMessage()).build();
        }
        if (user!=null) {
            utilisateurMapper.insertUtilisateur(user.getCip(),user.getNom(),user.getPrenom(),user.getEmail());
        }else{
            return Response.serverError().entity("Fichier JSON est vide").build();
        }

        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    public String getUtilisateur(@QueryParam("cip") String cip){
        Gson gson = new Gson();
        return gson.toJson(utilisateurMapper.select(cip));
    }

    /*@GET
    @Path("album")
    @Produces("application/json")
    public String getAlbum() throws IOException, InterruptedException {
        //String que l'on done comme lien pour get les objets java
        String url = "http://zeus.gel.usherbrooke.ca:8080/ms/rest/groupe_cours?inscription=2017-01-01";
        //Creer le mapper qui s'occupe de tout transformer
        JsonToObject mapper = new JsonToObject(url);
        List<CoursDep> cours = mapper.mapToObject();

        //Pour inserer les cours dans la base de donnee
        //insertCours(cours);
        return "Done! veuillez voir la console :)";
    }*/

   /* @GET
    @Path("inscriptionMentor")
    @Produces("text/html")
    public String inscriptionMentor(){

        Document doc=null;

        try {
            File file = new File(String.valueOf(httpServletRequest.getServletContext().getRealPath("/inscriptionMentor.html")));
            doc = Jsoup.parse(file, "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> attributes = ((AttributePrincipal) httpServletRequest.getUserPrincipal()).getAttributes();

        Element prenom = doc.selectFirst("input[id=champ_prenom]");
        //la valeur est stockée dans un mauvais encodage (qui ne supporte pas les accents), donc on la convertie
        prenom.attr("value", new String(((String) attributes.get("prenom")).getBytes(), StandardCharsets.UTF_8));

        Element nom = doc.selectFirst("input[id=champ_nom]");
        nom.attr("value", new String(((String) attributes.get("nomFamille")).getBytes(), StandardCharsets.UTF_8));

        Element email = doc.selectFirst("input[id=champ_email]");
        email.attr("value", (String) attributes.get("courriel"));

        return doc.outerHtml();
    }*/

   /* @GET
    @Path("inscriptionMentore")
    @Produces("text/html")
    public String inscriptionMentore(){

        Document doc=null;

        try {
            File file = new File(String.valueOf(httpServletRequest.getServletContext().getRealPath("/inscriptionMentore.html")));
            doc = Jsoup.parse(file, "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> attributes = ((AttributePrincipal) httpServletRequest.getUserPrincipal()).getAttributes();

        Element prenom = doc.selectFirst("input[id=champ_prenom]");
        //la valeur est stockée dans un mauvais encodage (qui ne supporte pas les accents), donc on la convertie
        prenom.attr("value", new String(((String) attributes.get("prenom")).getBytes(), StandardCharsets.UTF_8));

        Element nom = doc.selectFirst("input[id=champ_nom]");
        nom.attr("value", new String(((String) attributes.get("nomFamille")).getBytes(), StandardCharsets.UTF_8));

        Element email = doc.selectFirst("input[id=champ_email]");
        email.attr("value", (String) attributes.get("courriel"));

        return doc.outerHtml();
    }*/

    /*@GET
    @Path("Test")
    @Produces("text/html")
    public String test(){

        Document doc=null;

        try {
             File file = new File(String.valueOf(httpServletRequest.getServletContext().getRealPath("/index.html")));
            doc = Jsoup.parse(file, "UTF-8");
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
    }*/

    @POST
    @Path("InsertUtilisateur")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/plain")
    public String insertUtilisateur(@FormParam("cip") String cip, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("email") String email)
    {
        utilisateurMapper.insertUtilisateur(cip,nom,prenom,email);
        return "Done :) Passez une merveilleuse journee";
    }


   /* @POST
    @Path("InsertUtilisateur")
    @Produces("text/plain")
    //Fonction qui insere des cours dans notre base de donnee LB
    public String insertCours(List<CoursDep> coursAImporter){
        for (CoursDep cours : coursAImporter){
            utilisateurMapper.insertCours(cours.getAp_id(), cours.getDepartement_id(), cours.getDescription(), cours.getTrimestre_id());
        }
        return "Le tout est insere dans la base de donnee";
    }*/

    @GET
    @Path("Trimestre")
    @Produces("text/plain")
    public String getTrimestreCourant(){
        //Obtention de la date actuelle
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();

        //parse JSON into Objects
        /*
         * Crée un parser à partir de la string qui contient le JSON
         * Itere le parser jusqu'à atteindre le début de l'array
         */
        JsonParser parser = Json.createParser(new StringReader(makeGetRequest("http://zeus.gel.usherbrooke.ca:8080/ms/rest/trimestre?inscription=2017-01-01")));
        while(parser.hasNext()){
            JsonParser.Event event = parser.next();
            if (event.equals(JsonParser.Event.START_ARRAY)){
                break;
            }
        }
        //On obtient le array, puis on en extrait les objets
        //On vérifie si l'objet est le trimestre courant.
        JsonArray trimestres = parser.getArray();
        String reponse = "";
        for(int i =0; i< trimestres.size();i++){
            JsonObject obj = trimestres.getJsonObject(i);
            String debut= obj.getString("debut");
            String fin= obj.getString("fin");
            LocalDate dateDebut = LocalDate.parse(debut,dtf);
            LocalDate dateFin = LocalDate.parse(fin,dtf);
            if(currentDate.isAfter(dateDebut)&&currentDate.isBefore(dateFin)){
                reponse= obj.getString("trimestre_id");
                break;
            }
        }
        return reponse;
    }

    @GET
    @Path("Cours")
    @Produces("text/plain")
    public String getCoursCourant(){
        String trimestreParam = "trimestre_id="+getTrimestreCourant();

        String url =  "http://zeus.gel.usherbrooke.ca:8080/ms/rest/etudiant_groupe?inscription=2017-01-01" + "&" + trimestreParam + "&cip_etudiant=" + httpServletRequest.getUserPrincipal().getName();

        //parse JSON into Objects
        /*
         * Crée un parser à partir de la string qui contient le JSON
         * Itere le parser jusqu'à atteindre le début de l'array
         */
        JsonParser parser = Json.createParser(new StringReader(makeGetRequest(url)));
        while(parser.hasNext()){
            JsonParser.Event event = parser.next();
            if (event.equals(JsonParser.Event.START_ARRAY)){
                break;
            }
        }

        //On obtient le array, puis on en extrait les objets
        //On stock le nom de l'app
        JsonArray groupes = parser.getArray();
        List<String> reponse = new ArrayList<>();
        for(int i =0; i< groupes.size();i++){
            JsonObject obj = groupes.getJsonObject(i);
            String cours= obj.getString("app");
           reponse.add(cours);
        }
        System.out.println(reponse);
        return reponse.toString();

    }

    /**
     * Permet d'obtenir l'information contenu sur une certaine page à l'aide d'une requête GET
     * @param url
     * @return
     */
    private String makeGetRequest(String url){
        //Création de la requête pour obtenir la liste des trimestres
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();

        // Ici on envoie la requete et on prend juste le body quon transforme en string et on store ca dans une
        // reponse HTTP de type String LB
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.body();
    }
}
