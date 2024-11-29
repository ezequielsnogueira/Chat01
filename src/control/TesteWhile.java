package control;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArquivosCompar;


@WebServlet("/Web1/TesteWhile")
public class TesteWhile extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
    public TesteWhile() 
    {
        super();
    }

    
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ArquivosCompar arquivo = new ArquivosCompar();
		arquivo.setTexto(request.getParameter("msgEnv"));
		String texto = arquivo.getTexto();
		
	
		
		System.out.println("Texto igual a 'fim'?" + texto );
		
	
			
			switch (texto) 
			
			{
			  case "fim":
				  System.out.println("Opção 1");
					RequestDispatcher rd = request.getRequestDispatcher("testeWhile.jsp");
					rd.forward(request,response);
			    break;
			    
			  case "2":
				  
				  System.out.println("Opção 2");
					RequestDispatcher rd2 = request.getRequestDispatcher("testeWhile.jsp");
					rd2.forward(request,response);
			    break;
			    
			  case "3":
				  System.out.println("Opção 3");

					RequestDispatcher rd3 = request.getRequestDispatcher("testeWhile.jsp");
					rd3.forward(request,response);
			    break;
			    
			    
			  default:
				  	System.out.println("padrão");
					RequestDispatcher rd4 = request.getRequestDispatcher("testeWhile.jsp");
					rd4.forward(request,response);			}


			}
}
