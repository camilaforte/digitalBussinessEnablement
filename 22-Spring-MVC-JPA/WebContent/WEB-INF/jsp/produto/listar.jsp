<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template titulo="Cadastro Produto">
	<h1>Cadastro Produto</h1>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>Nome</th>
				<th>Preço</th>
				<th>Perecivel</th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach items="${tabela }" var="prod">
		    <tr>
		      <td>${prod.nome}</td>
		      <td>${prod.preco}</td>
		      <td>${prod.perecivel?"sim":"não"}</td>
		    </tr>
		 </c:forEach>
	  </tbody>
	</table>
	

		

</tags:template>