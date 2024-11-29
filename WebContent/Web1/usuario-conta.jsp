<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
			<head>
					<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<link rel="stylesheet" href="./cssGrid.css">
			</head>
			
			
<body>


<div class = "container"> 
		
			
			<div class = "nav-voltarSair"> 
			
					<table  class = bTable>	
							<tr><th>
									<%
									HttpSession sessao = request.getSession();
									Usuario usuario = new Usuario();
									usuario.setEmail((String) sessao.getAttribute("usuAutenticado"));
									out.println("Olá, " +usuario.getEmail());
									%>
							</th></tr>
							<form  action="pagina-principal.jsp" method="POST">
							<tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> 
							</form>
					</table>
					
			
			</div>
			
			
			
			<div class = "nav-listArquivos"> 
				
					<%
						
						Usuario usu = new Usuario();
						usu.setEmail((String) sessao.getAttribute("usuAutenticado"));
						UsuarioDAO dao = new UsuarioDAO();
						ArrayList<Usuario> lista = dao.listarUsuConta(usu);
						
					%>
					
					
					
					
					<table class = rTable>
					
					<thead>
						<tr>
							
							<th>Email</th>
							<th>Senha</th>
							<th>Deletar Usuario/Arquivos</th>
							
						</tr>
					</thead>
					
					
					<%
						for( Usuario user : lista )
						{
					%>
						<tr>
							
							<td><%= user.getEmail() %></td>
							<td><%= user.getSenha() %></td>
							<td> <a	href="./DeletaArquivosUsu?&userDel=<%= user.getEmail() %>">Deletar Usuario/Arquivos</a></td>
						</tr>
					<% 
						}
					%>
					</table>
					
			</div>
			
		
</div>



</body>
</html>