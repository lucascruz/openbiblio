package br.com.openbiblio.exececoes;


public class OpenBiblioRuntimeException extends RuntimeException{
	public OpenBiblioRuntimeException(String message) {
		super(message);
	}

	public OpenBiblioRuntimeException(PersistenciaException cause) {
		super(cause);
	}

}
