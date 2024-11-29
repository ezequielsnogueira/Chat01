package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import dao.ArquivoDAO;
import model.ArquivosCompar;
import model.DadosSistema;


@WebServlet("/Web1/ServletUpload") // configura a url do servlet
@MultipartConfig // indica que o formulário é multipart
public class ArquivoSalvar  extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
	
	

	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 
		
			{
				DadosSistema dados = new DadosSistema();
				ArquivosCompar arquivo = new ArquivosCompar();
		    	HttpSession sessao = request.getSession();
				arquivo.setUsuario((String) sessao.getAttribute("usuAutenticado"));
				HttpSession sessaoPasta = request.getSession();
				arquivo.setPasta((String) sessaoPasta.getAttribute("nomeSSPast"));
				System.out.println("Pasta");
				System.out.println(arquivo.getPasta());
				HttpSession sessaoMsg = request.getSession();
				arquivo.setUsuarioCompar((String) sessaoMsg.getAttribute("sMsg"));
				sessaoMsg.setAttribute("sMsg", null);
				arquivo.setTexto(request.getParameter("mensagemEnviar"));
				System.out.println("Usuario compar");
				String UsuCompar = arquivo.getUsuarioCompar();
		    	System.out.println(UsuCompar);
				
		    	String dirNome = dados.getDirArq();
		    	
		    	Part  filePart = request.getPart("arquivoUpload");
		    	arquivo.setNome(filePart.getSubmittedFileName());
		    	System.out.println("Nome");
		    	System.out.println(arquivo.getNome());
				arquivo.setTamanho(filePart.getSize());
				System.out.println("Tamanho");
				System.out.println(arquivo.getTamanho());
				arquivo.setCodigo(UUID.randomUUID().toString());
				arquivo.setTipo(filePart.getContentType());
				System.out.println("Tipo");
				System.out.println(arquivo.getTipo());
				
				Long tamanho = arquivo.getTamanho();
		    	
		    	
		    	
		    	
		    	
		    			if ((tamanho > 0))
						{	
		    				
				  		    	try 
						    	{	
				  				
								
			  					filePart.write(dirNome + arquivo.getCodigo());
			  					System.out.println("ARQUIVO SALVO");
			  					ArquivoDAO dao;
								dao = new ArquivoDAO();
								dao.inserir(arquivo);
								System.out.println("ARQUIVO SALVO NO BANCO DE DADOS");
								request.setAttribute("pastNome", arquivo.getPasta());
								request.setAttribute("usuNo", arquivo.getUsuarioCompar());
				    			request.setAttribute("usuAutentic", arquivo.getUsuario());
				    			RequestDispatcher rd = request.getRequestDispatcher("arquivo-salvar.jsp");
				    			rd.forward(request,response);		

								
								} 
								catch (SQLException e) 
								{
								e.printStackTrace();
								}
		    					
		    				}
						
				}
						
							
								
									
								
								
							
		    			
		    			
}
		    		
		    


					
			        
					
					
				
					
					
				
					
								
				
				
				

	
	
	


	
	
	

