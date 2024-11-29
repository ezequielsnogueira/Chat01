package control;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ArquivoDAO;
import model.Arquivos;
import model.DadosSistema;

 
@WebServlet("/Web1/DeletaArquivo")
public class ArquivoDeletar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ArquivoDeletar() 
    {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Arquivos arquivo = new Arquivos();
		arquivo.setCodigo(request.getParameter("cod"));
		ArquivoDAO dao;
		try {
			dao = new ArquivoDAO();
			dao.remover(arquivo);
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		
		DadosSistema dados =  new DadosSistema();
		String dirNome = dados.getDirArq();
		File file = new File(dirNome + arquivo.getCodigo());
    
        
        file.delete();

		
	RequestDispatcher rd = request.getRequestDispatcher("pagina-principal.jsp");
	rd.forward(request,response);
		
	}






}