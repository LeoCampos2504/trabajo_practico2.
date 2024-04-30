package ar.edu.unju.fi.ejercicio1.main;
import ar.edu.unju.fi.ejercicio1.model.*;
import ar.edu.unju.fi.ejercicio1.model.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.model.constantes.OrigenFabricacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                	try {
                        System.out.println("Introduce el código del producto:");
                        String codigo = scanner.next();
                        System.out.println("Introduce la descripción del producto:");
                        scanner.nextLine();
                        String descripcion = scanner.nextLine();
                        System.out.println("Introduce el precio unitario del producto:");
                        double precioUnitario = scanner.nextDouble();
                        int origen;
                        do {
                            System.out.println("Elige el origen de fabricación (1-Argentina, 2-China, 3-Brasil, 4-Uruguay):");
                            origen = scanner.nextInt();
                            if (origen < 1 || origen > 4) {
                                System.out.println("Por favor, elige una opción válida para el origen de fabricación.");
                            }
                        } while (origen < 1 || origen > 4);
                        int categoria;
                        do {
                            System.out.println("Elige la categoría del producto (1-Telefonía, 2-Informática, 3-Electro hogar, 4-Herramientas):");
                            categoria = scanner.nextInt();
                            if (categoria < 1 || categoria > 4) {
                                System.out.println("Por favor, elige una opción válida para la categoría.");
                            }
                        } while (categoria < 1 || categoria > 4);
                        Producto producto = new Producto(codigo, descripcion, precioUnitario, OrigenFabricacion.values()[origen - 1], Categoria.values()[categoria - 1]);
                        productos.add(producto);
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, un precio unitario valido.");
                        scanner.next();
                    }
                    break;


                case 2:
                    for (Producto a : productos) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Introduce el código del producto que quieres modificar:");
                        String codigoMod = scanner.next();
                        for (Producto producto : productos) {
                            if (producto.getCodigo().equals(codigoMod)) {
                                System.out.println("Introduce la nueva descripción del producto:");
                                scanner.nextLine();  // Esto es para consumir el salto de línea restante de la entrada anterior
                                String nuevaDescripcion = scanner.nextLine();
                                producto.setDescripcion(nuevaDescripcion);
                                System.out.println("Introduce el nuevo precio unitario del producto:");
                                double nuevoPrecioUnitario = scanner.nextDouble();
                                producto.setPrecioUnitario(nuevoPrecioUnitario);
                                int nuevoOrigen;
                                do {
                                    System.out.println("Elige el nuevo origen de fabricación (1-Argentina, 2-China, 3-Brasil, 4-Uruguay):");
                                    nuevoOrigen = scanner.nextInt();
                                    if (nuevoOrigen < 1 || nuevoOrigen > 4) {
                                        System.out.println("Por favor, elige una opción válida para el origen de fabricación.");
                                    }
                                } while (nuevoOrigen < 1 || nuevoOrigen > 4);
                                producto.setOrigenFabricacion(OrigenFabricacion.values()[nuevoOrigen - 1]);
                                int nuevaCategoria;
                                do {
                                    System.out.println("Elige la nueva categoría del producto (1-Telefonía, 2-Informática, 3-Electro hogar, 4-Herramientas):");
                                    nuevaCategoria = scanner.nextInt();
                                    if (nuevaCategoria < 1 || nuevaCategoria > 4) {
                                        System.out.println("Por favor, elige una opción válida para la categoría.");
                                    }
                                } while (nuevaCategoria < 1 || nuevaCategoria > 4);
                                producto.setCategoria(Categoria.values()[nuevaCategoria - 1]);
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, introduce una entrada válida.");
                        scanner.next();  // Limpiar el buffer del scanner
                    }
                    break;
                    }
            }while (opcion != 4);
        scanner.close();
        }
	}
	

	
        




