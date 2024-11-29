package ClienteServidor9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadLigaServ extends Thread 

{
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		System.out.println("Executou ThreadLigaServ...." + request);
		ServletServidor2 servServ2 = new ServletServidor2();
		servServ2.service(request, response);
	}

}
