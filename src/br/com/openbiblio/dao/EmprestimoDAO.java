package br.com.openbiblio.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.openbiblio.soft.Emprestimo;
import br.com.openbiblio.soft.EmprestimoID;
import br.com.openbiblio.soft.Estoque;
import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.Usuario;

public class EmprestimoDAO extends GenericDAO<Emprestimo> {

	public boolean retirar(Livro livro, Usuario usuario) {

		
		boolean result = false;

		EmprestimoID emprestimoID = new EmprestimoID();
		Emprestimo emprestimo = new Emprestimo();
		
		try {

			
			result = true;

		} catch (Exception e) {

		
		}
		
		return result;
	}

	public boolean devolver(Livro livro, Usuario usuario) {

		
		boolean result = false;

		Estoque estoque = new Estoque();
		EmprestimoID emprestimoID = new EmprestimoID();
		Emprestimo emprestimo = null;
		
		
		try {


			if (emprestimo.getDtDevolucao() == null) { 

				result = true;
				
			} else { 
				
				result = false;
			}


		} catch (Exception e) {


		}
		
		return result;
	}

	public Emprestimo consultar(Livro livro, Usuario usuario) {

		
		Emprestimo result = null;
		EmprestimoID emprestimoID = new EmprestimoID();
		
		try {


		} catch (Exception e) {


		}
		
		return result;
	}

	public List<Livro> localizar(Usuario usuario) {

		List<Livro> result = new ArrayList<Livro>();
		List<Emprestimo> emprestimoItems = null;
		return result;

	}

	public List<Usuario> localizar(Livro livro) {


		List<Usuario> result = new ArrayList<Usuario>();
		List<Emprestimo> emprestimoItems = null;
		
		try {
			
			for (Emprestimo emprestimo : emprestimoItems) {

				result.add(emprestimo.getEmprestimoID().getUsuario());
			}
	
		} catch (Exception e) {
	
			
		}
		
		return result;
	}
}
