package ClienteServidor2;

import java.io.*;



public class EscutaThread extends Thread
{
BufferedReader in;

	public EscutaThread(BufferedReader in)
	{
	this.in = in;
	}
	
	public void run()
	{
	String entrada;
	System.out.println("Iniciou a escuta");
	
		try
		{
			while ((entrada = in.readLine())!= null)
			{
			System.out.println("Recebi:" + entrada);
			System.out.println("continua no  thread");
			   
	       
		    
			}
		}
		catch (IOException e)
		{
			
		} 
	 }
}
