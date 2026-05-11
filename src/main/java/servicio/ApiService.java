/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import modelo.Pokemon;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiService {

    private static final HttpClient httpclient = HttpClient.newHttpClient();
    private static final String URL = "https://pokeapi.co/api/v2/pokemon/";

   
    public Pokemon getPokemon(String nombre) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL + nombre.toLowerCase()))
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Error: " + response.statusCode());
            return null;
        }

        JSONObject json = new JSONObject(response.body());
        return new Pokemon(json);
    }

    
    public void getAllPokemons() throws IOException, InterruptedException {

        String url = "https://pokeapi.co/api/v2/pokemon?limit=100";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Error: " + response.statusCode());
            return;
        }

        JSONObject json = new JSONObject(response.body());
        JSONArray results = json.getJSONArray("results");

        System.out.println("\n--- LISTA DE POKEMONES ---");

        for (int i = 0; i < results.length(); i++) {
            JSONObject pokemon = results.getJSONObject(i);
            System.out.println("- " + pokemon.getString("name"));
        }
    }
}