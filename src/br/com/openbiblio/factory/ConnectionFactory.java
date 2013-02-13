	// situa em qual package ou �pacote� est� a classe
package br.com.openbiblio.factory;

	// faz as importa��es de classes necess�rias para o funcionamento do programa	import java.sql.Connection; // conex�o SQL para Java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// driver de conex�o SQL para Java
// classe para tratamento de exce��es

public class ConnectionFactory {
	    public Connection getConnection() {
	        try {
	            return DriverManager.getConnection("jdbc:mysql://localhost/openbiblio","root","12345");
	        }
	        catch(SQLException excecao) {
	            throw new RuntimeException(excecao);
	        }
	    }
}
