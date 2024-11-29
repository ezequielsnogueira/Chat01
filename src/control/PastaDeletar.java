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


@WebServlet("/Web1/delpast")
public class PastaDeletar extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	public PastaDeletar() 
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
			pastaDao.deletaPasta(pasta);
			System.out.println("Pasta deletada!!");
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("/Web1/pasta-salvar.jsp");
		rd.forward(request,response);
	}

}
