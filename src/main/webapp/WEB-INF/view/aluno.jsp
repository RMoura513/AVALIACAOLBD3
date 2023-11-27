<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value='./css/styles.css' />" />
<title>Aluno</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="aluno" method="post">
			<p class="title">
				<b>Aluno</b>
			</p>
			<table>
				<!-- 				<tr>
				<td colspan="4">
					
					<select class="input_data" id="RA" name="RA"> 
					 	<option value="0">Escolha um RA</option>
					 		<c:forEach var="a" items="${alunos }">
					 			<option value="${a.RA }">
					 				<c:out value="${a.RA }" />
							 	</option>
					 		</c:forEach>
						 </select>

-->

				<tr>
					<td colspan="3"><label>(RA apenas para consulta):</label></br> <input
						class="input_data" type="number" id="RA" name="RA"
						placeholder="RA" value='<c:out value="${aluno.RA }"></c:out>'>
						<input type="submit" id="botao" name="botao" value="Buscar">
						<br> <br></td>
				</tr>


				<tr>
					<td colspan="3"><input class="input_data" type="number"
						id="cursoCodigo" name="cursoCodigo" placeholder="C�digo do Curso"
						value='<c:out value="${aluno.cursoCodigo }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="3"><input class="input_data" type="text"
						id="turno" name="turno" placeholder="Turno"
						value='<c:out value="${aluno.turno }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="3"><input class="input_data" type="number"
						id="CPF" name="CPF" placeholder="CPF"
						value='<c:out value="${aluno.CPF }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="nome" name="nome" placeholder="Nome"
						value='<c:out value="${aluno.nome }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="nomeSocial" name="nomeSocial" placeholder="Nome Social"
						value='<c:out value="${aluno.nomeSocial }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><label>Data de nascimento:</label></br> <input
						class="input_data" type=date id="dataNascimento"
						name="dataNascimento" placeholder="Data de Nascimento"
						value='<c:out value="${aluno.dataNascimento }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="tel" name="tel" placeholder="Telefone"
						value='<c:out value="${aluno.tel }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="emailPes" name="emailPes" placeholder="E-mail Pessoal"
						value='<c:out value="${aluno.emailPes }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="emailCor" name="emailCor" placeholder="E-mail Corporativo"
						value='<c:out value="${aluno.emailCor }"></c:out>'></td>
				</tr>
				<tr>
					<td colspan="4"><label>Data de conclus�o do segundo
							grau:</label></br> <input class="input_data" type="date" id="dataConclusaoSeg"
						name="dataConclusaoSeg" placeholder="Conclus�o Segundo Grau"
						value='<c:out value="${aluno.dataConclusaoSeg }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="instituicaoConclusaoSeg" name="instituicaoConclusaoSeg"
						placeholder="Institui��o Segundo Grau"
						value='<c:out value="${aluno.instituicaoConclusaoSeg }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="3"><input class="input_data" type="number"
						id="pontuacaoVestibular" min="0" name="pontuacaoVestibular"
						placeholder="Pontua��o Vestibular"
						value='<c:out value="${aluno.pontuacaoVestibular }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="3"><input class="input_data" type="number"
						id="posicaoVestibular" min="0" name="posicaoVestibular"
						placeholder="Posi��o Vestibular"
						value='<c:out value="${aluno.posicaoVestibular }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="3"><label>Data de Ingresso:</label></br> <input
						class="input_data" type="date" id="dataIngresso"
						name="dataIngresso" placeholder="Data de Ingresso"
						value='<c:out value="${aluno.dataIngresso }"></c:out>'></td>
				</tr>
				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Cadastrar"></td>
					<td><input type="submit" id="botao" name="botao"
						value="Alterar"></td>
					<td><input type="submit" id="botao" name="botao"
						value="Excluir"></td>
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
	<c:if test="${not empty alunos }">
		<table class="table_round">
			<thead>
				<tr>
					<th>RA</th>
					<th>CodigoCurso</th>
					<th>Turno</th>
					<th>CPF</th>
					<th>Nome</th>
					<th>NomeSocial</th>
					<th>DataNascimento</th>
					<th>Telefone</th>
					<th>EmailPessoal</th>
					<th>EmailCorporativo</th>
					<th>DataConclusaoSeg</th>
					<th>InstituicaoConclusaoSeg</th>
					<th>PontuacaoVestibular</th>
					<th>PosicaoVestibular</th>
					<th>SemestreAnoIngresso</th>
					<th>SemestreAnoLimiteGrad</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="a" items="${alunos }">
					<tr>
						<td><c:out value="${a.RA}" /></td>
						<td><c:out value="${a.cursoCodigo}" /></td>
						<td><c:out value="${a.turno}" /></td>
						<td><c:out value="${a.CPF}" /></td>
						<td><c:out value="${a.nome}" /></td>
						<td><c:out value="${a.nomeSocial}" /></td>
						<td><c:out value="${a.dataNascimento}" /></td>
						<td><c:out value="${a.tel}" /></td>
						<td><c:out value="${a.emailPes}" /></td>
						<td><c:out value="${a.emailCor}" /></td>
						<td><c:out value="${a.dataConclusaoSeg}" /></td>
						<td><c:out value="${a.instituicaoConclusaoSeg}" /></td>
						<td><c:out value="${a.pontuacaoVestibular}" /></td>
						<td><c:out value="${a.posicaoVestibular}" /></td>
						<td><c:out value="${a.semestreAnoIngresso}" /></td>
						<td><c:out value="${a.semestreAnoLimiteGrad}" /></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</c:if>
</body>
</html>