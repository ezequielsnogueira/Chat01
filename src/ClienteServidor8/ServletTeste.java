package ClienteServidor8;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTeste
 */
@WebServlet("/ClienteServ8/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTeste() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
    	String mensagem;
    	
    	
    	mensagem = "teste";
   	   
    	System.out.println("Executou a servlet DISP");
    	
    	request.setAttribute("msg", mensagem);
    	//request.setAttribute("pastNome", arquivo.getPasta());
       RequestDispatcher rd = request.getRequestDispatcher ("msgRecebida.jsp");
       rd.forward(request, response);
      }

}
