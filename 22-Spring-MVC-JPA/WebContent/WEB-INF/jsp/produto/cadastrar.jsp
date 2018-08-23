<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template titulo="Cadastro Produto">
	<h1>Cadastro Produto</h1>
<c:if test="${not empty msg }">
	<div class="alert alert-sucess">
	${msg }
	</div>
</c:if>


	<form class="" action="cadastrar" method="post">
		<div class="form-group">
			<label for="iNome">Nome</label>
			<input class="form-control" type="text" name="nome" id="iNome" />
		</div>
		<div class="form-group">
			<label for="iPreco">Preço</label> 
			<input class="form-control" type="text" name="preco" id="iPreco" />
		</div>
		<div class="form-group">
			<input type="checkbox" name="perecivel" id="iPerecivel" /> Perecível
		</div>
		<input type="submit" value="SALVAR" class="btn btn-primary">
	</form>

</tags:template>





