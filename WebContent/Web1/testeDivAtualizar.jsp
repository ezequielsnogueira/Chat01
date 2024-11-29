
<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%
			String nome = "teste";
		%>
	<head>
		<script language="javascript">
			var counter = ${nome};
			
			window.setInterval("refreshDiv()", 5000);
			function refreshDiv()
			{
			
			document.getElementById("teste").innerHTML = "Testando... " + counter;		
			}
		</script>
	</head>
	
	<body>
		<div id="teste">
		Testando
		
		asdfasdf
		asdfasdf
		</div>
		<div id="estatico">
		Parte estática da página.
		</div>
		

									
									
									
		<%
							
							{
							out.print(nome);
							}
							%>
		
	</body>

</html>