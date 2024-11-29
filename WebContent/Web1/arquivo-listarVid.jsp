<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
    
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
							
						
			<table  class = bTable>	
					<thead><tr><th>
					<%
					out.println("Olá, " +usuAutenticado);
					%>
					</th></tr></thead>
					<form  action="pagina-principal.jsp" method="POST">
					<thead><tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> </thead>
					</form>
			</table>
			
			
						
				
						
					
					
					
			</div>
			<div class = "nav-listArquivos"> 
						<%
							
							Arquivos arquivo = new Arquivos();
							arquivo.setUsuario(usuAutenticado);
							ArquivoDAO dao = new ArquivoDAO();
							ArrayList<Arquivos> lista = dao.listarVid(arquivo);
							
							
						%>
						
						
						
						
						
						<%
							for( Arquivos arq : lista )
							{
								%>
								
								
								<video width="320" height="240" controls>
								
								
									<source src="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>">
																	
								
								</video>
								
								
								<% 
							}
						%>

			</div>
			
			
			
			
		
				
			
		</div>
		
			
		
	</body>


</html>

