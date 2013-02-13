package br.com.openbiblio.exececoes;


@SuppressWarnings("serial")
public class EntradaInvalidaException extends RuntimeException{
	public EntradaInvalidaException(){
		super();
	}

	public EntradaInvalidaException(String msg){
		super(msg);
	}

	public EntradaInvalidaException(Throwable e) {
		super(e);
	}

	public EntradaInvalidaException(String entrada, Throwable e) {
		super(entrada,e);
	}

}
