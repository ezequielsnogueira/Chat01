package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TabUsuariosCompar;


@WebServlet("/Web1/BuscUsers")
public class ListarUsuChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ListarUsuChat() 
    {
    super();
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	TabUsuariosCompar usuariosCompar = new TabUsuariosCompar();
	HttpSession sessao = request.getSession();
	
	usuariosCompar.setUsuario((String) sessao.getAttribute("usuAutenticado"));
	usuariosCompar.setUsuarioCompar(request.getParameter("usuNome"));
	
	
	request.setAttribute("usuAutentic", usuariosCompar.getUsuario());
	request.setAttribute("usuNo", usuariosCompar.getUsuarioCompar());


	
	RequestDispatcher rd = request.getRequestDispatcher("listar-usuChat.jsp");
	rd.forward(request,response);
		
	}

}
