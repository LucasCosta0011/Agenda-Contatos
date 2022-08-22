package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Importações manuais
import Model.DAO;
import Model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	
	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dao.testeConexao();
		String action = request.getServletPath();
		// System.out.println(action); -> /main
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	// Novo contato
		protected void novoContato(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Teste de recebimento dos dados do formulário
			
			/** getParameter - captura o dado com o name dele **/
			/*
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("tel"));
			System.out.println(request.getParameter("email"));
			*/
			
			// setar as variáveis JavaBeans
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setTel(request.getParameter("tel"));
			
			// invocar/chamar o método inserirContato passando o objeto contato
			// cheio de dados
			dao.inserirContato(contato);
			// Redirecionar para o documento Agenda.jsp
			response.sendRedirect("main");
		}
		
	// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Agenda.jsp");
	}
}