package br.com.openbiblio.gui;

import java.io.IOException;

import br.com.openbiblio.exececoes.OpenBiblioException;
import br.com.openbiblio.exececoes.OpenBiblioRuntimeException;
import br.com.openbiblio.exececoes.PersistenciaException;
import br.com.openbiblio.log.Logger;
import br.com.openbiblio.log.PersistenciaFotos;
import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.OpenBiblioFacade;
import br.com.openbiblio.soft.Usuario;

public class OpenBiblio {
	private OpenBiblioFacade facade;

	public OpenBiblio() {
		this.facade = new OpenBiblioFacade();
	}

	public static void main(String[] args) {
		OpenBiblio ini = new OpenBiblio();
		ini.exibirMenu();
	}

	public void exibirMenu() {
		try {
			StringBuffer menu = new StringBuffer();
			menu.append("---- O P E N      B I B L I O ----\n");
			menu.append("    1 - Cadastrar Usuario\n");
			menu.append("    2 - Cadastrar Livro\n");
			menu.append("    3 - Listar Usuarios\n");
			menu.append("    4 - listar Livros\n");
			menu.append("    5 - Sair do Sistema\n");
			menu.append("Digite a op��o:");

			boolean fim = false;

			do {
				switch (Util.lerInteiro(menu.toString())) {
				case 1:
					cadastrarUsuario();
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
					Util.alert("Op��o inv�lida!");
				}
			} while (!fim);
		} catch (Throwable e) {
			Logger.getInstance().log(e);
			Util.alert("Erro do sistema. Ta pegando aqui suporte!");
		}
	}

	private void listarLivros() throws PersistenciaException {
		StringBuilder msg = new StringBuilder();
		try {
			msg.append(facade.listarLivros().toString());

		} catch (OpenBiblioRuntimeException e) {
			Logger.getInstance().log(e);
			msg.append("Erro ao recuperar livros. Ligue para o suporte \n");
		}
		Util.alert(msg.toString());

	}

	private void listarUsuarios() throws PersistenciaException {
		StringBuilder msg = new StringBuilder();
		try {
			msg.append(facade.listarUsuarios().toString());

		} catch (OpenBiblioRuntimeException e) {
			Logger.getInstance().log(e);
			msg.append("Erro ao recuperar usuarios. Ligue para o suporte \n");
		}
		Util.alert(msg.toString());
	}

	private void cadastrarLivro() {
		String titulo = Util.lerString("Titulo:");
		String autor = Util.lerString("Autor:");
		int tipoInt = Util.lerInteiro("Tipo:\n1-Livro, 2-TCC, 3-Peri�dico");

		String tipo = null;
		if (tipoInt > 3 && tipoInt < 1) {
			while (tipoInt > 3 && tipoInt < 1) {
				tipoInt = Util
						.lerInteiro("Tente novamente!\n1-Livro, 2-TCC, 3-Peri�dico");
			}
		} else {
			if (tipoInt == 1)
				tipo = "LIVRO";
			else if (tipoInt == 2)
				tipo = "TCC";
			else if (tipoInt == 3)
				tipo = "PERIODICO";
		}

		String edicao = Util.lerString("Edi��o:");
		Livro l = null;

		try {
			l = facade.criarLivro(edicao, titulo, tipo, autor);
			if (l != null)
				Util.alert("Livro cadastrado com sucesso!\n" + l.getTitulo()
						+ "\n" + l.getAutor());
			else
				Util.alert("�guia!");
		} catch (OpenBiblioException e1) {
			Util.alert(e1.getMessage());
		} catch (PersistenciaException e2) {
			Util.alert("Erro na grava��o do arquivo! Tente novamente ou chame o suporte.");
			Logger.getInstance().log(e2);
		}
	}

	private void cadastrarUsuario() {
		String nome = Util.lerString("Nome:");
		String telefone = Util.lerString("Telefone:");
		int tipoInt = Util
				.lerInteiro("Tipo:\n1-ALUNO, 2-PROFESSOR, 3-FUNCION�RIO");

		String tipo = null;
		if (tipoInt > 3 && tipoInt < 1) {
			while (tipoInt > 3 && tipoInt < 1) {
				tipoInt = Util
						.lerInteiro("Tente novamente!\n1-ALUNO, 2-PROFESSOR, 3-FUNCIONARIO");
			}
		} else {
			if (tipoInt == 1)
				tipo = "ALUNO";
			else if (tipoInt == 2)
				tipo = "PROFESSOR";
			else if (tipoInt == 3)
				tipo = "FUNCIONARIO";
		}

		String matricula = Util.lerString("Matricula:");
		String endereco = Util.lerString("Endereco:");
		Util.alert("Busque a foto do aluno\n");
		try {
			PersistenciaFotos.salvaFoto();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario u;

		try {
			u = facade.criarUsuario(nome, telefone, endereco, tipo, matricula);
			if (u != null)
				Util.alert("Usuario cadastrado com sucesso!\n" + u.getNome()
						+ "\n" + u.getTelefone());
			else
				Util.alert("�guia!");
		} catch (OpenBiblioException e1) {
			Util.alert(e1.getMessage());
		} catch (PersistenciaException e2) {
			Util.alert("Erro na grava��o do arquivo! Tente novamente ou chame o suporte.");
			Logger.getInstance().log(e2);
		}

	}
}
