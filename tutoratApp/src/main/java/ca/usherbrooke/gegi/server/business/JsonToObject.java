package ca.usherbrooke.gegi.server.business;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonToObject {

    /*
        Classe pour transformer notre JSON en java
     */
    public static void request(String toURI){
        //Method 1: java.net.http.HttpClient. Ca handle les connections asynchronement
        /*
         * Construction du client et de la requete On veut ensuite envoyer cette requete au client de facon
         * asynchrone pour ne pas bloquer le reste de nos operations. Le deuxieme parametre de sendAsync veut
         * dire quon veut recevoir la reponse en string. Ensuite on veut le body de la reponse (ligne 82) puis on
         * veut limprimer avec println. le :: est une expression lambda. Le join retourne le resultat
         *
         *
         * Pour le gradle:
         * compile group: 'org.json', name: 'json', version: '20200518'
         */
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(toURI)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(JsonToObject::parse)
                .join();
    }

    public static String parse(String responseBody)
    {
        JSONArray albums = new JSONArray(responseBody);
        for (int i = 0; i<albums.length(); i++)
        {
            JSONObject album = albums.getJSONObject(i);
            int id = album.getInt("id");
            int userId = album.getInt("userId");
            String title = album.getString("title");

            System.out.println(id + " "+ title + " " + userId);
        }

        return "Done!";
    }

}
