package puertos.entidades;

/**
 * Un barco deportivo, que lleva pasajeros, no tiene mucha capacida de carga.
 * @version 2.0
 */
public class Velero extends Barco
{
	private int pasajeros;

	/**
	 * @param matricula	el número de matrícula del barco, que lo identifica
	 * @param nacionalidad	la nacionalidad del barco (dada por el país de origen)
	 * @param volumen	el espacio total del barco, en m3
	 * @param pasajeros	la cantidad de pasajeros que lleva el barco
	 */
	public Velero(String matricula, String nacionalidad, double volumen, int pasajeros) {
		super(matricula, nacionalidad, volumen);
		this.pasajeros = pasajeros;
	}
	
	@Override
	public double calcularCapacidad() {
		double capacidad = getVolumen() * 0.5;
		if (pasajeros > 10) {
			capacidad-=10;
		}
		return capacidad;
	}		
}
