package br.com.openbiblio.soft;
import java.util.Iterator;
import java.util.List;

import br.com.openbiblio.exececoes.OpenBiblioException;
import br.com.openbiblio.exececoes.PersistenciaException;
import br.com.openbiblio.log.Persistencia;
import br.com.openbiblio.log.PersistenciaMemoria;

public class OpenBiblioFacade {

		private Persistencia persistencia;

		public void BibliotecaFacade(){
			persistencia = new PersistenciaMemoria();
		}

		public Iterator <Usuario> getUsuariosIterator() throws PersistenciaException{
			return persistencia.recuperarUsuarios().iterator();
		}

		public Iterator <Livro> getProfessoresIterator() throws PersistenciaException{
			return persistencia.recuperarLivros().iterator();
		}

		public Usuario criarUsuario(String nome, String telefone, String endereco, String tipo,
				String matricula)
				throws PersistenciaException,OpenBiblioException{

			Usuario u =  new Usuario(nome, telefone,endereco, tipo, matricula);
			persistencia.salvar(u);
			return u;
		}

		public List<Usuario> listarUsuarios() throws PersistenciaException{
			List<Usuario> users = persistencia.recuperarUsuarios();
			return users;
		}

		public Livro criarLivro(String edicao, String titulo, String tipo, String autor)
				throws PersistenciaException,OpenBiblioException{

			Livro l =  new Livro(edicao,titulo,tipo,autor);
			persistencia.salvar(l);
			return l;
		}

		public List<Livro> listarLivros() throws PersistenciaException{
			List<Livro> livros = persistencia.recuperarLivros();
			return livros;
		}
}
