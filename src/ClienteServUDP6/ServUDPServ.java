package ClienteServUDP6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ClienteServUDP6/ServUDPServUDP6")
public class ServUDPServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServUDPServ() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		System.out.println("(UDP SERVER) Servidor Iniciado...");
		byte[] receiveData = new byte[1024];
		DatagramSocket serverSocket = new DatagramSocket(5006);
		System.out.println("(UDP SERVER) Criou a conexão na porta...");
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		System.out.println("(UDP SERVER) Entrou no while");
		System.out.println("(UDP SERVER) Aguardando a inicializção do cliente"); 
		serverSocket.receive(receivePacket);
			
		System.out.println("(UDP SERVER) Recebeu o pacote");
		String sentence = new String(receivePacket.getData());
		InetAddress IPAddress = receivePacket.getAddress();
		System.out.println("(UDP SERVER) Recebeu o IP");
		System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
		request.setAttribute("msg", sentence);
			
		RequestDispatcher rd2 = request.getRequestDispatcher("pagServ.jsp");
		rd2.forward(request,response);
		        
			
	
		System.out.println("(UDP SERVER) Fechando o serverSocket");
		serverSocket.close();
		
	}

}
