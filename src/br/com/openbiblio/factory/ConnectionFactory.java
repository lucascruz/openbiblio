	// situa em qual package ou “pacote” está a classe
package br.com.openbiblio.factory;

	// faz as importações de classes necessárias para o funcionamento do programa	import java.sql.Connection; // conexão SQL para Java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// driver de conexão SQL para Java
// classe para tratamento de exceções

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
