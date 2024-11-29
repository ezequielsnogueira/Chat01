package ClienteServidorScan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor 
{

	public static void main(String[] args) throws IOException 
	
	{
		
		ServerSocket	servidor	=	new	ServerSocket(5002);
		System.out.println("Porta aberta!");
		Socket	cliente	=	servidor.accept();
		System.out.println("Nova	conexão	com	o	cliente	"	+	cliente.getInetAddress().getHostAddress()	);
		
		System.out.println("Aceitou conexão..");
		
		InputStream	is	=	cliente.getInputStream();
		InputStreamReader	isr	=	new	InputStreamReader(is);
		BufferedReader	br	=	new	BufferedReader(isr);
		String	s	=	br.readLine();	//	primeira	linha
		while (s	!=	null)	
		{
		System.out.println(s);
		s=br.readLine();
		}
		
		
		br.close();
		
		
		servidor.close();
		cliente.close();
	}

}
