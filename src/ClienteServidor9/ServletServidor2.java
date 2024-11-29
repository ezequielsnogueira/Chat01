package ClienteServidor9;

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
import javax.servlet.http.HttpSession;




@WebServlet("/ClienteServ9/ServletServidor2")
public class ServletServidor2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletServidor2() 
    {
        super();
    }


    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
    	System.out.println("(UDP SERVER) Servidor Iniciado...");
    	byte[] receiveData = new byte[1024];
    	DatagramSocket serverSocket = new DatagramSocket(5004);
    	System.out.println("(UDP SERVER) Criou a conexão na porta...");
    	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    		
    		System.out.println("(UDP SERVER) Entrou no while");
    		System.out.println("(UDP SERVER) Aguardando a inicializção do cliente"); //aguarda inicilação do clientUDP
    		serverSocket.receive(receivePacket);
    		System.out.println("(UDP SERVER) Recebeu o pacote");
    		String sentence = new String(receivePacket.getData());
    		
    		InetAddress IPAddress = receivePacket.getAddress();
    		System.out.println("(UDP SERVER) Recebeu o IP");
    		System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
    		HttpSession sessaoServ = request.getSession();
    		sessaoServ.setAttribute("msgRec", sentence);
    		System.out.println("Sessao Serv: " + sessaoServ.getAttribute("msgRec"));
    		System.out.println("(UDP SERVER) Fechando o serverSocket");
        	serverSocket.close();
    		
    		
    		
    		
    
    	request.setAttribute("mensagem", sentence);
    	RequestDispatcher rd2 = request.getRequestDispatcher("pagServ.jsp");
		rd2.forward(request,response);
		
		
      }
	


}
