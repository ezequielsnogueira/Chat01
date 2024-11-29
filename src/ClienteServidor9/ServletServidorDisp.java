package ClienteServidor9;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ClienteServ9/ServletServidorDisp")
public class ServletServidorDisp extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
 
    public ServletServidorDisp() 
    {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
    	String mensagem;
    	
    	HttpSession sessaoServ = request.getSession();
		mensagem = (String) sessaoServ.getAttribute("msgRec");
		System.out.println("Sessao ServDisp : " + mensagem);
   	   
    	System.out.println("Executou a servlet DISP");
    	
       RequestDispatcher rd = request.getRequestDispatcher ("msgRecebida.jsp");
       rd.forward(request, response);
      }


}
