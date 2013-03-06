package br.com.openbiblio.dao;



import java.util.List;

import br.com.openbiblio.soft.Estoque;
import br.com.openbiblio.soft.Livro;

public class EstoqueDAO extends GenericDAO<Estoque> {

public int buscarQuantidade(Livro livro) {


		int result = 0;

		try {


		} catch (Exception e) {


		} finally {

		}
		
		return result;
	}

public boolean inserir(Livro livro, int quantidade) {

		boolean result = false;
		Estoque estoque = null;

		return result;
	}

	public boolean excluir(String isbn, int quantidade) {

		boolean result = false;
		List<Estoque> estoqueItems = null;
		Livro livro = null;
		Estoque estoque = null;

			estoqueItems = livro.getEstoqueItems();
			
			while (quantidade > 0 && estoqueItems.size() != 0) {
				
				estoque = estoqueItems.get(estoqueItems.size() - 1);
				estoqueItems.remove(estoque);

				quantidade--;
			}
		
		return result;

}
}