package br.com.openbiblio.log;


import java.util.LinkedList;
import java.util.List;

import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.Usuario;

	public class PersistenciaMemoria implements Persistencia {
		private List<Usuario> usuarios;
		private List<Livro> livros;

		public PersistenciaMemoria(){
			usuarios = new LinkedList<Usuario>();
			livros = new LinkedList<Livro>();
		}
		 
		public void salvar(Usuario usuario) {
			this.usuarios.add(usuario);
		}

		 
		public List<Usuario> recuperarUsuarios() {
			return usuarios;
		}

		 
		public void salvar(Livro livro) {
			this.livros.add(livro);
		}

		 
		public List<Livro> recuperarLivros() {
			return livros;
		}
	}
