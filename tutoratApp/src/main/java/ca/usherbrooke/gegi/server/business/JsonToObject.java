package ca.usherbrooke.gegi.server.business;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class JsonToObject {

    private static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void mapToObject() throws IOException, InterruptedException {
        /*
         * Creer la requete a envoyer au client.
         * On specifie le type (GET())
         * Le header c juste ce que on veut accepter. Dans notre cas on accepte du JSON
         * Le URI cest le lieu quon va chercher le JSON
         * Le build ca fait juste construire le tout
         */
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();

        // Ici on envoie la requete et on prend juste le body quon transforme en string et on store ca dans une
        // reponse HTTP de type String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        //parse JSON into Objects
        /*
         * Creer un obectMapper qui nous permet de mapper la reponse quon a obtenu en objet Java
         * Ensuite on lit ce quil y a dans le mapper et on le met dans une liste de Posts (TEST)
         */
        //IMPORTANT : Jai mis cours pour que ca compile, je nai rien tester encore 
        ObjectMapper mapper = new ObjectMapper();
        List<Cours> posts = mapper.readValue(response.body(), new TypeReference<List<Cours>>() {});

        posts.forEach(System.out::println);

    }
}
