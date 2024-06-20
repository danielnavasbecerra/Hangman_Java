package com.ahorcado;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Se llama a getPalabraSecreta()
        String palabraSecreta = getPalabraSecreta();
        // Se crea un arreglo de caracteres con guiones bajos
        ArrayList<Character> palabraGuiones = getGuionesFromPalabra(palabraSecreta);

        // Se inicializan variables
        boolean juegoTerminado = false;
        // Inicialización del Scanner
        Scanner sc = new Scanner(System.in);
        int intentos = 3;

        System.out.println("BIENVENIDO AL JUEGO (El Ahorcado)");

        // Bucle principal del juego
        do {
            System.out.println("\nEl Ahorcado");

            // Mostrar estado actual del ahorcado
            mostrarAhorcado(intentos);

            // Mostrar intentos restantes y estado actual de la palabra
            System.out.println("\nIntentos restantes: " + intentos);
            System.out.print("Palabra: ");
            for (char c : palabraGuiones) {
                System.out.print(c + " ");
            }
            System.out.println("\n");

            // Leer letra del usuario
            System.out.print("Ingresa una letra: ");
            char letra = sc.next().toLowerCase().charAt(0);
            sc.nextLine();

            boolean algunaLetraAcertada = false;

            // Verificar si la letra está en la palabra secreta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.toLowerCase().charAt(i) == letra) {
                    palabraGuiones.set(i, letra);
                    algunaLetraAcertada = true;
                }
            }

            // Verifica si el juego se ha ganado o perdido
            if (!algunaLetraAcertada) {
                System.out.println("\n¡Incorrecto! La letra '" + letra + "' no está en la palabra.");
                --intentos;
            } else {
                boolean juegoGanado = !hayGuiones(palabraGuiones);
                if (juegoGanado) {
                    
                    mostrarAhorcado(intentos);
                    System.out.println("\n¡Has ganado! La palabra era: " + palabraSecreta);
                    juegoTerminado = true;
                }
            }

            // Si se agotan los intentos, el jugador pierde
            if (intentos == 0) {
                mostrarAhorcado(intentos);
                System.out.println("\n¡Has perdido! La palabra era: " + palabraSecreta);
                juegoTerminado = true;
            }

            // Espera a que el usuario presione Enter para continuar
            if (juegoTerminado) {
                System.out.print("\nPresiona Enter para continuar...");
                sc.nextLine();
            }

        } while (!juegoTerminado);

        // Se cierra el Scanner
        sc.close();
    }

    // Método getPalabraSecreta
    static String getPalabraSecreta() {
        // Crear un ArrayList para almacenar las palabras
        ArrayList<String> palabras = new ArrayList<>();

        // Añadir 10 palabras al ArrayList
        palabras.add("Epica");
        palabras.add("Misterio");
        palabras.add("Aventura");
        palabras.add("Tecnologia");
        palabras.add("Programacion");
        palabras.add("Inteligencia");
        palabras.add("Desarrollo");
        palabras.add("Informatica");
        palabras.add("Aprendizaje");
        palabras.add("Innovacion");

        // Generar un número aleatorio dentro del rango del tamaño de la lista
        Random r = new Random();
        int n = r.nextInt(palabras.size());

        return palabras.get(n);
    }

    // Método getGuionesFromPalabra
    static ArrayList<Character> getGuionesFromPalabra(String palabra) {
        // Obtener la longitud de la palabra
        int nLetrasPalabraSecreta = palabra.length();
        ArrayList<Character> palabraGuiones = new ArrayList<>();

        // Rellenar el arreglo con guiones
        for (int i = 0; i < nLetrasPalabraSecreta; i++) {
            palabraGuiones.add('_');
        }

        return palabraGuiones;
    }

    // Método hayGuiones
    static boolean hayGuiones(ArrayList<Character> array) {
        // Buscar guiones en el arreglo
        for (char l : array) {
            if (l == '_') {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar el dibujo del ahorcado según los intentos restantes
    static void mostrarAhorcado(int intentos) {
        switch (intentos) {
            case 3:
                System.out.println("  +----+");
                System.out.println("  |    |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 2:
                System.out.println("  +----+");
                System.out.println("  |    |");
                System.out.println("  O    |");
                System.out.println("  |    |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 1:
                System.out.println("  +----+");
                System.out.println("  |    |");
                System.out.println("  O    |");
                System.out.println(" /|\\   |");
                System.out.println("       |");
                System.out.println("       |");
                break;
            case 0:
                System.out.println("  +----+");
                System.out.println("  |    |");
                System.out.println("  O    |");
                System.out.println(" /|\\   |");
                System.out.println(" / \\   |");
                System.out.println("       |");
                break;
            default:
                System.out.println("  +----+");
                System.out.println("  |    |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                break;
        }
    }
}
