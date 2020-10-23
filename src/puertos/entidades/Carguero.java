package puertos.entidades;

/**
 * Un barco que transporta carga entre puertos, tiene buena capacidad de carga
 * @version 2.0
 */
public class Carguero extends Barco {
	
	private boolean liquidos;

	/**
	 * @param matricula	el número de matrícula del barco, que lo identifica
	 * @param nacionalidad	la nacionalidad del barco (dada por el país de origen)
	 * @param volumen	el espacio total del barco, en m3
	 * @param liquidos	indicación (true/false) de si puede llevar líquidos o no
	 */
	public Carguero(String matricula, String nacionalidad, double volumen, boolean liquidos) {
		super(matricula, nacionalidad, volumen);
		this.liquidos = liquidos;
	}

	@Override
	public double calcularCapacidad() {
		double capacidad = getVolumen() * 0.8;
		if (liquidos) {
			capacidad-=40;
		}
		return capacidad;
	}
}
