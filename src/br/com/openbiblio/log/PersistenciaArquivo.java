package br.com.openbiblio.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
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
		this.usuarioFile = new File(dataDir.getPath() + "/usuarios.dat");
		this.livroFile = new File(dataDir.getPath() + "/livros.dat");
	}

	@Override
	public void salvar(Usuario user) throws PersistenciaException {
		StringBuilder line = new StringBuilder();
		line.append(user.getNome() + "*" + user.getTelefone() + "*"
				+ user.getEndereco() + "*" + user.getTipoUsuario() + "*"
				+ user.getMatricula() + "\n");

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

	@SuppressWarnings("resource")
	public List<Usuario> recuperarUsuarios() throws PersistenciaException {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		if (!usuarioFile.exists())
			return usuarios;
		System.out.println(usuarioFile.getAbsolutePath());
		int nlinha = 0;
		try {
			// Decorator na leitura
			FileInputStream in = new FileInputStream(usuarioFile);
			InputStreamReader is = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(is);
			String linha = reader.readLine();
			
			nlinha++;
			
			StringTokenizer tokens = new StringTokenizer(linha, "*");
			if (tokens.countTokens() != 5) {
				throw new PersistenciaException("Erro no formato do arquivo!\n Arquivo: "+ usuarioFile.toString() + "\n Linha: "+ nlinha);
			}
			Usuario user = new Usuario();
			user.setNome(tokens.nextToken());
			user.setTelefone(tokens.nextToken());
			user.setTipoUsuario(tokens.nextToken());
			user.setMatricula(tokens.nextToken());
			user.setEndereco(tokens.nextToken());
			usuarios.add(user);
			reader.close();
		} catch (Exception e) {
			throw new PersistenciaException("Erro ao ler o arquivo "
					+ usuarioFile.toString() + ", na linha:" + nlinha, e);
		}
		return usuarios;
	}

	@Override
	public List<Livro> recuperarLivros() throws PersistenciaException {
		List<Livro> livros = new ArrayList<Livro>();
		if (!livroFile.exists())
			return livros;
		int nlinha = 0;
		try {
			// Decorator area
			FileInputStream in2 = new FileInputStream(livroFile);
			InputStreamReader is2 = new InputStreamReader(in2);
			BufferedReader reader2 = new BufferedReader(is2);
			String linha = reader2.readLine();
			while ((linha = reader2.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha, "*");
				if (tokens.countTokens() != 4)
					throw new PersistenciaException(
							"Erro no formato do arquivo!\n Arquivo: "
									+ livroFile.toString() + "\n Linha: "
									+ nlinha);
				Livro livro = new Livro();
				livro.setEdicao(tokens.nextToken());
				livro.setTitulo(tokens.nextToken());
				livro.setTipo(tokens.nextToken());
				livro.setAutor(tokens.nextToken());
				livros.add(livro);
			}
			reader2.close();
		} catch (Exception e) {
			throw new PersistenciaException("Erro ao ler o arquivo "
					+ livroFile.toString() + ", na linha:" + nlinha, e);
		}
		return livros;
	}

}
