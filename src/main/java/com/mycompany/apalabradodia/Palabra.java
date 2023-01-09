/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apalabradodia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author a22hugorp
 */
public class Palabra {

    private int erros = 5;
    private String palabraOculta = "Perro", palabra;
    private List<Character> letras = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

   //
    private void crearArray() {
        letras.clear();
        for (int i = 0; i < palabraOculta.length(); i++) {
            letras.add('_');
        }
    }

    // creo que enseña el array pero no lo tengo muy claro
    private void amosarArray() {
        for (int i = 0; i < palabraOculta.length(); i++) {
            System.out.print(letras.get(i));
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    // puede funcionar
    private void pedirPalabra() {
        boolean error = true;
        while (error) {
            System.out.print("Intento nº" + erros + ": ");
            palabra = scan.nextLine();
            if (palabra.length() == palabraOculta.length()) {
                error = false;
                comprobarPalabra(palabra);
            } else {
                System.out.println("La palabra tiene que tener " + palabraOculta.length() + " letras :)");
            }
        }
    }

    //hace cosas
    private void comprobarPalabra(String palabra) {
        for (int i = 0; i < palabraOculta.length(); i++) {
            if (palabraOculta.charAt(i) == palabra.charAt(i)) {
                letras.set(i, palabra.charAt(i));
            } else if (palabraOculta.indexOf(palabra.charAt(i)) != -1) {
                System.out.print("A letra [" + palabra.charAt(i) + "] non atopase na posición correcta \n");
            }
        }
        erros--;
    }

    //comprueba
    private boolean finDejuego() {
        if (palabraOculta.equals(palabra)) {
            System.out.print("O conseguiches");
            return true;
        } else if (erros == 0) {
            System.out.print("Acabaronse os intentos");
            return true;
        }
        return false;

    }

    // aqui juegas
    public void xogar() {
        System.out.println("\nTes que adiviñar unha palabra de " + palabraOculta.length() + " caracteres escribindo palabras co mesmo numero de letras, tes " + erros + " intentos. ¿Lo conseguiras?");
        crearArray();
        while (!finDejuego()) {
            amosarArray();
            crearArray();
            pedirPalabra();
        }
    }
}
