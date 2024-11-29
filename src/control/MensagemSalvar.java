package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import model.ArquivosCompar;


@WebServlet("/Web1/ServletMsg") // configura a url do servlet
@MultipartConfig // indica que o formulário é multipart
public class MensagemSalvar  extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
	
	

	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 
		
			{
				ArquivosCompar arquivo = new ArquivosCompar();
 	
				arquivo.setTexto(request.getParameter("mensagemEnviar"));
				System.out.println(request.getParameter("mensagemEnviar"));
				
				String msg = arquivo.getTexto();
				
				
				if (msg.equals(""))
		    	{
		    		System.out.println(arquivo.getTexto());
		    		System.out.println("Entrou na rotina");
		    		request.setAttribute("pastNome", arquivo.getPasta());
					request.setAttribute("usuAutentic", arquivo.getUsuario());
					RequestDispatcher rd = request.getRequestDispatcher("arquivo-listarArqCompar.jsp");
					rd.forward(request,response);
		    
		    	}
				else
				{
				System.out.println("não entrou na rotina");
				}
		    		

				
			}
	
	
	

}
	
	
	

