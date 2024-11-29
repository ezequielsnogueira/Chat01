package ClientServUDP3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) throws IOException 
	{
	System.out.println("(UDP SERVER) Servidor Iniciado...");
	byte[] receiveData = new byte[1024];
	DatagramSocket serverSocket = new DatagramSocket(5006);
	System.out.println("(UDP SERVER) Criou a conex�o na porta...");
	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		
		System.out.println("(UDP SERVER) Entrou no while");
		System.out.println("(UDP SERVER) Aguardando a inicializ��o do cliente"); //aguarda inicila��o do clientUDP
		serverSocket.receive(receivePacket);
		System.out.println("(UDP SERVER) Recebeu o pacote");
		String sentence = new String(receivePacket.getData());
		
		InetAddress IPAddress = receivePacket.getAddress();
		System.out.println("(UDP SERVER) Recebeu o IP");
		System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
		
	System.out.println("(UDP SERVER) Fechando o serverSocket");
	serverSocket.close();

	}

}
