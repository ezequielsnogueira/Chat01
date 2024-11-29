package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ArquivosCompar;


@WebServlet("/Web1/listUsuComp")
public class ListarUsuCompart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListarUsuCompart() 
    {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    		
    	
    ArquivosCompar usuariosCompar = new ArquivosCompar();
    HttpSession sessao = request.getSession();
    usuariosCompar.setUsuario((String) sessao.getAttribute("usuAutenticado"));
	usuariosCompar.setUsuarioCompar(request.getParameter("usuNome"));
    request.setAttribute("usuNo", usuariosCompar.getUsuarioCompar());
    request.setAttribute("usuAutentic", usuariosCompar.getUsuario());
		
	RequestDispatcher rd = request.getRequestDispatcher("listar-usu-comp.jsp");
	rd.forward(request,response);
		
	}
}
