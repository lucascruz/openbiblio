package br.com.openbiblio.exececoes;


public class OpenBiblioRuntimeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpenBiblioRuntimeException(String message) {
		super(message);
	}

	public OpenBiblioRuntimeException(PersistenciaException cause) {
		super(cause);
	}

}
