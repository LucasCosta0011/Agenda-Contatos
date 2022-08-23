package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	// connection parameters
	private String driver = "com.mysql.cj.jdbc.Driver";
	// Alt + shift + y QUEBRA AUTO LINHA
	private String url = "jdbc:mysql://localhost/agendacontatosdb?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "${PASS}";

	/** connection method **/
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
	
	// CRUD - DELETE //
	public void excluirContato(JavaBeans contato) {
		String sqlExcluir = "DELETE FROM contatos WHERE id = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(sqlExcluir);
			pst.setInt(1, contato.getId());
			pst.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// CRUD - UPDATE //
	public void alterarContato(JavaBeans contato) {
		String sqlAlterar = "UPDATE contatos SET nome=?, tel=?, email=? WHERE id = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(sqlAlterar);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTel());
			pst.setString(3, contato.getEmail());
			pst.setInt(4, contato.getId());
			
			System.out.println(pst.executeUpdate());
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// CRUD - READ //
	// Selecionar contato //
	public void selecionarContato(JavaBeans contato) {
		String sqlBuscarContato = "SELECT * FROM contatos WHERE id LIKE ?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(sqlBuscarContato);
			pst.setInt(1, contato.getId());
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				contato.setId(res.getInt("id"));
				contato.setNome(res.getString("nome"));
				contato.setTel(res.getString("tel"));
				contato.setEmail(res.getString("email"));
			}
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// CRUD - READ //
	public ArrayList<JavaBeans> listarContatos() {
		String sqlBuscar = "SELECT * FROM contatos ORDER BY nome";
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(sqlBuscar);
			ResultSet res = pst.executeQuery();

			// run while fields true
			while (res.next()) {
				// Populando o ArrayList
				contatos.add(new JavaBeans(
						res.getInt("id"),
						res.getString("nome"), 						res.getString("tel"), 
						res.getString("email")));
			}
			conexao.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD - CREATE //
	public void inserirContato(JavaBeans contato) {
		String sqlInserir = "INSERT INTO contatos (nome, tel, email) VALUES(?,?,?)";
		try {
			// open connection
			Connection conexao = conectar();
			// prepare query to run on database
			PreparedStatement pst = conexao.prepareStatement(sqlInserir);
			// replace binds (?) for content variables JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTel());
			pst.setString(3, contato.getEmail());
			// run a query
			System.out.println(pst.executeUpdate());
			// close connection
			// if don't to close connection cause issues
			// performance and security
			conexao.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	// connection testing
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
