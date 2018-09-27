<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:template titulo="Listar Convidados">

	<h4>Lista de Convidados</h4>

	<c:if test="${msgSucesso != null}">
		<div class="alert alert-success">${msgSucesso}</div>
	</c:if>
	
	<c:if test="${msgErro != null}">
		<div class="alert alert-danger">${msgErro}</div>
	</c:if>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>CONFIRMADO</th>
				<th>E-MAIL</th>
				<th>DATA ANIVERSARIO</th>
				<th>Confirmar Presença</th>
				<th>Excluir</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${convidados}" var="convidado">
				<tr>
					<td>${convidado.codigo}</td>				
					<td>${convidado.nome}</td>
					<td>${convidado.confirmado ? "SIM" : "NÃO"}</td>
					<td>${convidado.email}</td>
					<td>
						<fmt:formatDate value="${convidado.dataAniversario.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<c:if test="${convidado.confirmado == false }">
							<button onclick="idConfirmar.value = ${convidado.codigo}" data-toggle="modal" data-target="#modalConfirmar" 
								class="btn btn-success">Confirmar</button>
						</c:if>
						<c:if test="${convidado.confirmado == true }">
							<button onclick="idConfirmar.value = ${convidado.codigo}" data-toggle="modal" data-target="#modalConfirmar" 
								class="btn btn-success" disabled="disabled">Confirmar</button>
						</c:if>
						<a class="btn btn-outline-primary" href="<c:url value="/convidado/editar/${convidado.codigo }"/>">Editar</a>
					</td>
					<td>
						<button onclick="idExcluir.value = ${convidado.codigo}" data-toggle="modal" data-target="#modalExcluir" 
								class="btn btn-outline-danger">Excluir</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>

	<!-- Modal confirmar -->
	<div class="modal fade" id="modalConfirmar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmar</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Deseja realmente confirmar a presença do convidado?
	      </div>
	      <div class="modal-footer">
	      	<c:url value="/convidado/confirmar-presenca" var="action"/>
	      	<form action="${action}" method="post">
	      		<input type="hidden" name="codigo" id="idConfirmar"/>
		        <button type="submit" class="btn btn-success">Sim</button>
	        </form>
		    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
	      </div>
	    </div>
	  </div>
	</div>
	
		<!-- Modal excluir -->
	<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Excluir</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Deseja realmente excluir a/o convidada/o?
	      </div>
	      <div class="modal-footer">
	      	<c:url value="/convidado/excluir-convidado" var="action"/>
	      	<form action="${action}" method="post">
	      		<input type="hidden" name="codigo" id="idExcluir"/>
		        <button type="submit" class="btn btn-success">Sim</button>
	        </form>
		    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
	      </div>
	    </div>
	  </div>
	</div>


</tags:template>