<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template titulo="Pagina Inicial">
	<jsp:attribute name="frag">
	<%-- neste caso preciso colocar o jsp:attribure antes do doBody --%>
		<p>Lore</p>
	</jsp:attribute>
	<jsp:body>
		<%-- tudo o que estiver aqui dentro vai pro jsp:doBody --%>
		<h1>Pagina inicial</h1>
	</jsp:body>
</tags:template>
