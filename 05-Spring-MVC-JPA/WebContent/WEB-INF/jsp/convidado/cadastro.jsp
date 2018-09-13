<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastrar Produto">

	<h1>Cadastro de Convidado!</h1>

	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>

	<c:url value="/convidado/cadastrar" var="mapeamentoPagina"/>
	<form:form action="${mapeamentoPagina}" method="post" modelAttribute="convidado">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value="Salvar" class="btn btn-primary"/>
		</div>
	</form:form>


</tags:template>