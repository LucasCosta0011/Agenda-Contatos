<%@ page import="Model.JavaBeans"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
JavaBeans contato = (JavaBeans) request.getAttribute("contato");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Editar contato</title>
<link rel="icon" href="images/tel.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		<h1>Editar contato</h1>
		<form name="formContato" action="update">
			<table>
				<tr>
					<td><input id="txtId" type="text" name="id" placaholder="ID"
						value="<%=contato.getId()%>" readonly /></td>
				</tr>
				<tr>
					<td><input type="text" name="nome" placeholder="Nome"
						class="caixa1" value="<%=contato.getNome()%>" /></td>
				</tr>
				<tr>
					<td><input type="text" name="tel" placeholder="Telefone"
						class="caixa2" value="<%=contato.getTel()%>" /></td>
				</tr>
				<tr>
					<td><input type="text" name="email" placeholder="E-mail"
						class="caixa1" value="<%out.print(contato.getEmail());%>" /></td>
				</tr>
			</table>
			<input type="button" value="Confirmar" class="btnAcessar"
				onclick="validar()" /> <a href="main" class="btnCancelar">Cancelar</a>
		</form>
	</div>
	<script type="text/javascript" src="Scripts/Validador.js"></script>
</body>
</html>