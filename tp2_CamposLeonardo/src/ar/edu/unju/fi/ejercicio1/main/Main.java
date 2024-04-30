package ar.edu.unju.fi.ejercicio1.main;
import ar.edu.unju.fi.ejercicio1.model.*;
import ar.edu.unju.fi.ejercicio1.model.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.model.constantes.OrigenFabricacion;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1 – Crear Producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Modificar producto");
            System.out.println("4 – Salir.");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                
                case 1:
                    System.out.println("Introduce el código del producto:");
                    String codigo = scanner.next();
                    System.out.println("Introduce la descripción del producto:");
                    scanner.nextLine();
                    String descripcion = scanner.nextLine();
                    System.out.println("Introduce el precio unitario del producto:");
                    double precioUnitario = scanner.nextDouble();
                    System.out.println("Elige el origen de fabricación (1-Argentina, 2-China, 3-Brasil, 4-Uruguay):");
                    int origen = scanner.nextInt();
                    System.out.println("Elige la categoría del producto (1-Telefonía, 2-Informática, 3-Electro hogar, 4-Herramientas):");
                    int categoria = scanner.nextInt();
                    Producto producto = new Producto(codigo, descripcion, precioUnitario, OrigenFabricacion.values()[origen - 1], Categoria.values()[categoria - 1]);
                    productos.add(producto);
                    break;

                case 2:
                    for (Producto a : productos) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                	System.out.println("Introduce el código del producto que quieres modificar:");
                    String codigoMod = scanner.next();
                    for (Producto a : productos) {
                        if (a.getCodigo().equals(codigoMod)) {
                        	System.out.println("Introduce la descripción del producto:");
                            scanner.nextLine();
                            String nuevaDescripcion = scanner.nextLine();
                            a.setDescripcion(nuevaDescripcion);
                            System.out.println("Introduce el nuevo precio unitario del producto:");
                            double nuevoPrecioUnitario = scanner.nextDouble();
                            a.setPrecioUnitario(nuevoPrecioUnitario);
                            System.out.println("Elige el nuevo origen de fabricación (1-Argentina, 2-China, 3-Brasil, 4-Uruguay):");
                            int nuevoOrigen = scanner.nextInt();
                            a.setOrigenFabricacion(OrigenFabricacion.values()[nuevoOrigen - 1]);
                            System.out.println("Elige la nueva categoría del producto (1-Telefonía, 2-Informática, 3-Electro hogar, 4-Herramientas):");
                            int nuevaCategoria = scanner.nextInt();
                            a.setCategoria(Categoria.values()[nuevaCategoria - 1]);
                        }
                    }
                    break;
            }
        } while (opcion != 4);
        scanner.close();
    }

}


