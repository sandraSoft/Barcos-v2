package puertos.control;

import java.util.ArrayList;
import java.util.List;

import puertos.entidades.Barco;
import puertos.entidades.Carguero;
import puertos.entidades.Velero;

/**
 * Clase donde se registran los barcos que llegan al puerto,
 * y tiene la principales funciones del programa (es el control).
 * @version 3.0
 */
public class Puerto {

	private List<Barco> barcos;
	
	public Puerto() {
		barcos = new ArrayList<>();
	}
	
	/**
	 * Calcula la capacidad de todos los barcos en el puerto,
	 * para poder determinar la carga que puede recibir.
	 * @return	la capacidad total de los barcos, en m3
	 */
	public double calcularCapacidadTotal() {
		double capacidadTotal = 0;
		for (Barco barco : barcos) {
			capacidadTotal += barco.calcularCapacidad();
		}
		return capacidadTotal;
	}
	
	/**
	 * Se adiciona un barco al puerto, es decir, se registra su información y se guarda.
	 * @see puertos.entidades.Barco#Barco(String, String, double)
	 * @param tipo	qué tipo de barco es: 'v' para velero, 'c' para carguero
	 * @param pasajeros	la cantidad de pasajeros que lleva el barco (solo sirve para veleros)
	 * @param liquidos	indicación (true/false) de si puede llevar líquidos o no (solo aplica para cargueros)
	 * @return	un valor booleano indicando si se pudo adicionar el barco
	 * 			o no (porque ya existía otro con esa matrícula).
	 * @throws BarcoException cuando algunos de las reglas del negocio no se cumple
	 */
	public boolean adicionarBarco(String matricula, String nacionalidad, double volumen, 
			char tipo, int pasajeros, boolean liquidos) throws BarcoException {
		
		if (volumen <= 0 || volumen > 1000) {
			throw new BarcoException("Volumen incorrecto: debe estar entre cero y mil [0 - 1000]");
		}
		
		Barco barcoBuscado = buscarBarco(matricula);
		
		if (barcoBuscado == null) {
			switch (tipo) {
			  case 'v':
			  case 'V': 
				  return barcos.add(new Velero(matricula, nacionalidad, volumen, pasajeros));
			  case 'c':
			  case 'C':
				  return barcos.add(new Carguero(matricula, nacionalidad, volumen, liquidos));
			}
		}
		
		return false;
	}

	/**
	 * Busca un barco entre los que están registrados, por su número de matrícula
	 * @return el objeto barco con la matrícula dada, o null si no se encuentra
	 */
	public Barco buscarBarco(String matricula) {
		for (Barco barco : barcos) {
			if (barco.getMatricula().equals(matricula)) {
				return barco;
			}
		}
		return null;
	}
}
