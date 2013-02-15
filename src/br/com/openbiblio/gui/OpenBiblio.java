package br.com.openbiblio.gui;

//import java.io.IOException;

import java.util.Iterator;

import br.com.openbiblio.exececoes.OpenBiblioException;
import br.com.openbiblio.exececoes.OpenBiblioRuntimeException;
import br.com.openbiblio.exececoes.PersistenciaException;
import br.com.openbiblio.log.Logger;
import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.OpenBiblioFacade;
import br.com.openbiblio.soft.Usuario;
//import br.com.openbiblio.log.PersistenciaFotos;

public class OpenBiblio {
	
	private OpenBiblioFacade facade;

	public OpenBiblio() {
		this.facade = new OpenBiblioFacade();
	}

	public void exibirMenu() {
		try {
			StringBuffer menu = new StringBuffer();
			menu.append("||||||||||||||| O P E N      B I B L I O ||||||||||||||\n");
			menu.append("\t1 - Cadastrar Usuario\n");
			menu.append("\t2 - Cadastrar Livro\n");
			menu.append("\t3 - Listar Usuarios\n");
			menu.append("\t4 - Listar Livros\n");
			menu.append("\t5 - Sair do Sistema\n");
			menu.append("Digite a opcao:");

			boolean fim = false;

			while(!fim){
				switch (Util.lerInteiro(menu.toString())) {
					case 1:
						cadastrarUsuario(); //Ok
						break;
					case 2:
						cadastrarLivro();
						break;
					case 3:
						listarUsuarios();
						break;
					case 4:
						listarLivros();
						break;
					case 5:
						Util.alert("Encerrando..");
						fim = true;
						break;
					default:
						Util.alert("Opcao Invalida!");
				}
			} 
		} catch (Throwable e) {
			Logger.getInstance().log(e);
			Util.alert("Erro do sistema. Ta pegando aqui suporte!");
			e.printStackTrace();
		}
	}

	private void listarLivros() throws PersistenciaException {
		StringBuilder msg = new StringBuilder();
		Livro livros;
		Iterator<Livro> it = facade.getLivrosIterator();
		msg.append(">>>> Lista de Livros" + "<<<<<\n");
		while (it.hasNext()) {
			livros = it.next();
			msg.append(livros.getTitulo() + " \t| "
					+ livros.getAutor() + "\n");
		}
		
		try {
			msg.append(facade.listarUsuarios().toString());

		} catch (OpenBiblioRuntimeException e) {
			Logger.getInstance().log(e);
			msg.append("Erro ao recuperar usuarios. Ligue para o suporte \n");
		}
		Util.alert(msg.toString());
	}

	private void listarUsuarios() throws PersistenciaException {
		StringBuilder msg = new StringBuilder();
		Usuario usuario;
		Iterator<Usuario> it = facade.getUsuariosIterator();
		msg.append(">>>> Lista Usuario" + "<<<<<\n");
		while (it.hasNext()) {
			usuario = it.next();
			msg.append(usuario.getMatricula() + " \t| "
					+ usuario.getNome() + "\n");
		}
		
		try {
			//msg.append(facade.listarUsuarios().toString());
			

		} catch (OpenBiblioRuntimeException e) {
			Logger.getInstance().log(e);
			msg.append("Erro ao recuperar usuarios. Ligue para o suporte \n");
		}
		Util.alert(msg.toString());
	}

	private void cadastrarLivro() {
		String titulo = Util.lerString("Titulo:");
		String autor = Util.lerString("Autor:");
		int tipoInt = Util.lerInteiro("Tipo:\n1-Livro, 2-TCC, 3-Periodico");
		String tipo = null;
		if (tipoInt > 3 || tipoInt < 1) {
			while (tipoInt > 3 || tipoInt < 1) {
				tipoInt = Util
						.lerInteiro("Tente novamente!\n1-Livro, 2-TCC, 3-Periodico");
			}
		} else {
			if (tipoInt == 1)
				tipo = "LIVRO";
			else if (tipoInt == 2)
				tipo = "TCC";
			else if (tipoInt == 3)
				tipo = "PERIODICO";
		}

		String edicao = Util.lerString("Edicao:");
		Livro l = null;

		try {
			l = facade.criarLivro(edicao, titulo, tipo, autor);
			if (l != null)
				Util.alert("Livro cadastrado com sucesso!\n" + l.getTitulo()
						+ "\n" + l.getAutor());
		} catch (OpenBiblioException e1) {
			Util.alert(e1.getMessage());
		} catch (PersistenciaException e2) {
			Util.alert("Erro na gravacao do arquivo! Tente novamente ou chame o suporte.");
			Logger.getInstance().log(e2);
		}
	}

	private void cadastrarUsuario() {
		
		StringBuffer menu = new StringBuffer();
		String nome = Util.lerString("Nome:");
		menu.append(nome);
		String telefone = Util.lerString("Telefone:");
		String tipo = null;
		int tipoInt = Util.lerInteiro("Tipo:\n1-ALUNO, 2-PROFESSOR, 3-FUNCIONARIO");
		while((tipoInt > 3 || tipoInt < 1)){
			tipoInt = Util.lerInteiro("Tipo:\n1-ALUNO, 2-PROFESSOR, 3-FUNCIONARIO");
		}
		if (tipoInt > 3 || tipoInt < 1);
			if (tipoInt == 1)
					tipo = "ALUNO";
			else if (tipoInt == 2)
					tipo = "PROFESSOR";
			else if (tipoInt == 3)
					tipo = "FUNCIONARIO";

		String matricula = Util.lerString("Matricula:");
		String endereco = Util.lerString("Endereco:");
		Usuario u = facade.criarUsuario(nome, telefone, endereco, tipo, matricula);
		if (u != null)
			Util.alert("Usuario cadastrado com sucesso!\n" + u.getNome()
					+ "\n" + u.getTelefone());
		else
			Util.alert("ERRO 404");
			
	}
	
	public static void main(String[] args) {
		OpenBiblio ini = new OpenBiblio();
		ini.exibirMenu();
	}
}
