package ClienteServ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClienteServidor2.EscutaThread;




@WebServlet("/ServCliente")
public class ServCliente extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ServCliente() 
    {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("Cliente iniciado...");
		Socket socket = new Socket("localhost", 5002);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		EscutaThread escuta = new EscutaThread(in);
		escuta.start();
		String entrada ;
			
		entrada = request.getParameter("msg2");
		
			while (true)
			{
			entrada = request.getParameter("msg2");
			out.println(entrada);
			System.out.println("Cliente:" + entrada);
			
			
			request.setAttribute("msg", entrada);
			RequestDispatcher rd = request.getRequestDispatcher("pagClient.jsp");
			rd.forward(request,response);
			System.out.println("continua no  cliente");
				if (entrada.equals("fim"))
				{
				break;
				}
			
			}
			
		socket.close();
	
	}
		
		
		
	
		
}


