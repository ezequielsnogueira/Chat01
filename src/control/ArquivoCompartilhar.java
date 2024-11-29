package control;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ArquivosCompar;

@WebServlet("/Web1/ArquivoCompar")
public class ArquivoCompartilhar extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  
    {
    	
    	
    	ArquivosCompar arquivo = new ArquivosCompar();
    	
    	
    	arquivo.setCodigo(request.getParameter("cod"));
    	
    	System.out.println("arquivo.getCodigo()");
		System.out.println(arquivo.getCodigo());
    	
    	
    	
		
		
		HttpSession sessaoCompart = request.getSession();
		sessaoCompart.setAttribute("codCompart", arquivo.getCodigo());
		System.out.println("codCompart");
		System.out.println(sessaoCompart.getAttribute("codCompart"));
		
				if (sessaoCompart.getAttribute("codCompart") != null)
				{
					request.setAttribute("cod", arquivo.getCodigo());
					
					

					RequestDispatcher rd = request.getRequestDispatcher("usuario-compartilhar.jsp");
					
					rd.forward(request, response);
				}

    }
		
		
		

}