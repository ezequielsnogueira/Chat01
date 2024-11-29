<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import= "model.*" %>
<html>

<%
String usuAutenticado = (String)request.getAttribute("usuAutentic");
%>
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
									Pastas pastas = new Pastas();
									pastas.setUsuario(usuAutenticado);
									PastaDAO pastaDao = new PastaDAO();
									ArrayList<Pastas> listaPast = pastaDao.listarPastas(pastas);
									%>
								
									<table  class = bTable>	
											<tr><th><%out.println("Olá, " +usuAutenticado);	%></th></tr>
											<form  action="pagina-principal.jsp" method="POST">
											<tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> 
											</form>
									</table>
					</div>
					
					<div class = "nav-listArquivos"> 
						   <%
							Arquivos arquivo = new Arquivos();
							arquivo.setUsuario(usuAutenticado);
							ArquivoDAO dao = new ArquivoDAO();
							ArrayList<Arquivos> lista = dao.listarUsuArqui(arquivo);
							%>
							<table  class="rTable">
								
								<thead>
									<tr>
										<th>Nome</th>
										<th>Data</th>
										<th>Tipo</th>
										<th>Download</th>
										<th>Compartilhar</th>
										<th>Deletar</th>
									</tr>
								</thead>
								
								
								<tbody>
									<%for( Arquivos arq : lista )
									{%>
										<tr>
											<td><%= arq.getNome() %></td>
											<td><%= arq.getData() %></td>
											<td><%= arq.getTipo() %></td>
											<td><a href="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>">baixar</a></td>
											<td><a href="./ArquivoCompar?&cod=<%= arq.getCodigo() %>">Compartilhar</a></td>
											<td><a href="./DeletaArquivo?&cod=<%= arq.getCodigo() %>">deletar</a></td>
										</tr>
									<%}%>
								</tbody>
							</table>
		 		</div>
		 </div>
	</body>


</html>