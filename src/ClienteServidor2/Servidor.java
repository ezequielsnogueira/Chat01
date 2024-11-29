package ClienteServidor2;


import java.io.*;
import javax.swing.*;
import java.net.*;

public class Servidor 
{

	public static void main(String[] args) throws IOException 
	{
	System.out.println("Servidor iniciado..");
	ServerSocket socketServidor = new ServerSocket(5001);
	Socket socketCliente = socketServidor.accept();
	PrintWriter out = new PrintWriter(socketCliente.getOutputStream(),true);
	BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
	EscutaThread escuta = new EscutaThread(in);
	escuta.start();
	String entrada;
	
		while (true)
		{
		entrada = JOptionPane.showInputDialog(null, "Mensagem para o cliente","Servidor", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showInputDialog(entrada);
		System.out.println("Servidor:" + entrada);
		out.println(entrada);
		System.out.println("continua no servidor");
		if (entrada.equals("fim"))
			break;
		}
	socketCliente.close();
	socketServidor.close();

	}

}
