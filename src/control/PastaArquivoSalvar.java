package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pastas;

import javax.servlet.annotation.MultipartConfig;



@WebServlet("/Web1/PastArqSav") // configura a url do servlet
@MultipartConfig // indica que o formulário é multipart
public class PastaArquivoSalvar  extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
	
	

	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 
		
			{
		
				Pastas pasta = new Pastas();
				pasta.setNome(request.getParameter("pastNome"));
				
				

				request.setAttribute("pastNome", pasta.getNome());
				
				HttpSession sessaoPasta = request.getSession();
				sessaoPasta.setAttribute("nomeSSPast", pasta.getNome());
				
				HttpSession sessao = request.getSession();
				pasta.setUsuario((String) sessao.getAttribute("usuAutenticado"));
				request.setAttribute("usuAutentic", pasta.getUsuario());


				RequestDispatcher rd = request.getRequestDispatcher("arquivo-salvar.jsp");
				rd.forward(request,response);
			}
	
	
	

}
	
	
	

