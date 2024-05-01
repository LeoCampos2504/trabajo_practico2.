package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio2.model.constantes.Mes;

public class Main {

	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1 – Crear efeméride");
            System.out.println("2 – Mostrar efemérides");
            System.out.println("3 – Eliminar efeméride");
            System.out.println("4 – Modificar efeméride");
            System.out.println("5 – Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	System.out.println("Introduce el código de la efeméride:");
                    String codigo = scanner.next();
                    System.out.println("Introduce el día de la efeméride:");
                    int dia = scanner.nextInt();
                    System.out.println("Introduce el detalle de la efeméride:");
                    scanner.nextLine();  
                    String detalle = scanner.nextLine();
                    System.out.println("Elige el mes de la efeméride (1-ENERO, 2-FEBRERO, 3-MARZO, 4-ABRIL, 5-MAYO, 6-JUNIO, 7-JULIO, 8-AGOSTO, 9-SEPTIEMBRE, 10-OCTUBRE, 11-NOVIEMBRE, 12-DICIEMBRE):");
                    int mes = scanner.nextInt();
                    Efemeride efemeride = new Efemeride(codigo, Mes.values()[mes - 1], dia, detalle);
                    efemerides.add(efemeride);
                    break;
              
                case 2:
                    for (Efemeride a : efemerides) {
                        System.out.println(a);
                    }
                    break;

    
                case 3:
                    System.out.println("Introduce el código de la efeméride que quieres eliminar:");
                    String codigoEliminar = scanner.next();
                    Efemeride efemerideParaEliminar = null;
                    for (Efemeride a : efemerides) {
                        if (a.getCodigo().equals(codigoEliminar)) {
                            efemerideParaEliminar = a;
                            break;
                        }
                    }
                    if (efemerideParaEliminar != null) {
                        efemerides.remove(efemerideParaEliminar);
                        System.out.println("Efeméride eliminada exitosamente.");
                    } else {
                        System.out.println("No se encontró ninguna efeméride con el código proporcionado.");
                    }
                    break;
                case 4:
                	 System.out.println("Introduce el código de la efeméride que quieres modificar:");
                	    String codigoMod = scanner.next();
                	    for (Efemeride a : efemerides) {
                	        if (a.getCodigo().equals(codigoMod)) {
                	            System.out.println("Introduce el nuevo día de la efeméride:");
                	            int nuevoDia = scanner.nextInt();
                	            a.setDia(nuevoDia);
                	            System.out.println("Introduce el nuevo detalle de la efeméride:");
                	            scanner.nextLine();  
                	            String nuevoDetalle = scanner.nextLine();
                	            a.setDetalle(nuevoDetalle);
                	            System.out.println("Elige el nuevo mes de la efeméride (1-ENERO, 2-FEBRERO, 3-MARZO, 4-ABRIL, 5-MAYO, 6-JUNIO, 7-JULIO, 8-AGOSTO, 9-SEPTIEMBRE, 10-OCTUBRE, 11-NOVIEMBRE, 12-DICIEMBRE):");
                	            int nuevoMes = scanner.nextInt();
                	            a.setMes(Mes.values()[nuevoMes - 1]);
                	        }
                	    }
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }
	}


