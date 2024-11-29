package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TabUsuariosCompar;


@WebServlet("/Web1/listarAud")
public class ListarAud extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	
    public ListarAud() 
    {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		TabUsuariosCompar usuariosCompar = new TabUsuariosCompar();
		HttpSession sessao = request.getSession();
			
		usuariosCompar.setUsuario((String) sessao.getAttribute("usuAutenticado"));
			
			
		request.setAttribute("usuAutentic", usuariosCompar.getUsuario());
		
	RequestDispatcher rd = request.getRequestDispatcher("arquivo-listarAud.jsp");
	rd.forward(request,response);
		
	}






}