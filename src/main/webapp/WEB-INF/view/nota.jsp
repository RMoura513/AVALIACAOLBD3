<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='./css/styles.css' />" />
<title>Nota</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="nota" method="post">
			<p class="title">
				<b>Nota</b>
			</p>
			<table>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="alunoRA" name="alunoRA" placeholder="RA do Aluno"
						value='<c:out value="${nota.alunoRA }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="disciplinaCodigo" name="disciplinaCodigo"
						placeholder="Código da Disciplina"
						value='<c:out value="${nota.disciplinaCodigo }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="notaP1" name="notaP1" placeholder="Nota de P1"
						value='<c:out value="${nota.notaP1 }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="notaP2" name="notaP2" placeholder="Nota de P2"
						value='<c:out value="${nota.notaP2 }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="notaP3" name="notaP3" placeholder="Nota de P3"
						value='<c:out value="${nota.notaP3 }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="notaT" name="notaT" placeholder="Nota de Trabalho"
						value='<c:out value="${nota.notaT }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="notaA" name="notaA" placeholder="Nota de Artigo"
						value='<c:out value="${nota.notaA }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="notaM" name="notaM" placeholder="Nota de Monografia"
						value='<c:out value="${nota.notaM }"></c:out>'></td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Cadastrar"></td>
				</tr>
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
		<form action="notaPdf" method="post">
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
	<c:if test="${not empty notas}">
		<table class="table_round">
			<thead>
				<tr>
					<th>RA do Aluno</th>
					<th>Código da Disciplina</th>
					<th>Nota de P1</th>
					<th>Nota de P2</th>
					<th>Nota de P3</th>
					<th>Nota de T</th>
					<th>Nota de Artigo</th>
					<th>Nota de Monografia</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${notas}">
					<tr>
						<td><c:out value="${n.alunoRA }" /></td>
						<td><c:out value="${n.disciplinaCodigo }" /></td>
						<td><c:out value="${n.notaP1 }" /></td>
						<td><c:out value="${n.notaP2 }" /></td>
						<td><c:out value="${n.notaP3 }" /></td>
						<td><c:out value="${n.notaT }" /></td>
						<td><c:out value="${n.notaA }" /></td>
						<td><c:out value="${n.notaM }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
