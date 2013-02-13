package br.com.openbiblio.soft;
public class Usuario {

	protected String nome;

	protected String endereco;

	protected String tipoUsuario;

	protected String telefone;

	protected int id;

	protected int contador;

	private String matricula;



	public Usuario(String nome, String telefone, String endereco, String tipo,
			String matricula) {
		this.setNome(nome);
		this.setTipoUsuario(tipo);
		this.setTelefone(telefone);
		this.setMatricula(matricula);
		this.setEndereco(endereco);
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipo) {
		this.tipoUsuario = tipo;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public  int getContador() {
		return this.contador;
	}


	public void setContador(int contador) {
		this.contador = contador;
	}



	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
