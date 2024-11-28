/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej1.pkg3;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author yasse
 */
public class EJ13 {

    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("12345678A", "Ana", 25));
        personas.add(new Persona("23456789B", "Luis", 30));
        personas.add(new Persona("34567890C", "María", 22));
        personas.add(new Persona("45678901D", "Carlos", 35));
        personas.add(new Persona("56789012E", "Elena", 18));
        personas.add(new Persona("67890123F", "Pedro", 28));

        System.out.println("Edad del mayor: " + obtenerEdadMayor(personas));
        System.out.println("Edad media: " + calcularEdadMedia(personas));
        System.out.println("Nombre del mayor: " + obtenerNombreMayor(personas));
        System.out.println("Persona mayor: " + obtenerPersonaMayor(personas));
        System.out.println("Mayores de edad: " + obtenerMayoresDeEdad(personas));
        System.out.println("Personas con edad mayor o igual a la media: " + obtenerPorEncimaMedia(personas));
    }

    public static int obtenerEdadMayor(List<Persona> personas) {
        return personas.stream().mapToInt(Persona::getEdad).max().orElse(0);
    }

    public static double calcularEdadMedia(List<Persona> personas) {
        return personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
    }

    public static String obtenerNombreMayor(List<Persona> personas) {
        return personas.stream().max((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
                .map(Persona::getNombre).orElse("No hay personas");
    }

    public static Persona obtenerPersonaMayor(List<Persona> personas) {
        return personas.stream().max((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad())).orElse(null);
    }

    public static List<Persona> obtenerMayoresDeEdad(List<Persona> personas) {
        return personas.stream().filter(p -> p.getEdad() >= 18).toList();
    }

    public static List<Persona> obtenerPorEncimaMedia(List<Persona> personas) {
        double media = calcularEdadMedia(personas);
        return personas.stream().filter(p -> p.getEdad() >= media).toList();
    }
    
}
