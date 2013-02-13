package br.com.openbiblio.log;

	import java.util.ArrayList;
import java.util.List;

import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.Usuario;

	public class PersistenciaMemoria implements Persistencia {
		private List<Usuario> usuarios;
		private List<Livro> livros;

		public PersistenciaMemoria(){
			usuarios = new ArrayList<Usuario>();
			livros = new ArrayList<Livro>();
		}

		@Override
		public void salvar(Usuario usuario) {
			this.usuarios.add(usuario);
		}

		@Override
		public List<Usuario> recuperarUsuarios() {
			return usuarios;
		}

		@Override
		public void salvar(Livro livro) {
			this.livros.add(livro);
		}

		@Override
		public List<Livro> recuperarLivros() {
			return livros;
		}
	}
