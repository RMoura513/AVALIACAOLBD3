<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='./css/styles.css' />" />
<title>Histórico</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="historico" method="post">
			<p class="title">
				<b>Histórico</b>
			</p>
			<table>
				<tr>
					<td><input class="input_data" type="number" id="alunoRA"
						name="alunoRA" placeholder="RA"></td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Listar"></td>
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
	<c:if test="${not empty historicos }">
		<table class="table_round">
			<thead>
				<tr>
					<th>RA do Aluno</th>
					<th>Nome do Aluno</th>
					<th>Nome do Curso</th>
					<th>Primeira Matrícula</th>
					<th>Pontuação do Vestibular</th>
					<th>Posição do Vestibular</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="h" items="${historicos}">
					<tr>
						<td><c:out value="${h.alunoRA}" /></td>
						<td><c:out value="${h.alunoNome}" /></td>
						<td><c:out value="${h.cursoNome}" /></td>
						<td><c:out value="${h.dataMatricula}" /></td>
						<td><c:out value="${h.pontuacaoVestibular}" /></td>
						<td><c:out value="${h.posicaoVestibular}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${not empty historicos2 }">
		<table class="table_round">
			<thead>
				<tr>
					<th>Código da Disciplina</th>
					<th>Nome da Disciplina</th>
					<th>Nome do Professor</th>
					<th>Nota Final</th>
					<th>Quantidade de Ausências</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="h" items="${historicos2}">
					<tr>
						<td><c:out value="${h.disciplinaCodigo}" /></td>
						<td><c:out value="${h.disciplinaNome}" /></td>
						<td><c:out value="${h.professorNome}" /></td>
						<td><c:out value="${h.notaFinal}" /></td>
						<td><c:out value="${h.qtdAusencias}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>