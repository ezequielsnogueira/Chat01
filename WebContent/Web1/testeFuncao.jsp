<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
    



 
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sistema Web</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./cssGrid.css">
	</head>
	
	

	<body  onload="setInterval ('Atualizar()', 1000)" >
	
	<script type= "text/javascript">
	function Atualizar() 
	{
	window.location.reload();
	<%
	System.out.println("TESTE");
	%>
	}
	
	</script>
	
	
	

		
			
			
	</body>


</html>