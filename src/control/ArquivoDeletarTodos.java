package control;



import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ArquivoDAO;
import dao.UsuarioDAO;
import model.Arquivos;
import model.DadosSistema;
import model.Usuario;

 
@WebServlet("/Web1/DeletaArquivosUsu")
public class ArquivoDeletarTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ArquivoDeletarTodos() 
    {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Arquivos arquivo = new Arquivos();
		arquivo.setUsuario(request.getParameter("userDel"));
		DadosSistema dados = new DadosSistema();
		
		
				try 
				{
				ArquivoDAO dao = new ArquivoDAO();
				dao.deletarUsuArqui(arquivo);
				ArrayList<Arquivos> lista;
				lista = dao.listarUsuArqui(arquivo);
					for( Arquivos arq : lista )
					{
					System.out.println(arq.getCodigo());
					String dirNome = dados.getDirArq();
					File file = new File(dirNome + arq.getCodigo());
					file.delete();
					}
				
				} 
					catch (SQLException e) 
					{
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
				
				
				
				try 
				{
				ArquivoDAO dao1 = new ArquivoDAO();
				dao1.removerRegArqUsu(arquivo);
				} 
					catch (ClassNotFoundException | SQLException e) 
					{
						e.printStackTrace();
					}
									
			
				
			
				try 
				{
				UsuarioDAO dao2 = new UsuarioDAO();
				Usuario usuario = new Usuario();
				usuario.setEmail(arquivo.getUsuario());
				dao2.remover(usuario);
				} 
					catch (SQLException | ClassNotFoundException e) 
					{
					e.printStackTrace();
					}
				
			
	
				
			
	

		
	RequestDispatcher rd = request.getRequestDispatcher("usuario-removido.jsp");
	rd.forward(request,response);
		
	}






}