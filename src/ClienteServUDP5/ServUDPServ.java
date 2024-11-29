package ClienteServUDP5;

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



@WebServlet("/ClienteServUDP5/ServUDPServUDP5")
public class ServUDPServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServUDPServ() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		System.out.println("(UDP SERVER) Servidor Iniciado...");
		response.sendRedirect("pagServ.jsp"); 
		byte[] receiveData = new byte[1024];
		DatagramSocket serverSocket = new DatagramSocket(5005);
		System.out.println("(UDP SERVER) Criou a conexão na porta...");
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		
		
			 
			
			System.out.println("(UDP SERVER) Recebeu o pacote");
			String sentence = new String(receivePacket.getData());
				
			InetAddress IPAddress = receivePacket.getAddress();
			System.out.println("(UDP SERVER) Recebeu o IP");
			
			DatagramSocket clientSocket = new DatagramSocket();
			System.out.println("(UDP CLIENT) Criou o datagrama");
			byte[] sendData = new byte[1024];
			System.out.println("(UDP CLIENT) Criou o byte na memória");
			IPAddress = InetAddress.getByName("localhost");
			System.out.println("(UDP CLIENT) Gravou o IP ADRESS");
				
			
				System.out.println("(UDP CLIENT) Chamando a interação");
				sentence = request.getParameter("msgCli"); //primeira interação com o usuário
				System.out.println("(UDP CLIENT) Interção feita");
				sendData = sentence.getBytes();
				System.out.println("(UDP CLIENT) Enviando dados");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(),IPAddress, 5005);
				System.out.println("(UDP CLIENT) Enviando para a porta");
				
				System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
				System.out.println("(UDP CLIENT) Concluiu o envio");
					
			
			System.out.println("(UDP CLIENT) Fechando o clientSoket");
			clientSocket.close();
			System.out.println("(UDP SERVER) Fechando o serverSocket");
			serverSocket.close();
			
		
			request.setAttribute("msg", sentence);
			RequestDispatcher rd2 = request.getRequestDispatcher("pagServ.jsp");
			rd2.forward(request,response);
		        
			System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
			//}
		System.out.println("(UDP SERVER) Fechando o serverSocket");
		serverSocket.close();
		
	}

}
