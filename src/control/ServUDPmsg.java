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
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.ArquivosCompar;
import model.Usuario;

@WebServlet("/Web1/ServUDPmsg")
public class ServUDPmsg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServUDPmsg() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession sessao = request.getSession();
		Usuario usuarioAutentic = new Usuario();
		usuarioAutentic.setEmail((String) sessao.getAttribute("usuAutenticado"));
		Usuario usuarioServ = new Usuario();
		usuarioServ.setEmail(usuarioAutentic.getEmail());
		Usuario usuarioCli = new Usuario();
		usuarioCli.setEmail(request.getParameter("usuDest"));
		
		int portaServ = 0;
		int portaCli = 0;
		
		try 
		{
			UsuarioDAO dao;
			dao = new UsuarioDAO();
			ArrayList<Usuario> lista = dao.buscaPorta(usuarioServ);
			
				for(Usuario usu : lista)
				{
				portaServ = (usu.getPorta());
				System.out.println("Porta Servidor : " + portaServ);
				}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			UsuarioDAO dao;
			dao = new UsuarioDAO();
			ArrayList<Usuario> lista = dao.buscaPorta(usuarioCli);
			
				for(Usuario usu : lista)
				{
				portaCli = (usu.getPorta());
				System.out.println("Porta Cliente : " + portaCli);
				}
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
					
				ArquivosCompar arquivo = new ArquivosCompar();
				arquivo.setTexto(request.getParameter("msgEnv"));
				String texto = arquivo.getTexto();
				
			
				
				System.out.println("Servidor: " + texto );
				
			
					
					
				System.out.println("(UDP SERVER) Servidor Iniciado...");
				byte[] receiveData = new byte[1024];
				DatagramSocket serverSocket = new DatagramSocket(portaServ);
				System.out.println("(UDP SERVER) Criou a conexão na porta...");
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				System.out.println("(UDP SERVER) Aguardando a inicializção do cliente"); //aguarda inicilação do clientUDP
				serverSocket.receive(receivePacket);
							
							
				System.out.println("(UDP SERVER) Recebeu o pacote");
				String sentence = new String(receivePacket.getData());
				InetAddress IPAddress = receivePacket.getAddress();
				System.out.println("(UDP SERVER) Recebeu o IP");
				System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
				System.out.println("(UDP SERVER) Fechando o serverSocket");
				serverSocket.close();
							
				request.setAttribute("msgSrv", sentence);
				System.out.println("Despachando a página do servidor...");
				RequestDispatcher rd1 = request.getRequestDispatcher("pagChat.jsp");
				rd1.forward(request,response);
					
		
		
		
	
		
	}

}
