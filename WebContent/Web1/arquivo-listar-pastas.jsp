<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import= "model.*" %>


<%
String usuAutenticado = (String)request.getAttribute("usuAutentic");

%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sistema Web</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./cssGrid.css">

		
	
	</head>


	<body>
		
		<div class = "container"> 
		
			
			<div class = "nav-voltarSair"> 
							<%
							HttpSession sessaoPast = request.getSession();
							Pastas pastas = new Pastas();
							pastas.setUsuario(usuAutenticado);
							PastaDAO pastaDao = new PastaDAO();
							ArrayList<Pastas> listaPast = pastaDao.listarPastas(pastas);
							%>
						
							<table  class = bTable>	
									<tr><th>
											<% out.println("Olá, " +usuAutenticado);%>
									</th></tr>
									<form  action="pagina-principal.jsp" method="POST">
									<tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> 
									</form>
							</table>
											
											
								
							<table  class= rTable>
												<tbody><tr><td> Pastas: <a href="listapast"> Criar pasta </a> </td></tr></tbody>
											<%
												for( Pastas pasta : listaPast )
												{
											%>
												<tbody><tr><td><a href="./PastArqSav?&pastNome=<%= pasta.getNome() %>"	><%= pasta.getNome() %></a>	</td></tr>	</tbody>
											<% 
												}
											%>
							</table>	
							 		
						
						
							
			
					
			</div>
			
			
			<div class = "nav-listArquivos"> 
			
				
						
					
			</div>
			
			
			
			
			
			
 </div>
			
			
			
				
			
		
	</body>


</html>