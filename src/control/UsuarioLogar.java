package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/Web1/login")
public class UsuarioLogar extends HttpServlet 

{
		private static final long serialVersionUID = 1L;
	       
	
		    public UsuarioLogar() 
		    {
		        super();
		      
		    }
		    
	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
			{
			
			Usuario usu = new Usuario();
			usu.setEmail(request.getParameter("email1"));
			usu.setSenha(request.getParameter("senha1"));
			
			
			
			
			try 
			
				{
					UsuarioDAO usuDAO = new UsuarioDAO();
					String usuAutenticado = usuDAO.buscarUsuarioPorEmail(usu);
					System.out.println("usuAutenticado");
					System.out.println(usuAutenticado);
					
					if (usuAutenticado != null)
					{
					
					
					HttpSession sessao = request.getSession();
					sessao.setAttribute("usuAutenticado", usuAutenticado);
					System.out.println("USUÁRIO");
					System.out.println(sessao.getAttribute("usuAutenticado"));
					RequestDispatcher rd = request.getRequestDispatcher("pagina-principal.jsp");
					rd.forward(request, response);
					
							
					}
							else
							{
								System.out.println("Usuário ou senha incorretos");
								request.setAttribute("erro", "E-mail ou senha incorretos");
								RequestDispatcher rd = request.getRequestDispatcher("usuario-login.jsp");
								rd.forward(request, response);
							}
					
				} 
				
				
				catch (SQLException e) 
				
				{
					
					e.printStackTrace();
				}
				
				
			}
			
			
			
				
			
	


}
