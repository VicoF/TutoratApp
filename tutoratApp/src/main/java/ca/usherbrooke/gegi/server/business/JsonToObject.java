package ca.usherbrooke.gegi.server.business;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
    * Nous va falloir creer notre objet java representant les resultats du query pour que ca fonctionne
    * au lieu davoir une methode qui mapAObjet, on peut ecrire une methode mapCours, mapReservation, etc... LB
 */
public class JsonToObject {

    //private static String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";
    private static String POSTS_API_URL;

    public JsonToObject(String link) {
        POSTS_API_URL = link;
    }

    public static List<CoursDep> mapToObject() throws IOException, InterruptedException {
        /*
         * Creer la requete a envoyer au client.
         * On specifie le type (GET())
         * Le header c juste ce que on veut accepter. Dans notre cas on accepte du JSON
         * Le URI cest le lieu quon va chercher le JSON
         * Le build ca fait juste construire le tout LB
         */
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();

        // Ici on envoie la requete et on prend juste le body quon transforme en string et on store ca dans une
        // reponse HTTP de type String LB
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        //parse JSON into Objects
        /*
         * Creer un obectMapper qui nous permet de mapper la reponse quon a obtenu en objet Java
         * Ensuite on lit ce quil y a dans le mapper et on le met dans une liste de Posts (TEST) LB
         */
        ObjectMapper mapper = new ObjectMapper();
        List<CoursDep> posts = mapper.readValue(response.body(), new TypeReference<List<CoursDep>>() {});
        posts.forEach(System.out::println);

        return posts;

    }

    public static String getPostsApiUrl() {
        return POSTS_API_URL;
    }
}
