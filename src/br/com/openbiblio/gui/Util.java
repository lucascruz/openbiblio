package br.com.openbiblio.gui;

import javax.swing.JOptionPane;

import br.com.openbiblio.exececoes.EntradaInvalidaException;


public class Util {

	public static String lerString(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		String entrada = "";
		do{
			entrada = JOptionPane.showInputDialog(msg);
			if(entrada == null || entrada.equals(""))
				alert("Entrada inv�lida!");
			else
				fim = true;
		}while(!fim);
		return entrada;
	}

	public static int lerInteiro(String msg) throws EntradaInvalidaException {
		boolean fim = false;
		int valor = 0;
		do{
			try{
				String entrada = lerString(msg);
				valor = Integer.parseInt(entrada);
				fim = true;
			}catch(Exception e){
				alert("Entrada inv�lida!");
			}
		}while(!fim);
		return valor;
	}


	public static void alert(String msg){
		JOptionPane.showMessageDialog(null,msg);
	}

}