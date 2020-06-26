package ca.usherbrooke.gegi.server.presentation;

import javax.ws.rs.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("zeus")
public class ZeusService {

    @GET
    @Produces("application/json")
    public String makeZeusGetRequest(@QueryParam("url") String url){
        //Parsing pour get le url
        url = url.replace(';', '&');
        System.out.println(url);
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
