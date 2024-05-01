package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1 – Alta de jugador");
            System.out.println("2 – Mostrar todos los jugadores");
            System.out.println("3 – Modificar la posición de un jugador");
            System.out.println("4 – Eliminar un jugador");
            System.out.println("5 – Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	 try {
                	        System.out.println("Introduce el nombre del jugador:");
                	        String nombre = scanner.next();
                	        System.out.println("Introduce el apellido del jugador:");
                	        String apellido = scanner.next();
                	        System.out.println("Introduce la fecha de nacimiento del jugador (formato: AAAA-MM-DD):");
                	        String fechaNacimientoStr = scanner.next();
                	        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
                	        if (fechaNacimiento.isAfter(LocalDate.now())) {
                	            throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
                	        }
                	        System.out.println("Introduce la nacionalidad del jugador:");
                	        String nacionalidad = scanner.next();
                	        System.out.println("Introduce la estatura del jugador:");
                	        double estatura = scanner.nextDouble();
                	        System.out.println("Introduce el peso del jugador:");
                	        double peso = scanner.nextDouble();
                	        System.out.println("Elige la posición del jugador (1-DELANTERO, 2-MEDIO, 3-DEFENSA, 4-ARQUERO):");
                	        int posicion = scanner.nextInt();
                	        if (posicion < 1 || posicion > 4) {
                	            throw new IllegalArgumentException("Por favor, elige una opción válida para la posición.");
                	        }
                	        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, Posicion.values()[posicion - 1]);
                	        jugadores.add(jugador);
                	    } catch (DateTimeParseException e) {
                	        System.out.println("Por favor, introduce una fecha válida en el formato AAAA-MM-DD.");
                	    } catch (InputMismatchException e) {
                	        System.out.println("Por favor, introduce un número válido.");
                	        scanner.next();  
                	    } catch (IllegalArgumentException e) {
                	        System.out.println(e.getMessage());
                	    }
                    break;
                case 2:
                	for (Jugador a : jugadores) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                	 try {
                	        System.out.println("Introduce el nombre del jugador que quieres modificar:");
                	        String nombreMod = scanner.next();
                	        System.out.println("Introduce el apellido del jugador que quieres modificar:");
                	        String apellidoMod = scanner.next();
                	        for (Jugador jugador : jugadores) {
                	            if (jugador.getNombre().equals(nombreMod) && jugador.getApellido().equals(apellidoMod)) {
                	                System.out.println("Elige la nueva posición del jugador (1-DELANTERO, 2-MEDIO, 3-DEFENSA, 4-ARQUERO):");
                	                int nuevaPosicion = scanner.nextInt();
                	                if (nuevaPosicion < 1 || nuevaPosicion > 4) {
                	                    throw new IllegalArgumentException("Por favor, elige una opción válida para la posición.");
                	                }
                	                jugador.setPosicion(Posicion.values()[nuevaPosicion - 1]);
                	            }
                	        }
                	    } catch (InputMismatchException e) {
                	        System.out.println("Por favor, introduce un número válido.");
                	        scanner.next();  
                	    } catch (IllegalArgumentException e) {
                	        System.out.println(e.getMessage());
                	    }
                    break;
                case 4:
                	   System.out.println("Introduce el nombre del jugador que quieres eliminar:");
                	    String nombreEliminar = scanner.next();
                	    System.out.println("Introduce el apellido del jugador que quieres eliminar:");
                	    String apellidoEliminar = scanner.next();
                	    Jugador jugadorParaEliminar = null;
                	    for (Jugador a : jugadores) {
                	        if (a.getNombre().equals(nombreEliminar) && a.getApellido().equals(apellidoEliminar)) {
                	            jugadorParaEliminar = a;
                	            break;
                	        }
                	    }
                	    if (jugadorParaEliminar != null) {
                	        jugadores.remove(jugadorParaEliminar);
                	        System.out.println("Jugador eliminado exitosamente.");
                	    } else {
                	        System.out.println("No se encontró ningún jugador con el nombre y apellido proporcionados.");
                	    }
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }

}
