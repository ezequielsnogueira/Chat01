package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


@WebServlet("/Web1/listapast")
public class PastaListar extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	public PastaListar() 
    {
        super();
    }
	
	
	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 

	{
		

        HttpSession sessao = request.getSession();
		
		Usuario usuario = new Usuario();
		usuario.setEmail((String) sessao.getAttribute("usuAutenticado"));
		
		request.setAttribute("usuAutentic", usuario.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("/Web1/pasta-salvar.jsp");
		rd.forward(request,response);
	}

}
