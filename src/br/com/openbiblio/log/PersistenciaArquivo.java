package br.com.openbiblio.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.com.openbiblio.exececoes.PersistenciaException;
import br.com.openbiblio.soft.Livro;
import br.com.openbiblio.soft.Usuario;

public class PersistenciaArquivo implements Persistencia {

	private static File dataDir;
	static {
		URL url = PersistenciaArquivo.class.getResource("/");
		File classesDir = new File(url.getPath());
		dataDir = new File(classesDir.getParentFile().getPath() + "/data");

		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
	}

	private File usuarioFile;
	private File livroFile;

	public PersistenciaArquivo() {
		usuarioFile = new File(dataDir.getPath() + "/usuarios.ser");
		livroFile = new File(dataDir.getPath() + "/livros.ser");
	}

	@Override
	public void salvar(Usuario user) throws PersistenciaException {
		StringBuilder line = new StringBuilder();
		line.append(user.getNome() + "*" + user.getTelefone() + "*"
				+ user.getTipoUsuario() + "*" + user.getMatricula() + "\n");

		try {
			FileWriter out = new FileWriter(usuarioFile, true);
			out.write(line.toString());
			out.close();
		} catch (IOException e) {
			throw new PersistenciaException(e);
		}
	}

	@Override
	public void salvar(Livro livro) throws PersistenciaException {
		StringBuilder line = new StringBuilder();
		line.append(livro.getEdicao() + "*" + livro.getTitulo() + "*"
				+ livro.getTipo() + "*" + livro.getAutor() + "\n");

		try {
			FileWriter out = new FileWriter(livroFile, true);
			out.write(line.toString());
			out.close();
		} catch (IOException e) {
			throw new PersistenciaException(e);
		}
	}

	@Override
	@SuppressWarnings({ "resource", "null" })
	public List<Usuario> recuperarUsuarios() throws PersistenciaException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if (!usuarioFile.exists())
			return usuarios;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(usuarioFile);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String linha;
			while ((linha = reader.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha, "*");
				if (tokens.countTokens() != 5)
					throw new PersistenciaException(
							"Erro no formato do arquivo!\n Arquivo: "
									+ usuarioFile.toString() + "\n Linha: "
									+ nlinha);
				Usuario user = null;
				user.setNome(tokens.nextToken());
				user.setTelefone(tokens.nextToken());
				user.setTipoUsuario(tokens.nextToken());
				user.setMatricula(tokens.nextToken());

				usuarios.add(user);
			}
			reader.close();
		} catch (Exception e) {
			throw new PersistenciaException("Erro ao ler o arquivo "
					+ usuarioFile.toString() + ", na linha:" + nlinha, e);
		}
		return usuarios;
	}

	@Override
	@SuppressWarnings({ "null", "resource" })
	public List<Livro> recuperarLivros() throws PersistenciaException {
		List<Livro> livros = new ArrayList<Livro>();
		if (!livroFile.exists())
			return livros;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(livroFile);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String linha;
			while ((linha = reader.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha, "*");
				if (tokens.countTokens() != 4)
					throw new PersistenciaException(
							"Erro no formato do arquivo!\n Arquivo: "
									+ livroFile.toString() + "\n Linha: "
									+ nlinha);
				Livro livro = null;
				livro.setEdicao(tokens.nextToken());
				livro.setTitulo(tokens.nextToken());
				livro.setTipo(tokens.nextToken());
				livro.setAutor(tokens.nextToken());

				livros.add(livro);
			}
			reader.close();
		} catch (Exception e) {
			throw new PersistenciaException("Erro ao ler o arquivo "
					+ livroFile.toString() + ", na linha:" + nlinha, e);
		}
		return livros;
	}

}
