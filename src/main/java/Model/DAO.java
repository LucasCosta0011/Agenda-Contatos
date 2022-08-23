package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost/agendacontatosdb?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "${PASS}";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
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
	
	/**
	 * Excluir contato.
	 *
	 * @param contato the contato
	 */
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
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String sqlAlterar = "UPDATE contatos SET nome=?, tel=?, email=? WHERE id = ?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(sqlAlterar);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTel());
			pst.setString(3, contato.getEmail());
			pst.setInt(4, contato.getId());
			
			pst.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String sqlSelecionar = "SELECT * FROM contatos WHERE id LIKE ?";
		try {
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(sqlSelecionar);
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
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
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
						res.getString("nome"),
						res.getString("tel"),
						res.getString("email")));
			}
			conexao.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String sqlInserir = "INSERT INTO contatos (nome, tel, email) VALUES(?,?,?)";
		try {
			// open connection
			Connection conexao = conectar();
			// prepare query to run on database
			PreparedStatement pst = conexao.prepareStatement(sqlInserir);
			// replace binds (?)
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTel());
			pst.setString(3, contato.getEmail());
			// run a query
			pst.executeUpdate();
			// close connection
			// if don't to close connection cause issues
			// performance and security
			conexao.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	/**
	 * Teste conexao.
	 */
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
