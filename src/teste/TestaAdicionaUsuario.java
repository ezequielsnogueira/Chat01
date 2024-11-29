package teste;

import java.sql.SQLException;

import dao.UsuarioDAO;
import model.Usuario;

public class TestaAdicionaUsuario {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setEmail("123");
		usuario.setSenha("321");
		
		dao.inserir(usuario);
				
		
		
		
		System.out.println("Usuário inserido");
	}

}
