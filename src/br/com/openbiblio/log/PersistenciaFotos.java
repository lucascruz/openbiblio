package br.com.openbiblio.log;

import java.io.File;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PersistenciaFotos {

	@SuppressWarnings("resource")
	public static void salvaFoto() throws IOException {
		File arquivoFoto = null;
		boolean valida = false;
		JFileChooser arquivo = new javax.swing.JFileChooser();
		arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
		int resultadoArq = arquivo.showSaveDialog(arquivo);
		if (resultadoArq == javax.swing.JFileChooser.APPROVE_OPTION)
			;
		arquivoFoto = arquivo.getSelectedFile();
		if (arquivoFoto == null) {
			return;
		}
		do {
			String pathImagem = arquivoFoto.getAbsolutePath();
			if (!pathImagem.endsWith(".jpg") && !pathImagem.endsWith(".png")
					&& !pathImagem.endsWith(".jpeg")) {
				JOptionPane
						.showMessageDialog(
								null,
								"O ficheiro fornecido não é válido.\nForneça apenas ficheiros com extensão .jpg, .png ou .gif",
								"Erro, extensão do ficheiro inválida",
								JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				JOptionPane.showMessageDialog(null,
						"O arquivo foi salvo com exito!");
				valida = true;
			} catch (Exception exp) {
				JOptionPane.showMessageDialog(null,
						"N�o foi possivel salvar o arquivo!");
			}
		} while (valida != true);

		new FileImageOutputStream(arquivo.getSelectedFile());
	}

}
