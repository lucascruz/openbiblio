package br.com.openbiblio.soft;


public class Estoque {


	private int idEstoque;

	private Livro livro;
	
	
	public Estoque() { }

	public int getIdnoEstoque() {
		return idEstoque;
	}

	public void setIdnoEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
