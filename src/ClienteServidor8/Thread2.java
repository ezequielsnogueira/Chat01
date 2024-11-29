package ClienteServidor8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Thread2 extends Thread 

{
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		System.out.println("Executou thread2...." + request);
		
		
		ServletServidor serv = new ServletServidor();
		serv.service(request, response);
		
	}

}
