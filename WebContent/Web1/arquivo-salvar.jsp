
<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import= "model.*" %>

<%
	String pastNome = (String)request.getAttribute("pastNome");
	String usuAutenticado = (String)request.getAttribute("usuAutentic");
	Pastas pastas = new Pastas();
	pastas.setUsuario(usuAutenticado);
	Arquivos arquivo = new Arquivos();
	arquivo.setPasta(pastNome);
	arquivo.setUsuario(usuAutenticado);
	String comparOk = (String)request.getAttribute("comparOk");

	
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
					<thead><tr><th><%out.println("Olá, " +usuAutenticado);%></th></tr></thead>
					<form  action="ListarPastas" method="POST">
					<thead><tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> </thead>
					</form>
					</table>
			
						<%
							PastaDAO pastaDao = new PastaDAO();
							ArrayList<Pastas> listaPast = pastaDao.listarPastas(pastas);
						%>
						
						
			<form action="./ServletUpload" method="post"	enctype="multipart/form-data">
										
										
						<table border = 1 class = rTable>
							<thead><tr><th> Pasta:	<% out.print(pastNome);	%>	</th></tr></thead>
							<tbody><tr><td>Arquivo: <input type="file" name="arquivoUpload" size="30"  /></td> </tr></tbody>
							<tbody><tr><td><input type="submit" value="Salvar" /></td> </tr></tbody>
						</table>
											
			</form>
			
			<%
			
					if(comparOk != null)
					{
					out.print(comparOk);
					}

			 %>
			</div>
			<div class = "nav-listArquivos"> 
					<%
							ArquivoDAO dao = new ArquivoDAO();
							ArrayList<Arquivos> lista = dao.listarUsuArquiPast(arquivo);
					%>
						
					<table  class="rTable">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Data</th>
								<th>Tamanho</th>
								<th>Download</th>
								<th>Compartilhar</th>
								<th>Deletar</th>
							</tr>
						</thead>
						<%for( Arquivos arq : lista )
						{%>
							<tr>
								<td><%= arq.getNome() %></td>
								<td><%= arq.getData() %></td>
								<td><%= arq.getTamanho() %></td>
								<td><a href="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>">baixar</a></td>
								<td><a href="./ArquivoCompar?&cod=<%= arq.getCodigo() %>">Compartilhar</a></td>
								<td><a href="./DeletaArquivo?&cod=<%= arq.getCodigo() %>">deletar</a></td>
							</tr>
						<%}%>
					</table>
			</div>
		</div>
	</body>
</html>