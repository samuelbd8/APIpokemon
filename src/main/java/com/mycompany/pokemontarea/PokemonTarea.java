/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pokemontarea;
import modelo.Pokemon;
import servicio.ApiService;

import java.util.Scanner;

public class PokemonTarea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ApiService api = new ApiService();
        int opcion;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Ver lista de pokemones");
            System.out.println("2. Buscar pokemon");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    try {
                        api.getAllPokemons();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("Ingrese nombre del pokemon: ");
                    String nombre = sc.nextLine();

                    try {
                        Pokemon p = api.getPokemon(nombre);

                        if (p != null) {
                            System.out.println("\n--- DATOS DEL POKEMON ---");
                            System.out.println(p);
                        } else {
                            System.out.println("No se encontró el pokemon.");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 3);

        sc.close();
    }
}
