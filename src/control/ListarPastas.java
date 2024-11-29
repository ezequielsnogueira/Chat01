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




 
@WebServlet("/Web1/ListarPastas")
public class ListarPastas extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	
    public ListarPastas() 
    {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	Usuario usuario = new Usuario();
	HttpSession sessao = request.getSession();
	usuario.setEmail((String) sessao.getAttribute("usuAutenticado"));
	request.setAttribute("usuAutentic", usuario.getEmail());

		
		
	RequestDispatcher rd = request.getRequestDispatcher("arquivo-listar-pastas.jsp");
	rd.forward(request,response);
	
	
		
	}






}