package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DadosSistema;

@WebServlet("/Web1/Arquivo")
public class ArquivoBaixar extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
  
    {
    	DadosSistema dados = new DadosSistema();
	   	String pathBase = dados.getDirArq();
    	String codigo = request.getParameter("cod");
    	String nome = request.getParameter("name");
    	
    	try
    	{
    		byte[] imageData = carregarImagem(pathBase+codigo);
    		
        	response.setHeader("Content-Disposition", "attachment; filename=\"" + nome + "\"");
        	response.getOutputStream().write(imageData);
    	}
    	catch (Exception e) {
    		response.sendError(404);
    	}
    }

    private static byte[] carregarImagem(String path) throws FileNotFoundException, IOException 
    
    {

        byte[] arquivo;
        File file = new File(path);
        arquivo = new byte[(int)file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(arquivo);

        fileInputStream.close();
        return arquivo;
    }
   
    
    
}