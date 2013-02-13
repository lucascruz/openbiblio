package br.com.openbiblio.soft;
public class Livro {

	private String edicao,titulo,tipo,autor;

	public Livro(String edicao, String titulo, String tipo, String autor) {
		this.edicao = edicao;
		this.titulo = titulo;
		this.tipo = tipo;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
