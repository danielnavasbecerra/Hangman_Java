package com.ahorcado;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String palabraSecreta = getPalabraSecreta();

        int nLetrasPalabraSecreta = palabraSecreta.length();

        char[] palabraGuiones = new char[nLetrasPalabraSecreta];

        for (int i = 0; i < palabraGuiones.length; i++) {
            palabraGuiones[i] = '_';
        }
        System.out.println(palabraGuiones);


    }

    static String getPalabraSecreta() {
        // Crear un ArrayList para almacenar las palabras
        ArrayList<String> palabras = new ArrayList<>();

        // Añadir 10 palabras con distinta longitud
        palabras.add("Epica");           // 5 letras
        palabras.add("Candil");          // 6 letras
        palabras.add("Sinfonia");        // 8 letras
        palabras.add("Esmeralda");       // 9 letras
        palabras.add("Caleidoscopio");   // 13 letras
        palabras.add("Galaxia");         // 7 letras
        palabras.add("Fenix");           // 5 letras
        palabras.add("Nebulosa");        // 8 letras
        palabras.add("Quimera");         // 7 letras
        palabras.add("Melancolia");      // 10 letras

        // Generar un número aleatorio dentro del rango del tamaño de la lista
        Random r = new Random();
        int n = r.nextInt(palabras.size());

        return palabras.get(n);
    }
}
