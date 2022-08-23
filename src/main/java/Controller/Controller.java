package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

// Importações manuais
import Model.DAO;
import Model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
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
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/select")) {
			selecionarContato(request, response);
		} else if(action.equals("/report")){
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	// Gerar relatório em PDF
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document documento = new Document();
		try {
			// tipo de conteúdo
			response.setContentType("application/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename="+"contatos.pdf");
			// criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento para gerar conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de contatos:"));
			// quebra uma linha
			documento.add(new Paragraph(" "));
			// cria uma tabela com 3 colunas
			PdfPTable tabela = new PdfPTable(3);
			// cria um cabecalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("E-mail"));
			tabela.addCell(col1);
			tabela.addCell(col3);
			tabela.addCell(col3);
			// popular a tabela com os contatos
			ArrayList<JavaBeans> contatos = dao.listarContatos();
			for(int i = 0; i < contatos.size(); i++) {
				tabela.addCell(contatos.get(i).getNome());
				tabela.addCell(contatos.get(i).getTel());
				tabela.addCell(contatos.get(i).getEmail());
			}
			// adiciona a tabela ao documento
			documento.add(tabela);
			// fecha o documento
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
	
	// excluirContato
	protected void excluirContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setId(Integer.parseInt(request.getParameter("id")));
		dao.excluirContato(contato);
		response.sendRedirect("main");
	}
	
	// Editar Contato
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaBeans contato = new JavaBeans();
		contato.setId(Integer.parseInt(request.getParameter("id")));
		contato.setNome(request.getParameter("nome"));
		contato.setTel(request.getParameter("tel"));
		contato.setEmail(request.getParameter("email"));
		dao.alterarContato(contato);
		response.sendRedirect("main");
	}
	
	// Selecionar contato
	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    contato.setId(Integer.parseInt(request.getParameter("id")));
		dao.buscarContato(contato);
		request.setAttribute("contato", contato);
		RequestDispatcher rd = request.getRequestDispatcher("EditarContato.jsp");
		rd.forward(request, response);
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
		// Cria um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// Encaminhar a lista ao documento Agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Agenda.jsp");
		rd.forward(request, response);
		
		// teste de recebimento da lista
		/**
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getTel());
			System.out.println(lista.get(i).getEmail());
		}
		**/
	}
}