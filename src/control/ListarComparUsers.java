package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TabUsuariosCompar;


@WebServlet("/Web1/BuscCompar")
public class ListarComparUsers extends HttpServlet 

{
	private static final long serialVersionUID = 1L;
	
    public ListarComparUsers() 
    {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession sessao = request.getSession();
		
		
		TabUsuariosCompar usuariosCompar = new TabUsuariosCompar();
		
		usuariosCompar.setUsuario((String) sessao.getAttribute("usuAutenticado"));
		
		usuariosCompar.setUsuarioCompar(request.getParameter("usuNome"));
		
		String usuarioAutentic = usuariosCompar.getUsuario();
		ServDesliga desligaServ = new ServDesliga();
		try 
		{
			desligaServ.desligar(usuarioAutentic);
		} 
		catch (SQLException e) 
		
		{
			e.printStackTrace();
		}
		HttpSession sessaoServidor = request.getSession();
		String estado = null;
		sessaoServidor.setAttribute("estadoServ", estado);
		System.out.println("Estado do servidor desligado: " + sessaoServidor.getAttribute("estadoServ"));
	

	
	
	request.setAttribute("usuAutentic", usuariosCompar.getUsuario());
	request.setAttribute("usuNo", usuariosCompar.getUsuarioCompar());


	
	RequestDispatcher rd = request.getRequestDispatcher("arquivo-listarArqCompar.jsp");
	rd.forward(request,response);
		
	}






}