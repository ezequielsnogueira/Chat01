package ClienteServidor7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer { 

	public  void servidorExecuta () throws IOException 
	{
	System.out.println("(UDP SERVER) Servidor Iniciado...");
	byte[] receiveData = new byte[1024];
	DatagramSocket serverSocket = new DatagramSocket(5004);
	System.out.println("(UDP SERVER) Criou a conexão na porta...");
	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		while(true)
		{
		System.out.println("(UDP SERVER) Entrou no while");
		System.out.println("(UDP SERVER) Aguardando a inicializção do cliente"); //aguarda inicilação do clientUDP
		serverSocket.receive(receivePacket);
		System.out.println("(UDP SERVER) Recebeu o pacote");
		String sentence = new String(receivePacket.getData());
			if (sentence.substring(0,3).equals("fim"))
			{
			System.out.println("(UDP SERVER) Parou");
			break;
			}
		InetAddress IPAddress = receivePacket.getAddress();
		System.out.println("(UDP SERVER) Recebeu o IP");
		System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + sentence);
		}
	System.out.println("(UDP SERVER) Fechando o serverSocket");
	serverSocket.close();

	}

}
