package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UsuarioDAO;
import model.Usuario;

public class BuscaPorta 
{

	public static void main(String[] args) throws SQLException 
	{
		
			
			Usuario usuario = new Usuario();
			usuario.setEmail("joao@gmail.com");
			
			UsuarioDAO dao = new UsuarioDAO();
			ArrayList<Usuario> lista = dao.buscaPorta(usuario);
			for(Usuario usu : lista)
			{
			int porta = (usu.getPorta());
			System.out.println("Porta: " + porta);
			}
			
			
	
	
	}

}
