package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.model.constantes.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		 for (int i = 0; i < 15; i++) {
			 Producto producto = new Producto();
		        
		        System.out.println("Ingrese los datos del producto " + (i+1) + ":");

		        System.out.print("Código: ");
		        producto.setCodigo(scanner.nextLine());

		        System.out.print("Descripción: ");
		        producto.setDescripcion(scanner.nextLine());

		        System.out.print("Precio unitario: ");
		        producto.setPrecioUnitario(scanner.nextDouble());
		        scanner.nextLine(); 
		        System.out.println("Origen de fabricación:");
		        for (int i1 = 0; i1 < OrigenFabricacion.values().length; i1++) {
		            System.out.println((i1+1) + " - " + OrigenFabricacion.values()[i1]);
		        }
		        int origen = scanner.nextInt();
		        scanner.nextLine(); 
		        producto.setOrigenFabricacion(OrigenFabricacion.values()[origen - 1]);
		        System.out.println("Categoría:");
		        for (int i1 = 0; i1 < Categoria.values().length; i1++) {
		            System.out.println((i1+1) + " - " + Categoria.values()[i1]);
		        }
		        int categoria = scanner.nextInt();
		        scanner.nextLine(); 
		        producto.setCategoria(Categoria.values()[categoria - 1]);

		        System.out.print("Estado (true para disponible, false para no disponible): ");
		        producto.setEstado(scanner.nextBoolean());
		        scanner.nextLine(); 

		        productos.add(producto);
	        }
		 
		 while (true) {
	            System.out.println("1 – Mostrar productos");
	            System.out.println("2 – Realizar compra");
	            System.out.println("3 – Salir");

	            int opcion = scanner.nextInt();

	            switch (opcion) {
	            case 1:
	                System.out.println("Lista de productos:");
	                for (int i = 0; i < productos.size(); i++) {
	                    Producto producto = productos.get(i);
	                    System.out.println((i+1) + ". " + 
	                                       "Nombre: " + producto.getDescripcion() + ", " +
	                                       "Precio: $" + producto.getPrecioUnitario() + ", " +
	                                       "Origen de Fabricación: " + producto.getOrigenFabricacion() + ", " +
	                                       "Categoría: " + producto.getCategoria() + ", " +
	                                       "Disponible: " + (producto.getEstado() ? "Sí" : "No"));
	                }
	                break;

	            case 2:
	                
	                ArrayList<Producto> productosSeleccionados = new ArrayList<>();
	                
	                System.out.println("Seleccione los productos que desea comprar (ingrese 0 para terminar):");
	                while (true) {
	                    int seleccion = scanner.nextInt();
	                    scanner.nextLine(); 

	                    if (seleccion == 0) {
	                        break;
	                    } else if (seleccion > 0 && seleccion <= productos.size()) {
	                        Producto producto = productos.get(seleccion - 1);
	                        if (producto.getEstado()) {
	                            productosSeleccionados.add(producto);
	                        } else {
	                            System.out.println("El producto seleccionado no está disponible.");
	                        }
	                    } else {
	                        System.out.println("Opción inválida.");
	                    }
	                }

	                
	                double monto = 0.0;
	                for (Producto producto : productosSeleccionados) {
	                    monto += producto.getPrecioUnitario();
	                }

	               
	                System.out.println("Seleccione una opción de pago:");
	                System.out.println("1 – Pago efectivo");
	                System.out.println("2 – Pago con tarjeta");

	                int opcionPago = scanner.nextInt();
	                scanner.nextLine(); 

	                if (opcionPago == 1) {
	                    PagoEfectivo pagoEfectivo = new PagoEfectivo();
	                    pagoEfectivo.setFechaPago(LocalDate.now());
	                    pagoEfectivo.realizarPago(monto);
	                    pagoEfectivo.imprimirRecibo();
	                } else if (opcionPago == 2) {
	                    PagoTarjeta pagoTarjeta = new PagoTarjeta();
	                    System.out.print("Ingrese el número de tarjeta: ");
	                    pagoTarjeta.setNumeroTarjeta(scanner.nextLine());       
	                    pagoTarjeta.setFechaPago(LocalDate.now());
	                    pagoTarjeta.realizarPago(monto);
	                    pagoTarjeta.imprimirRecibo();
	                } else {
	                    System.out.println("Opción inválida.");
	                }
	                break;

	                case 3:
	                    // Salir
	                    System.exit(0);
	                default:
	                    System.out.println("Opción inválida");
		 
		 
	}
   }		 
  }	
 }
