package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	// Alt + shift + y QUEBRA AUTO LINHA
	private String url = "jdbc:mysql://localhost/agendacontatosdb?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "8C3aN75m";
	
	// Métodos de conexão
	private Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// teste de conexão
	public void testeConexao() {
		try {
			Connection conn = conectar();
			System.out.println(conn);
			//conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
