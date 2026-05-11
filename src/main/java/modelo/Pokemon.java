/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import org.json.JSONArray;
import org.json.JSONObject;

public class Pokemon {

    private String nombre;
    private String habilidad;
    private String imagen;
    private int peso;

    public Pokemon(JSONObject json) {
        this.nombre = json.getString("name");

        
        this.peso = json.getInt("weight");

        
        JSONArray abilities = json.getJSONArray("abilities");
        JSONObject abilityObj = abilities.getJSONObject(0);
        this.habilidad = abilityObj.getJSONObject("ability").getString("name");

        
        this.imagen = json.getJSONObject("sprites").getString("front_default");
    }

    public String getNombre() {
        return nombre;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public String getImagen() {
        return imagen;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Pokemon: " + nombre +
                "\nHabilidad: " + habilidad +
                "\nPeso: " + peso +
                "\nImagen: " + imagen;
    }
}