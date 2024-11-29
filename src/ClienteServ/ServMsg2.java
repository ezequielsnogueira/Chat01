package ClienteServ;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServMsg2")
public class ServMsg2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ServMsg2() 
    {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("Cliente iniciado...");
		
			
			String entrada = "Mensagem para o cliente";
			request.setAttribute("msg", entrada);
			RequestDispatcher rd = request.getRequestDispatcher("pagClient.jsp");
			rd.forward(request,response);
			
			
			}
			
		
	
	}
		
		
		
	
		



