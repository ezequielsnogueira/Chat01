package teste;

import java.sql.SQLException;

import dao.UsuarioDAO;
import model.Usuario;

public class InserePorta {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setEmail("ezequi@gmail.com");
		usuario.setPorta(5001);
		
				dao.inserirPorta(usuario);
				
		
		
		
		System.out.println("Porta gravada");
	}

}
