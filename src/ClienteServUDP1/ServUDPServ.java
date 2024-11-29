package ClienteServUDP1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArquivosCompar;

@WebServlet("/ClienteServUDP1/ServUDPServ")
public class ServUDPServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ServUDPServ() 
    {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArquivosCompar arquivo = new ArquivosCompar();
		arquivo.setTexto(request.getParameter("msgEnv"));
		
		
	

		System.out.println("(UDP SERVER) Servidor Iniciado...");
		byte[] receiveData = new byte[1024];
		DatagramSocket serverSocket = new DatagramSocket(5007);
		System.out.println("(UDP SERVER) Criou a conexão na porta...");
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			
			System.out.println("(UDP SERVER) Entrou no while");
			System.out.println("(UDP SERVER) Aguardando a inicializção do cliente"); //aguarda inicilação do clientUDP
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Msg Recebida</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("CHAT: <br/> ");
			out.println("Mensagem Recebida: <br/>");
			
			out.println("Enviar mensagem: <br/>");
			out.println("Usuário de destino: <br/>");
			out.println("</body>");
			out.println("</html>");
			
			
			out.close();
			
			
			serverSocket.close();
			serverSocket.receive(receivePacket);
			System.out.println("(UDP SERVER) Recebeu o pacote");
			String sentence = new String(receivePacket.getData());
			
			InetAddress IPAddress = receivePacket.getAddress();
			System.out.println("(UDP SERVER) Recebeu o IP");
			System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
			
		System.out.println("(UDP SERVER) Fechando o serverSocket");
		serverSocket.close();
		
		
		
		request.setAttribute("msg", sentence);
		System.out.println("Dispachando a página do servidor...");
		RequestDispatcher rd1 = request.getRequestDispatcher("pagServ.jsp");
		rd1.forward(request,response);

	}
}


