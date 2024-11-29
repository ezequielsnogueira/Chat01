package control;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Usuario;

public class ServDesliga 

{
	
	public void desligar(String usuarioAutentic) throws SQLException, IOException
	{
		
	System.out.println("Desligando o servidor..");
	DatagramSocket clientSocket = new DatagramSocket();
	System.out.println("(UDP CLIENT) Criou o datagrama");
	byte[] sendData = new byte[1024];
	System.out.println("(UDP CLIENT) Criou o byte na memória");
	InetAddress IPAddress = InetAddress.getByName("localhost");
	System.out.println("(UDP CLIENT) Gravou o IP ADRESS");
		
	
		System.out.println("(UDP CLIENT) Chamando a interação");
		String sentence = "Desliga"; //primeira interação com o usuário
		System.out.println("(UDP CLIENT) Interação feita");
		sendData = sentence.getBytes();
		System.out.println("(UDP CLIENT) Enviando dados");
		
		
		Usuario usuarioServ = new Usuario();
		usuarioServ.setEmail(usuarioAutentic);
		
		int portaServ = 0;
	
			UsuarioDAO dao;
			dao = new UsuarioDAO();
			ArrayList<Usuario> lista = dao.buscaPorta(usuarioServ);
			
				for(Usuario usu : lista)
				{
				portaServ = (usu.getPorta());
				
				}
		
				System.out.println("Porta Servidor DESLIGAR : " + portaServ);
		DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(),IPAddress, portaServ);
		System.out.println("(UDP CLIENT) Enviando para a porta");
		clientSocket.send(sendPacket);
		System.out.println("(UDP CLIENT) Concluiu o envio");
			
	
	System.out.println("(UDP CLIENT) Fechando o clientSoket");
	clientSocket.close();

	System.out.println("Despachando a página do cliente...");
	}

}
