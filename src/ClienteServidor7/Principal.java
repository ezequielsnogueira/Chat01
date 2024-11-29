package ClienteServidor7;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		UDPClient cliente = new UDPClient();
		cliente.sleep(3000);
		cliente.start();
		
		UDPServer server= new UDPServer();
		server.servidorExecuta();
		
		
		
		
	
	
	}

}
