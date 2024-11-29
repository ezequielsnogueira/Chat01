package ClienteServ;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServMsg1")
public class ServMsg1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ServMsg1() 
    {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("Cliente iniciado...");
		
			
			String entrada = "Mensagem para o servidor";
			request.setAttribute("msg", entrada);
			RequestDispatcher rd = request.getRequestDispatcher("pagServ.jsp");
			rd.forward(request,response);
			
			
			}
			
		
	
	}
		
		
		
	
		



