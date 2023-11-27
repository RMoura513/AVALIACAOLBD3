<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='./css/styles.css' />" />
<title>Chamada</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="chamada" method="post">
			<p class="title">
				<b>Chamada</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="disciplinaCodigo" name="disciplinaCodigo"
						placeholder="Código da Disciplina"
						value='<c:out value="${chamada.disciplinaCodigo }"></c:out>'></td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Iniciar"></td>
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
	<c:if test="${not empty chamadas}">
		<form action="processaChamada" method="post">
			<table class="table_round">
				<thead>
					<tr>
						<th>RA do Aluno</th>
						<th>Nome do Aluno</th>
						<th>Ausência</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${chamadas}">
						<tr>
							<td><c:out value="${c.alunoRA}" /></td>
							<td><c:out value="${c.alunoNome}" /></td>
							<td><input type="number" id="ausencia" name="ausencia"
								value="0"></td>
							<input type="hidden" name="alunoRA" value="${c.alunoRA}">
						</tr>
					</c:forEach>


				</tbody>
			</table>
			<input type="submit" id="botao" name="botao" value="Enviar">
			<input type="number" id="disciplinaCodigo" name="disciplinaCodigo"
				placeholder="Confirme a Disciplina"
				value='<c:out value="${chamada.disciplinaCodigo }"></c:out>'><br>
			<input type="submit" id="alterarBotao" name="botao" value="Alterar">
			<input type="date" id="dataChamada" name="dataChamada">

		</form>
	</c:if>


</body>
</html>
