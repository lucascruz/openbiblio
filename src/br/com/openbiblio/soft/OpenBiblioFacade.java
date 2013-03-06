package br.com.openbiblio.soft;

import java.util.Iterator;
import java.util.List;

import br.com.openbiblio.exececoes.OpenBiblioException;
import br.com.openbiblio.exececoes.OpenBiblioRuntimeException;
import br.com.openbiblio.exececoes.PersistenciaException;
import br.com.openbiblio.log.Persistencia;
import br.com.openbiblio.log.PersistenciaArquivo;
//import br.com.openbiblio.log.PersistenciaMemoria;


public class OpenBiblioFacade {

	private Persistencia persistencia;

	public OpenBiblioFacade() {
		persistencia = new PersistenciaArquivo();
	}

	public Iterator<Usuario> getUsuariosIterator() throws PersistenciaException {
		return persistencia.recuperarUsuarios().iterator();
	}

	public Iterator<Livro> getLivrosIterator()
			throws PersistenciaException {
		return persistencia.recuperarLivros().iterator();
	}

	public Usuario criarUsuario(String nome, String telefone, String endereco,
			String tipo, String matricula){

		Usuario u = new Usuario(nome, telefone, endereco, tipo, matricula);
		try {
			persistencia.salvar(u);
		} catch (PersistenciaException e) {
			throw new OpenBiblioRuntimeException(e);
		}
		return u;
	}

	public List<Usuario> listarUsuarios() throws PersistenciaException {
		List<Usuario> users = persistencia.recuperarUsuarios();
		return users;
	}

	public Livro criarLivro(String edicao, String titulo, String tipo,
			String autor) throws PersistenciaException, OpenBiblioException {

		//Livro l = new Livro(edicao, titulo, tipo, autor);
		//persistencia.salvar(l);
		//return l;
		return null;
	}

	public List<Livro> listarLivros() throws PersistenciaException {
		List<Livro> livros = persistencia.recuperarLivros();
		return livros;
	}

}
