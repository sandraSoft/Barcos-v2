package puertos.control;

/**
 * Excepciones relacionadas con el registro de barcos en el puerto,
 * expecialmente por no cumplir alguna regla del negocio
 * @version 1.0
 */
public class BarcoException extends Exception {

	public BarcoException(String mensaje) {
		super(mensaje);
	}
}
