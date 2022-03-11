package puertos.control;

import java.util.ArrayList;
import java.util.List;

import puertos.entidades.Barco;
import puertos.entidades.Carguero;
import puertos.entidades.Velero;

/**
 * Clase donde se registran los barcos que llegan al puerto, y tiene la
 * principales funciones del programa (es el control).
 * 
 * @version 3.5
 */
public class ControlPuerto {

	private List<Barco> barcos;
	private final double VOLUMEN_MAXIMO = 1000;

	public ControlPuerto() {
		barcos = new ArrayList<>();
	}

	/**
	 * Calcula la capacidad de todos los barcos en el puerto, 
	 * para poder determinar la carga que puede recibir.
	 * 
	 * @return la capacidad total de los barcos, en m3
	 */
	public double calcularCapacidadTotal() {
		double capacidadTotal = 0;
		for (Barco barco : barcos) {
			capacidadTotal += barco.calcularCapacidad();
		}
		return capacidadTotal;
	}

	/**
	 * Se adiciona un barco al puerto, es decir, se registra su información y se
	 * guarda.
	 * 
	 * @see puertos.entidades.Barco#Barco(String, String, double)
	 * @param tipo      qué tipo de barco es: 'v' para velero, 'c' para carguero
	 * @param pasajeros la cantidad de pasajeros que lleva el barco 
	 * 					(solo sirve para veleros)
	 * @param liquidos  indicación (true/false) de si puede llevar líquidos o no
	 *                  (solo aplica para cargueros)
	 * @throws BarcoException cuando algunos de las reglas del negocio no se cumple
	 */
	public void adicionarBarco(String matricula, String nacionalidad, double volumen, char tipo, 
			int pasajeros, boolean liquidos) throws BarcoException {

		if (existeMatricula(matricula)) {
			throw new BarcoException("No se puede guardar: " +
					"Ya existe un barco registrado con esa matrícula");
		}

		if (!esVolumenPermitido(volumen)) {
			throw new BarcoException("Volumen incorrecto: " +
					"debe estar entre 0 y " + VOLUMEN_MAXIMO);
		}

		switch (tipo) {
		case 'v':
		case 'V':
			barcos.add(new Velero(matricula, nacionalidad, volumen, pasajeros));
			break;
		case 'c':
		case 'C':
			barcos.add(new Carguero(matricula, nacionalidad, volumen, liquidos));
			break;
		}
	}

	/**
	 * Valida si la matrícula está o no registrada en el puerto.
	 * 
	 * @return true si la matrícula ya existe (ya hay un barco registrado) 
	 * 			o false si no existe (es decir, no hay registro).
	 */
	private boolean existeMatricula(String matricula) {
		for (Barco barco : barcos) {
			if (barco.getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Valida que el volumen de un barco se conserve en los rangos permitidos
	 * 
	 * @param volumen el volumen que se desea evaluar
	 * @return si el volumen es aceptado o no
	 */
	private boolean esVolumenPermitido(double volumen) {
		if (volumen < 0 || volumen > VOLUMEN_MAXIMO) {
			return false;
		}
		return true;
	}
}
