<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Cadastrar apresnetação">
	
	<c:if test="${not empty msg}">
		<div class="alert alert-success">
		${msg}
		
		</div>
	</c:if>
	<jsp:body>
		<form class="col-md-6 col-xs-12" action="cadastro" method="post">
			<div class="form-group">
				<label for="id">ID</label>
				<input type="text" class="form-control" name="codigo" id="id">
			</div>
			<div class="form-group">
				<label for="iNome">Nome</label>
				<input type="text" class="form-control" name="nome" id="iNome">
			</div>
			<div class="form-group">
				<label for="iDuracao">Duração</label>
				<input type="text" class="form-control" name="duracao" id="iDuracao">
			</div>
			<div class="form-group">
				<label for="iDescricao">Descrição</label>
				<textarea cols="5" rows="5" class="form-control" name="descricao" id="iDescricao"></textarea>
			</div>
			<div class="form-group">
				<input type="checkbox" name="apresentado" id="iApresentado"> Apresentado
			</div>
			<input type="submit" class="btn btn=primary" value="Enviar">
		</form>
	</jsp:body>

</tags:template>