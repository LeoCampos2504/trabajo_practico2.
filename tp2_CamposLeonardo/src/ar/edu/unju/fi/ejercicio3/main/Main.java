package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Población: " + provincia.getPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie());
            System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional());
            System.out.println();
        }
    }
}
