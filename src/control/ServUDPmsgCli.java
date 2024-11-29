package control;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/Web1/ServUDPmsgCli")
public class ServUDPmsgCli extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServUDPmsgCli() {
        super();
    }

	
	
		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			Usuario usuarioDestino = new Usuario();
			usuarioDestino.setEmail(request.getParameter("usuDest"));
			int porta = 0;
			
			try 
			{
				UsuarioDAO dao;
				dao = new UsuarioDAO();
				ArrayList<Usuario> lista = dao.buscaPorta(usuarioDestino);
				
					for(Usuario usu : lista)
					{
					porta = (usu.getPorta());
					System.out.println("Porta: " + porta);
					}
			} 
			
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			System.out.println("Usuário de destino de destino" + usuarioDestino.getEmail());
			System.out.println("Porta de destino" + porta);
			
			
			
		
			DatagramSocket clientSocket = new DatagramSocket();
			System.out.println("(UDP CLIENT) Criou o datagrama");
			byte[] sendData = new byte[1024];
			System.out.println("(UDP CLIENT) Criou o byte na memória");
			InetAddress IPAddress = InetAddress.getByName("localhost");
			System.out.println("(UDP CLIENT) Gravou o IP ADRESS");
				
			
				System.out.println("(UDP CLIENT) Chamando a interação");
				String sentence = request.getParameter("msgServ"); //primeira interação com o usuário
				System.out.println("(UDP CLIENT) Interação feita");
				sendData = sentence.getBytes();
				System.out.println("(UDP CLIENT) Enviando dados");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(),IPAddress, porta);
				System.out.println("(UDP CLIENT) Enviando para a porta");
				clientSocket.send(sendPacket);
				System.out.println("(UDP CLIENT) Concluiu o envio");
					
			
			System.out.println("(UDP CLIENT) Fechando o clientSoket");
			clientSocket.close();
			System.out.println("Despachando a página do cliente...");
			RequestDispatcher rd2 = request.getRequestDispatcher("pagChatMsgEnv.jsp");
			rd2.forward(request,response);
			
			
				
		
				
			
		
		
			
		}
		

		
	

}
