<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table  border= 1>
						
					
					<%
							TabUsuariosCompar usucompar = new TabUsuariosCompar();
							UsuarioComparDAO dao = new UsuarioComparDAO();
							ArrayList<TabUsuariosCompar> lista = dao.getListaTudo();
							
							
						%>
			
						<thead>
							<tr>
								
								
								<th>Usuario</th>
								<th>UsuarioCompar</th>
								
							</tr>
						</thead>
						
						
						
						<%
							for( TabUsuariosCompar usuCom : lista )
							{
						%>
						
						<tbody>
							<tr>
								
								
								<td><%= usuCom.getUsuario() %></td>
								<td><%= usuCom.getUsuarioCompar() %></td>
							</tr>
						</tbody>
						<% 
							}
						%>
						</table>
			


</body>
</html>