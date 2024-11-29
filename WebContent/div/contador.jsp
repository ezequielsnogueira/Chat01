<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<script language="javascript">
		var counter = 0;
		window.setInterval("refreshDiv()", 5000);
		function refreshDiv()
		{
		
		counter = counter + 1;
		document.getElementById("teste").innerHTML = "Testando... " + counter
		
		<jsp:useBean id="dao" class="dao.UsuarioDAO"/> ;
		}
		</script>
	</head>

	<body>
		<div id="teste">
		Testando
		</div>
		<div id="estatico">
		Parte estática da página.
		</div>
	</body>
</html>
