package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio7.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio7.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio7.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoSalvaje felino = new FelinoSalvaje("Tanner", (byte)20, 186f);
        Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());

        if (Converter.isNotNull(felino)) {
            FelinoDomestico gato = converter.convert(felino);
            converter.mostrarObjeto(gato);
        }
	}

}
