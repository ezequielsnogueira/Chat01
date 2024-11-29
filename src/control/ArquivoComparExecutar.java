package control;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ArquivoDAO;
import dao.UsuarioComparDAO;
import dao.UsuarioDAO;
import model.Arquivos;
import model.ArquivosCompar;
import model.TabUsuariosCompar;
import model.Usuario;

@WebServlet("/Web1/ArquivoComparExe")
public class ArquivoComparExecutar extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  
    {
    	
    	
    	ArquivosCompar arquivo = new ArquivosCompar();
    	
    	HttpSession sessaoCompart = request.getSession();
    	arquivo.setCodigo((String) sessaoCompart.getAttribute("codCompart"));
    	arquivo.setUsuarioCompar(request.getParameter("usuCompar"));
    
		
		try 
		{
		Usuario usuario = new Usuario();
		usuario.setEmail(arquivo.getUsuarioCompar());
		UsuarioDAO daoBuscaUsu = new UsuarioDAO();
			if ((daoBuscaUsu.buscarUsuarioCompart(usuario)) != null )
			{
				try 
				
				{
					ArquivoDAO arquivodao = new ArquivoDAO();
					ArrayList<Arquivos> lista = arquivodao.listarArquiCompar(arquivo);
						for( Arquivos arq : lista )
						{
						arquivo.setData(arq.getData());
						arquivo.setNome(arq.getNome());
						arquivo.setTamanho(arq.getTamanho());
						arquivo.setTipo(arq.getTipo());
						arquivo.setUsuario(arq.getUsuario());
						arquivo.setPasta(arq.getPasta());
						}
					
			
					
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				} 
		    
		TabUsuariosCompar tabUsuCompar = new TabUsuariosCompar();
		
		
		tabUsuCompar.setUsuario(arquivo.getUsuario()); //Usuário de origem
		tabUsuCompar.setUsuarioCompar(arquivo.getUsuarioCompar()); // Usuário de destino
		
		UsuarioComparDAO usuarioComparDAO = new UsuarioComparDAO();
		usuarioComparDAO.buscarCompar(tabUsuCompar);
		
		
		if (usuarioComparDAO.buscarCompar(tabUsuCompar) == null) //Se não achar compartilhamento... inserir.
		{
		UsuarioComparDAO inserirCompar = new UsuarioComparDAO();
		inserirCompar.inserir(tabUsuCompar);
		tabUsuCompar.setUsuario(arquivo.getUsuarioCompar());
		tabUsuCompar.setUsuarioCompar(arquivo.getUsuario()); 
		inserirCompar.inserir(tabUsuCompar);
		
		System.out.println(tabUsuCompar.getUsuario());
		System.out.println(tabUsuCompar.getUsuarioCompar());
		System.out.println("Novo compartilhamento inserido!!"); //Inserido na tabela..
					
				
		}
		
  	
				try 
				{
				ArquivoDAO daoInserirCompart = new ArquivoDAO();
				daoInserirCompart.inserirArqCompar(arquivo);
				System.out.println("Arquivo compartilhado inserido com sucesso!!");
				sessaoCompart.setAttribute("codCompart", null); //finalizando a sesssão de compartilhamento de pasta
				} 
				catch (SQLException e) 
				{
				e.printStackTrace();
				} 
				catch (ClassNotFoundException e) 
				{
				e.printStackTrace();
				}
				
				
				request.setAttribute("pastNome", arquivo.getPasta());
				HttpSession sessao = request.getSession();
				request.setAttribute("usuAutentic", (String) sessao.getAttribute("usuAutenticado"));
				request.setAttribute("comparOk", "Arquivo compartilhado!");
				RequestDispatcher rd = request.getRequestDispatcher("arquivo-salvar.jsp");
				rd.forward(request, response);
			}
			
			else
			{
			request.setAttribute("erro", "E-mail não encontrado");
			RequestDispatcher rd = request.getRequestDispatcher("usuario-compartilhar.jsp");
			rd.forward(request, response);
			}
			
			
		
		} 
		catch (SQLException e1) 
		{
		e1.printStackTrace();
		}
		
		
		
		
		
		
    }
		
		
		

}