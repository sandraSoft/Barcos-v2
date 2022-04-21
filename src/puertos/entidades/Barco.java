package puertos.entidades;

/**
 * Información de un barco que llega a un puerto,
 * y del que se desea conocer su capacidad de carga.
 * 
 * @version 2.0
 */
public abstract class Barco {
	private String matricula;
	private String nacionalidad;
	private double volumen;

	/**
	 * @param matricula	el número de matrícula del barco, que lo identifica
	 * @param nacionalidad	la nacionalidad del barco (dada por el país de origen)
	 * @param volumen	el espacio total del barco, en m3
	 */
	public Barco(String matricula, String nacionalidad, double volumen) {
		this.matricula = matricula;
		this.nacionalidad = nacionalidad;
		this.volumen = volumen;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public double getVolumen() {
		return volumen;
	}

	/**
	 * Calcula la capacidad de carga del barco.
	 * @return	La capacidad de carga, en metros cúbicos
	 */
	public abstract double calcularCapacidad();	
}
