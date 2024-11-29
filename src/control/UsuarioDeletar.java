package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/Web1/deletaUsu")
public class UsuarioDeletar extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	public UsuarioDeletar() 
    {
        super();
    }
	
	
	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 

	{
		
		
		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("email1"));

	        
        UsuarioDAO dao;
		try 
			{
			dao = new UsuarioDAO();
			dao.remover(usuario);

			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Web1/usuario-deletado.jsp");
		rd.forward(request,response);
	}

}