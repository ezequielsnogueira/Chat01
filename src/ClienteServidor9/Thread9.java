package ClienteServidor9;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Thread9 extends Thread

{
	
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		System.out.println("Executou thread...." + request);
		RequestDispatcher rd = request.getRequestDispatcher ("msgRecebida.jsp");
	    rd.forward(request, response);
	}

}

