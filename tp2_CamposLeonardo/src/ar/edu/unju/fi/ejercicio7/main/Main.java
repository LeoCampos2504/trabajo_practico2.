package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.constantes.Categoria;
import ar.edu.unju.fi.ejercicio1.model.constantes.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto("1","Producto 1", 100.0f,OrigenFabricacion.CHINA , Categoria.INFORMATICA, true));
		productos.add(new Producto("2","Producto 2", 2200.0f,OrigenFabricacion.ARGENTINA , Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("3","Producto 3", 11200.0f,OrigenFabricacion.BRASIL , Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("4","Producto 4", 13300.0f,OrigenFabricacion.CHINA , Categoria.INFORMATICA, true));
		productos.add(new Producto("5","Producto 5", 11100.0f,OrigenFabricacion.URUGUAY , Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("6","Producto 6", 1333200.0f,OrigenFabricacion.ARGENTINA , Categoria.TELEFONIA, false));
		productos.add(new Producto("7","Producto 7", 11200.0f,OrigenFabricacion.BRASIL , Categoria.TELEFONIA, true));
		productos.add(new Producto("8","Producto 8", 11100.0f,OrigenFabricacion.CHINA , Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("9","Producto 9", 133300.0f,OrigenFabricacion.BRASIL , Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("10","Producto 10", 11100.0f,OrigenFabricacion.ARGENTINA , Categoria.INFORMATICA, false));
		productos.add(new Producto("11","Producto 11", 134500.0f,OrigenFabricacion.URUGUAY , Categoria.INFORMATICA, true));
		productos.add(new Producto("12","Producto 12", 1121200.0f,OrigenFabricacion.CHINA , Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("13","Producto 13", 1756800.0f,OrigenFabricacion.CHINA , Categoria.TELEFONIA, false));
		productos.add(new Producto("14","Producto 14", 800.0f,OrigenFabricacion.BRASIL , Categoria.INFORMATICA, true));
		productos.add(new Producto("15","Producto 15", 700.0f,OrigenFabricacion.ARGENTINA , Categoria.INFORMATICA, true));
		

        boolean salir = false;
        while (!salir) {
            System.out.println("1 – Mostrar productos");
            System.out.println("2 – Mostrar los productos faltantes");
            System.out.println("3 – Incrementar los precios de los productos en un 20%");
            System.out.println("4 – Mostrar los productos que corresponden a la categoría Electrohogar");
            System.out.println("5 – Ordenar los productos por precio de forma descendente");
            System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
            System.out.println("7 - Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    productos.stream()
                            .filter(Producto::getEstado)
                            .forEach(System.out::println);
                    break;
                case 2:
                    productos.stream()
                            .filter(p -> !p.getEstado())
                            .forEach(System.out::println);
                    break;
                case 3:
                    productos = productos.stream()
                        .map(p -> new Producto(p.getCodigo(), p.getDescripcion(), p.getPrecio() * 1.2f, p.getOrigenFabricacion(), p.getCategoria(), p.getEstado()))
                        .collect(Collectors.toList());
                    break;
                case 4:
                    productos.stream()
                            .filter(p -> p.getCategoria()==Categoria.ELECTROHOGAR )
                            .forEach(System.out::println);
                    break;
                case 5:
                    productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
                    break;
                case 6:
                    productos.stream()
                            .map(p -> new Producto(p.getNombre().toUpperCase(), p.getPrecio(), p.getEstado()))
                            .forEach(System.out::println);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");

	}
   }
}
	}
