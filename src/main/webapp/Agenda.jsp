<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="images/tel.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		<h1>Agenda de contatos</h1>
		<a class="btnAcessar" href="NovoContato.html">Novo contato</a>
		<a class="btnCancelar" href="report">Relatório</a>
		<table id="tabela">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>E-mail</th>
					<th colspan="2">Opções</th>
				</tr>
			</thead>
			<tbody>

				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getTel()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="select?id=<%=lista.get(i).getId()%>"
						class="btnAcessar">Editar</a></td>
					<td><a id="excluir" href="delete?id=<%=lista.get(i).getId()%>"
					class="btnCancelar" onclick="confirmar()">Excluir</a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="Scripts/Confirmador.js"></script>
	<script type="text/javascript" src="Scripts/Validador.js"></script>
</body>
</html>