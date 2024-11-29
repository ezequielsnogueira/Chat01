package teste;

import java.sql.SQLException;

import dao.UsuarioDAO;
import model.Usuario;

public class TestaBuscaUsuario {

	public static void main(String[] args) throws SQLException {

		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setEmail("asdf");
		usuario.setSenha("afdfsf");
				
		
		
		
		System.out.println(dao.buscarUsuarioPorEmail(usuario));
		
		
		
		
	}

}
