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


@WebServlet("/Web2/adicionaUsuario")
public class UsuarioInserir extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	public UsuarioInserir() 
    {
        super();
    }
	
	
	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 

	{
		
		
		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("email1"));
		usuario.setSenha(request.getParameter("senha1"));
		usuario.setPorta(9001);
		
	        
        UsuarioDAO dao;
		try 
			{
			dao = new UsuarioDAO();
			dao.inserir(usuario);

			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Web2/usuario-cadastrado.jsp");
		rd.forward(request,response);
	}

}
