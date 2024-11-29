package ClienteServUDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


import javax.swing.JOptionPane;

public class UDPClient {

	public static void main(String[] args) throws IOException 
	{
	DatagramSocket clientSocket = new DatagramSocket();
	System.out.println("(UDP CLIENT) Criou o datagrama");
	byte[] sendData = new byte[1024];
	System.out.println("(UDP CLIENT) Criou o byte na memória");
	InetAddress IPAddress = InetAddress.getByName("localhost");
	System.out.println("(UDP CLIENT) Gravou o IP ADRESS");
		while (true)
		{
		System.out.println("(UDP CLIENT) Chamando a interação");
		String sentence = JOptionPane.showInputDialog("Digite:"); //primeira interação com o usuário
		System.out.println("(UDP CLIENT) Interção feita");
		sendData = sentence.getBytes();
		System.out.println("(UDP CLIENT) Enviando dados");
		DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(),IPAddress, 5006);
		System.out.println("(UDP CLIENT) Enviando para a porta");
		clientSocket.send(sendPacket);
		System.out.println("(UDP CLIENT) Concluiu o envio");
			if(sentence.equals("fim"))
			{
			System.out.println("(UDP CLIENT) PARANDO A ROTINA");
			break;
			}
		}
	System.out.println("(UDP CLIENT) Fechando o clientSoket");
	clientSocket.close();
	}
	

}
