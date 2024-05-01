package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(770881, 53219),
    SALTA(1333365, 155488),
    TUCUMAN(1681302, 22524),
    CATAMARCA(396895, 102602),
    LA_RIOJA(393531, 89680),
    SANTIAGO_DEL_ESTERO(896461, 136351);

    private int poblacion;
    private int superficie;

    Provincia(int poblacion, int superficie) {
        this.poblacion = poblacion;
        this.superficie = superficie;
    }

  
    public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

    public double calcularDensidadPoblacional() {
        return (double) poblacion / superficie;
    }
}

