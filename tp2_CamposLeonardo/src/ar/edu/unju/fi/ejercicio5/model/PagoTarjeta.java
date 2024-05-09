package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;
	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto + monto * 0.15;
		
	}

	@Override
	public void imprimirRecibo() {
		 System.out.println("Número de tarjeta: " + numeroTarjeta);
	        System.out.println("Fecha de pago: " + fechaPago);
	        System.out.println("Monto pagado: " + montoPagado);
		
	}
public PagoTarjeta() {
}
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
	    this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
	 public void setNumeroTarjeta(String numeroTarjeta) {
	        this.numeroTarjeta = numeroTarjeta;
	    }

}
