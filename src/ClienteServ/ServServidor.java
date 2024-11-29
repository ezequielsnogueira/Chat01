package ClienteServ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClienteServidor2.EscutaThread;



@WebServlet("/ServServidor")
public class ServServidor extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ServServidor() 
    {
        super();
       
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
    	System.out.println("Servidor iniciado..");
    	ServerSocket socketServidor = new ServerSocket(5002);
    	Socket socketCliente = socketServidor.accept();
    	PrintWriter out = new PrintWriter(socketCliente.getOutputStream(),true);
    	BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
    	EscutaThread escuta = new EscutaThread(in);
    	escuta.start();
    	System.out.println("Pegando a entrada");
    	String entrada;
    	entrada = request.getParameter("msg1");
    	
    		while (true)
    		{
    			System.out.println("Entrou no while");
    		entrada = request.getParameter("msg1");
    		System.out.println("Servidor:" + entrada);
    		out.println(entrada);
    		
    		request.setAttribute("msg", entrada);
			RequestDispatcher rd = request.getRequestDispatcher("pagServ.jsp");
			rd.forward(request,response);
			System.out.println("continua no servidor");
    			if (entrada.equals("fim"))
    			{
    			break;
    			}
    		}
    		
    		
    	socketCliente.close();
    	socketServidor.close();

    }
	
}


