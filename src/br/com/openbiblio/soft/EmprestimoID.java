package br.com.openbiblio.soft;

import java.io.Serializable;

public class EmprestimoID implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private Livro livro;
	
	public EmprestimoID() { }
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
    public boolean equals(Object arg0) {
        return super.equals(arg0);
    }

    public int hashCode() {
        return super.hashCode();
    }
}