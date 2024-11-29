<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import= "model.*" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sistema Web</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href=".cssGrid.css">

		
	
	</head>

<body>


	<table  class="aTable">
	
					<%
							Arquivos arquivo = new Arquivos();
							ArquivoDAO dao = new ArquivoDAO();
							ArrayList<Arquivos> lista = dao.listarTodosArquivos();
							
							
						%>
						
						<thead>
							<tr>
								<th>Arquivos</th>
							</tr>
						</thead>
						
						<thead>
							<tr>
							
				
								
								
								<th>Codigo</th>
								<th>Data</th>
								<th>Pasta</th>
								<th>Nome</th>
								<th>Tamanho</th>
								<th>Tipo</th>
								<th>Usuario</th>
							</tr>
						</thead>
						
						
						
						<%
							for( Arquivos arq : lista )
							{
						%>
						
						<tbody>
							<tr>
								
								<td><%= arq.getCodigo() %></td>
								<td><%= arq.getData() %></td>
								<td><%= arq.getPasta() %></td>
								<td><%= arq.getNome() %></td>
								<td><%= arq.getTamanho() %></td>
								<td><%= arq.getTipo() %></td>
								<td><%= arq.getUsuario() %></td>
								
								
						<% 
							}
						%>
	</table>
						
						
	<table  class="aTable">
	
					<%
							ArquivosCompar arquivoCompar = new ArquivosCompar();
							ArquivoDAO daoCompar = new ArquivoDAO();
							ArrayList<ArquivosCompar> listaCompar = dao.listarTodosArquivosCompar();
							
							
						%>
						
						<thead>
							<tr>
								<th>Arquivos Compartilhados</th>
							</tr>
						</thead>
						
						<thead>
							<tr>
							
				
								
								
								<th>Codigo</th>
								<th>Data</th>
								<th>Pasta</th>
								<th>Nome</th>
								<th>Tamanho</th>
								<th>Tipo</th>
								<th>Usuario</th>
								<th>Usuario Compar</th>
							</tr>
						</thead>
						
						
						
						<%
							for( ArquivosCompar arq : listaCompar )
							{
						%>
						
						<tbody>
							<tr>
								
								<td><%= arq.getCodigo() %></td>
								<td><%= arq.getData() %></td>
								<td><%= arq.getPasta() %></td>
								<td><%= arq.getNome() %></td>
								<td><%= arq.getTamanho() %></td>
								<td><%= arq.getTipo() %></td>
								<td><%= arq.getUsuario() %></td>
								<td><%= arq.getUsuarioCompar() %></td>
								
								
						<% 
							}
						%>
	</table>
						
						
	<table  class="aTable">
	
					<%
							Pastas pastas = new Pastas();
							PastaDAO daoPastas = new PastaDAO();
							ArrayList<Pastas> listaPastas = daoPastas.listarTodasPastas();
							
							
						%>
						
						<thead>
							<tr>
								<th>Pastas</th>
							</tr>
						</thead>
						
						<thead>
							<tr>
							
				
								
								
								<th>Nome da Pasta</th>
								<th>Usuario</th>
								
							</tr>
						</thead>
						
						
						
						<%
							for( Pastas pasta : listaPastas )
							{
						%>
						
						<tbody>
							<tr>
								
								<td><%= pasta.getNome() %></td>
								<td><%= pasta.getUsuario() %></td>
								
								
								
						<% 
							}
						%>
		</table>
		
		
		<table  class="aTable">
	
					<%
							TabUsuariosCompar tabUsuCompar = new TabUsuariosCompar();
							UsuarioComparDAO daoUsuCompar = new UsuarioComparDAO();
							ArrayList<TabUsuariosCompar> listaUsuComar = daoUsuCompar.getListaTudo();
							
							
						%>
						
						<thead>
							<tr>
								<th>Compartilhamento de usuários</th>
							</tr>
						</thead>
						
						<thead>
							<tr>
							
				
								
								
								<th>Usuario</th>
								<th>Usuario Compar</th>
								
							</tr>
						</thead>
						
						
						
						<%
							for( TabUsuariosCompar tabUsuCom : listaUsuComar )
							{
						%>
						
						<tbody>
							<tr>
								
								<td><%= tabUsuCom.getUsuario() %></td>
								<td><%= tabUsuCom.getUsuarioCompar() %></td>
								
								
								
						<% 
							}
						%>
		</table>
		
		
		<table  class="aTable">
	
					<%
							Usuario usuarios = new Usuario();
					 		UsuarioDAO usuarioDAO = new UsuarioDAO();
							ArrayList<Usuario> listaUsuarios = usuarioDAO.getLista(); 
							
							
						%>
						
						<thead>
							<tr>
								<th>Usuarios</th>
							</tr>
						</thead>
						
						<thead>
							<tr>
							
				
								
								
								<th>Usuario</th>
								<th>Senha</th>
								
							</tr>
						</thead>
						
						
						
						<%
							for( Usuario users : listaUsuarios )
							{
						%>
						
						<tbody>
							<tr>
								
								<td><%= users.getEmail() %></td>
								<td><%= users.getSenha() %></td>
								
								
								
						<% 
							}
						%>
		</table>

</body>
</html>