package br.com.openbiblio.dao;

import br.com.openbiblio.soft.Editora;
import br.com.openbiblio.soft.Livro;


public class LivroDAO extends GenericDAO<Livro> {
	
	public Livro localizar(String isbn) {

		Livro livro = null;
		
		try {


		} catch (Exception e) {

		} finally {

		}

		return livro;
	}

	public boolean inserir(Livro livro, Editora editora) {


		boolean result = false;

		
		try {

			try {

			} catch(Exception e) { }

			try {

			} catch(Exception e) { }
			
			livro.setEditora(editora);
			
			result = true;

		} catch (Exception e) {


		} finally {


		}
		
		return result;
	}

	public boolean excluir(String isbn) {

		Livro livro = null;
		boolean result = false;

		try {

			result = true;

		} catch (Exception e) {

		} finally {

		}
		
		return result;
	}
}
