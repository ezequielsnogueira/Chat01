<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import= "ClienteServidor9.*" %>
<!DOCTYPE html>

<%
String msg = (String)request.getAttribute("mensagem");
String estado = (String)request.getAttribute("estado");
//ThreadLigaServ ligaServ = new ThreadLigaServ();
//ligaServ.run(request, response);
%>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<script>
	function imputAutomatico() 
	{
		document.getElementById("inTeste").click();
	}
	</script>
		
	<body onload="imputAutomatico()">
		<form action="ServUDPmsg" method="POST">
			<input type="submit" id="inTeste"  value="Enviar"/> 
		</form>
		<%out.println("Mensagem, " +msg);%>
		<%out.println("Estado , " +estado);%>
	</body>
</html>




