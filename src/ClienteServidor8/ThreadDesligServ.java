package ClienteServidor8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThreadDesligServ  extends Thread 
{
	
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		System.out.println("Executou thread Desliga...." + request);
		HttpSession sessaoLig = request.getSession();
		String estado= null;
		sessaoLig.setAttribute("est", estado);
		
		ServletServidor serv = new ServletServidor();
		serv.service(request, response);
		
	}

}
