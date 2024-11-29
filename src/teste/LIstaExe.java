package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ArquivoDAO;
import model.Arquivos;

public class LIstaExe 
{

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		{
			
			Arquivos arquivo = new Arquivos();
			
			
			ArquivoDAO dao = new ArquivoDAO();
			ArrayList<Arquivos> lista = dao.listaArqExe(arquivo);
				for (Arquivos arq : lista) 
				{
				
				System.out.println("Nome: " + arq.getNome()+ "\n");
			
				}
			
		}
	}

}
