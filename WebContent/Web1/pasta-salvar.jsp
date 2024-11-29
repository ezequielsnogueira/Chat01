
			


<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import= "model.*" %>

    
<%
	String usuAutenticado = (String)request.getAttribute("usuAutentic");
	Pastas pastas = new Pastas();
	pastas.setUsuario(usuAutenticado);
%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Sistema Web</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./cssGrid.css">
	</head>


	<body>
		<div class = "container"> 
		<div class = "nav-voltarSair"> 
			<table  class = bTable>	
					<tr><th><%out.println("Olá, " + usuAutenticado);%></th></tr>
					<form  action="ListarPastas" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> 
					</form>
			</table>
			
			<form  action="salvapast" method="POST">	
						<table border = 1  class = rTable>
								<tbody><tr>	<td> Nome da Pasta: <input type="text" name="nomePasta"/></td></tr></tbody>	
								<tbody><tr>	<td ><input type="submit" value="Criar"/></td></tr></tbody>
						</table>
			</form>
		</div>
		
		<div class = "nav-listArquivos"> 
					<%
					PastaDAO pastaDao = new PastaDAO();
					ArrayList<Pastas> lista = pastaDao.listarPastas(pastas);
					%>
						
				<table  class="rTable">
						<thead>
							<tr>
								<th>Pastas</th>
								<th>Alterar</th>
								<th>Deletar</th>
							</tr>
						</thead>
					<%for( Pastas pasta : lista )
					{%>
					<tr>
					<td><%= pasta.getNome() %></td>
					<td><a href="./?&nomePasta=<%= pasta.getNome() %>"	>Alterar</a></td>
					<td><a href="./delpast?&nomePasta=<%= pasta.getNome() %>"	>Deletar</a></td>
					</tr>
					<%}%>
				</table>
			</div>
		</div>
			
	</body>	

</html>