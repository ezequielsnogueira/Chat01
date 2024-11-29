package ClienteServidorScan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente 
{

	public static void main(String[] args) throws UnknownHostException, IOException 
	
	{
		Socket	cliente	=	new	Socket("127.0.0.1",	5001);
		System.out.println("O	cliente	se	conectou	ao	servidor!");
		
		FileOutputStream	os	=	new	FileOutputStream("C:/arquivo.txt");
		
	
	
		PrintStream	saida	=	new	PrintStream(os);
		

		saida.close();
		cliente.close();
	}

}
