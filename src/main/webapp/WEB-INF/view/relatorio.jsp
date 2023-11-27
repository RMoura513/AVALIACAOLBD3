<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='./css/styles.css' />" />
<title>Relatório</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="relatorio" method="post">
			<p class="title">
				<b>Relatório</b>
			</p>
			<table>

				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Listar"></td>
				</tr>

				<tr>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div align="center" class="container">
		<form action="relatorioPdf" method="post">
			<p class="title">
				<b>Relatório (PDF)</b>
			</p>
			<table>

				<tr>
					<td><input type="submit" id="botao" name="botao" value="Gerar"></td>
				</tr>

				<tr>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2>
				<b><c:out value="${erro}" /></b>
			</H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3>
				<b><c:out value="${saida}" /></b>
			</H3>
		</c:if>
	</div>
	<br />
	<c:if test="${not empty relatorios}">
		<table class="table_round">
			<thead>
				<tr>
					<th>RA do Aluno</th>
					<th>Nome do Aluno</th>
					<th>Disciplina</th>
					<th>Ausências na Semana</th>
					<th>Total de Ausências</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${relatorios}">
					<tr>
						<td><c:out value="${r.alunoRA }" /></td>
						<td><c:out value="${r.alunoNome }" /></td>
						<td><c:out value="${r.disciplinaNome }" /></td>
						<td><c:out value="${r.qtdAusenciasNaSemana }" /></td>
						<td><c:out value="${r.totalAusencias }" /></td>
						<td><c:out value="${r.estado }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
