package ClienteServidor8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ClienteServ8/ServletServidor")
public class ServletServidor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletServidor() 
    {
        super();
    }
    String estado = "desligado";
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        HttpSession sessaoLig = request.getSession();

    	System.out.println("ESTADO INICIAL DO SERVIDOR: " + sessaoLig.getAttribute("est"));
    	
    	if (sessaoLig.getAttribute("est") == null)
    	{
    		System.out.println("Executou a servlet SERVIDOR");
        	System.out.println("(UDP SERVER) Servidor Iniciado...");
    		byte[] receiveData = new byte[1024];
    		DatagramSocket serverSocket = new DatagramSocket(5010);
    		System.out.println("(UDP SERVER) Criou a conexão na porta...");
    		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    		System.out.println("(UDP SERVER) Aguardando a inicializção do cliente"); 
    		ThreadLigServ ligServ = new ThreadLigServ();
    		ligServ.run(request, response);
    		
    		/**Thread2 ligServ2 = new Thread2();
    		ligServ2.run(request, response);
    		try 
    		{
			ligServ2.sleep(1000);
			} 
    		catch (InterruptedException e) 
    		{
			e.printStackTrace();
			} **/
    		
    		System.out.println("ESTADO DO SERVIDOR: " + sessaoLig.getAttribute("est"));
    		serverSocket.receive(receivePacket);
    			
    		System.out.println("(UDP SERVER) Recebeu o pacote");
    		String mensagem = new String(receivePacket.getData());
    		InetAddress IPAddress = receivePacket.getAddress();
    		System.out.println("(UDP SERVER) Recebeu o IP");
    		System.out.println("Recebido de " + IPAddress.getCanonicalHostName()+ ":"  + mensagem);
    		HttpSession sessaoServ = request.getSession();
    		sessaoServ.setAttribute("msgRec", mensagem);
    		System.out.println("Sessao Serv: " + sessaoServ.getAttribute("msgRec"));
    		System.out.println("(UDP SERVER) Fechando o serverSocket");
    		request.setAttribute("msg", mensagem);
    		System.out.println("Executou O IF");
    		serverSocket.close();
    		ThreadDesligServ desServ = new ThreadDesligServ();
    	    desServ.run(request, response);
    	    
    		//response.sendRedirect("msgRecebida.jsp");  

    		RequestDispatcher rd = request.getRequestDispatcher ("msgRecebida.jsp");
    	    rd.forward(request, response);
    	    
    	    
    	    
    	}
    	
    		System.out.println("NÃO ENTROU NO IF");
    		//response.sendRedirect("msgRecebida.jsp");
    		RequestDispatcher rd = request.getRequestDispatcher ("msgRecebida.jsp");
    	    rd.forward(request, response);
    	
			
	
		
    }


}
