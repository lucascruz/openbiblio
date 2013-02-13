package br.com.openbiblio.log;

import java.util.List;

import br.com.openbiblio.exececoes.PersistenciaException;
import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.Usuario;

public interface Persistencia {

	public void salvar(Usuario u) throws PersistenciaException;

	public void salvar(Livro l) throws PersistenciaException;

	public List<Usuario> recuperarUsuarios() throws PersistenciaException;

	public List<Livro> recuperarLivros() throws PersistenciaException;
}
