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

import dao.PastaDAO;
import model.Pastas;
import model.Usuario;


@WebServlet("/Web1/salvapast")
public class PastaSalvar extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	public PastaSalvar() 
    {
        super();
    }
	
	
	protected void service(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException 

	{
		
		
		Pastas pasta = new Pastas();
		pasta.setNome(request.getParameter("nomePasta"));
	
		HttpSession sessao = request.getSession();
		pasta.setUsuario((String) sessao.getAttribute("usuAutenticado"));
		
			
		
		
		
	        
        
		try 
			{
			PastaDAO pastaDao = new PastaDAO();
			pastaDao.criarPasta(pasta);

			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		
		Usuario usuario = new Usuario();
		usuario.setEmail((String) sessao.getAttribute("usuAutenticado"));
		
		request.setAttribute("usuAutentic", usuario.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("/Web1/pasta-salvar.jsp");
		rd.forward(request,response);
	}

}
