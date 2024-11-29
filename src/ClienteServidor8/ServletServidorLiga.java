package ClienteServidor8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ClienteServ8/ServletServidorLiga")
public class ServletServidorLiga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletServidorLiga() 
    {
        super();
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  	{
  	System.out.println("Executou a servlet Liga");
    ServletServidor servServidor = new ServletServidor();
    servServidor.service(request, response);
  	    
      
    ServletServidorDisp ServSerDisp = new  ServletServidorDisp();	
    ServSerDisp.service(request, response);
      }



}
