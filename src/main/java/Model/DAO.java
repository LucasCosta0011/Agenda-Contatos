package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

	// CRUD - CREATE //
	public void inserirContato(JavaBeans contato) {
		String sqlInserir = "INSERT INTO contatos (nome, tel, email) VALUES(?,?,?)";
		try {
			// Abrir a conexão
			Connection conexao = conectar();
			// Preparar a query para a execução no banco de dados
			PreparedStatement pst = conexao.prepareStatement(sqlInserir);
			// Substituir as binds (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTel());
			pst.setString(3, contato.getEmail());
			// Executar a query
			System.out.println(pst.executeUpdate());
			// Encerrar a conexão
			// Se não encerrar pode trazer problemas de
			// performace e segurança
			conexao.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	// teste de conexão
	public void testeConexao() {
		try {
			Connection conn = conectar();
			System.out.println(conn);
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
