package ClienteServUDP4;

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

@WebServlet("/ClienteServUDP4/ServUDPClientUDP4")
public class ServUDPClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServUDPClient() {
        super();
    }

	
	
		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			
			DatagramSocket clientSocket = new DatagramSocket();
			System.out.println("(UDP CLIENT) Criou o datagrama");
			byte[] sendData = new byte[1024];
			System.out.println("(UDP CLIENT) Criou o byte na mem�ria");
			InetAddress IPAddress = InetAddress.getByName("localhost");
			System.out.println("(UDP CLIENT) Gravou o IP ADRESS");
				
			
				System.out.println("(UDP CLIENT) Chamando a intera��o");
				String sentence = request.getParameter("msgCli"); //primeira intera��o com o usu�rio
				System.out.println("(UDP CLIENT) Inter��o feita");
				sendData = sentence.getBytes();
				System.out.println("(UDP CLIENT) Enviando dados");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(),IPAddress, 5004);
				System.out.println("(UDP CLIENT) Enviando para a porta");
				clientSocket.send(sendPacket);
				System.out.println("(UDP CLIENT) Concluiu o envio");
					
			
			System.out.println("(UDP CLIENT) Fechando o clientSoket");
			clientSocket.close();
			request.setAttribute("msg", sentence);
			System.out.println("Dispachando a p�gina do cliente...");
			RequestDispatcher rd2 = request.getRequestDispatcher("pagClient.jsp");
			rd2.forward(request,response);
			
			
				
		
				
			
		
		
			
		}
		

		
	

}
