package br.com.openbiblio.soft;
import java.util.List;

import br.com.openbiblio.dao.EmprestimoDAO;
import br.com.openbiblio.dao.EstoqueDAO;
import br.com.openbiblio.dao.LivroDAO;
import br.com.openbiblio.dao.UsuarioDAO;

public class BibliotecaPadrao {
	

		public boolean cadastrarUsuario(Usuario usuario) {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			return usuarioDAO.inserir(usuario);
		}


		public boolean excluirUsuario(int id) {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			return usuarioDAO.excluir(id);
		}


		public List<Usuario> listarUsuarios() {
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			return usuarioDAO.listar();
		}
		

		public boolean inserirLivro(Livro livro, Editora editora) {
			
			LivroDAO livroDAO = new LivroDAO();
			return livroDAO.inserir(livro, editora);
		}
		

		public boolean excluirLivro(String isbn) {
			
			LivroDAO livroDAO = new LivroDAO();
			return livroDAO.excluir(isbn);
		}


		public List<Livro> selecionarTodosLivros() {

			LivroDAO livroDAO = new LivroDAO();
			return livroDAO.listar();
		}
		

		public boolean adicionarLivroEstoque(String isbn, int quantidade) {

			EstoqueDAO estoqueDAO = new EstoqueDAO();
			LivroDAO livroDAO = new LivroDAO();
			
			Livro livro = livroDAO.localizar(isbn);
			return estoqueDAO.inserir(livro, quantidade);
		}


		public boolean removerLivroEstoque(String isbn, int quantidade) {

			EstoqueDAO estoqueDAO = new EstoqueDAO();
			return estoqueDAO.excluir(isbn, quantidade);
		}
		

		public int buscarQuantidade(String isbn) {

			EstoqueDAO estoqueDAO = new EstoqueDAO();
			LivroDAO livroDAO = new LivroDAO();
			
			Livro livro = livroDAO.localizar(isbn);
			return estoqueDAO.buscarQuantidade(livro);
		}


		public boolean retirarLivro(String isbnLivro, int idUsuario) {

			EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
			LivroDAO livroDAO = new LivroDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			Livro livro = livroDAO.localizar(isbnLivro);
			Usuario usuario = usuarioDAO.localizar(idUsuario);
			return emprestimoDAO.retirar(livro, usuario);
		}


		public boolean devolverLivro(String isbnLivro, int idUsuario) {

			EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
			LivroDAO livroDAO = new LivroDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			Livro livro = livroDAO.localizar(isbnLivro);
			Usuario usuario = usuarioDAO.localizar(idUsuario);
			return emprestimoDAO.devolver(livro, usuario);
		}
		

		public Emprestimo consultarEmprestimo(String isbnLivro, int idUsuario) {

			EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
			LivroDAO livroDAO = new LivroDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			Livro livro = livroDAO.localizar(isbnLivro);
			Usuario usuario = usuarioDAO.localizar(idUsuario);
			return emprestimoDAO.consultar(livro, usuario);
		}


		public List<Livro> localizarLivro(int idUsuario) {

			EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			Usuario usuario = usuarioDAO.localizar(idUsuario);
			return emprestimoDAO.localizar(usuario);
		}
		

		public List<Usuario> localizarUsuario(String isbnLivro) {

			EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
			LivroDAO livroDAO = new LivroDAO();
			
			Livro livro = livroDAO.localizar(isbnLivro);
			return emprestimoDAO.localizar(livro);
		}
	}
