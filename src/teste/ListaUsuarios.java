package teste;

import java.sql.SQLException;
import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

public class ListaUsuarios 
{

	public static void main(String[] args) throws SQLException
	
	{
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> usuarios = dao.getLista();
				for (Usuario usuario : usuarios) 
				{
				System.out.println("Email: " + usuario.getEmail());
				System.out.println("Porta: " + usuario.getPorta());				
				System.out.println("Senha: " + usuario.getSenha()+ "\n");
			
				}
			
	}


}


