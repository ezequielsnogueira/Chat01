package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;



public class UsuarioDAO 

{
	
private Connection conexao;
	public UsuarioDAO() throws SQLException
	{
	this.conexao = ConectaBD.getContection();
	}
	
	public void inserir(Usuario usuario) 
	
	{
		try 
			{
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO usuario (email,senha,porta) values (?,?,?)");
			comando.setString(1, usuario.getEmail());
			comando.setString(2, usuario.getSenha());
			comando.setInt(3, usuario.getPorta());
			comando.executeUpdate();
			comando.close();
			conexao.close();
			} 
		
			catch (Exception e) 
			{
			e.printStackTrace();
			}
	}
	
	
	public ArrayList<Usuario> getLista() throws SQLException 
	{
	 PreparedStatement comando = this.conexao.prepareStatement("select * from usuario");
	 ResultSet rs = comando.executeQuery();
	 ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	 	while (rs.next()) 
		{
		Usuario usuario = new Usuario();
		usuario.setEmail(rs.getString("email"));
		usuario.setPorta(rs.getInt("porta"));
		usuario.setSenha(rs.getString("senha"));
		usuarios.add(usuario);
		}
	rs.close();
	comando.close();
	conexao.close();
	return usuarios;
	}

		


		
		
		public void remover(Usuario usuario) throws SQLException, ClassNotFoundException
		
		{
		PreparedStatement comando = conexao.prepareStatement("delete from usuario where email=?");
		comando.setString(1, usuario.getEmail());
		comando.executeUpdate();
		comando.close();
		}
		

		public String buscarUsuarioPorEmail(Usuario usuario) throws SQLException 
		
		
		{
			
			
			PreparedStatement comando = conexao.prepareStatement("select * from usuario where (email=?) AND (senha=?) ");
			comando.setString(1, usuario.getEmail());
			comando.setString(2, usuario.getSenha());
			ResultSet rs = comando.executeQuery();	
			
			while (rs.next()) 
			{
				return usuario.getEmail();
			}
			
	
		
			rs.close();
			comando.close();	
			conexao.close();
		return null;
		}
		
		public ArrayList<Usuario> listarUsuConta(Usuario usuario) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from usuario where email =?");
			comando.setString(1, usuario.getEmail());
			ResultSet rs = comando.executeQuery();
			ArrayList<Usuario> listaUsu = new ArrayList<Usuario>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Usuario usu = new Usuario();
					usu.setEmail(rs.getString("email"));
					usu.setSenha(rs.getString("senha"));
					listaUsu.add(usu);
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaUsu;
		}
		
		
	public String buscarUsuarioCompart (Usuario usuario) throws SQLException 
		
		
		{
			
			
			PreparedStatement comando = conexao.prepareStatement("select * from usuario where email=? ");
			comando.setString(1, usuario.getEmail());
			ResultSet rs = comando.executeQuery();	
			
			while (rs.next()) 
			{
				return usuario.getEmail();
			}
			
	
			rs.close();
			comando.close();
			conexao.close();
			
		return null;
		}
	
public void inserirPorta(Usuario usuario) 
	
	{
		try 
			{
			PreparedStatement comando = conexao.prepareStatement("UPDATE usuario SET porta=? WHERE email=?");
			comando.setInt(1, usuario.getPorta());
			comando.setString(2, usuario.getEmail());
			comando.executeUpdate();
			comando.close();
			conexao.close();
			} 
		
			catch (Exception e) 
			{
			e.printStackTrace();
			}
	}

		public int buscaPorta1(Usuario usuario) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from usuario where email=? ");
			comando.setString(1, usuario.getEmail());
			ResultSet rs = comando.executeQuery();	
			
			while (rs.next()) 
			{
				return usuario.getPorta();
			}
			
	
			rs.close();
			comando.close();
			conexao.close();
			
		return 0;
		}
		
		public ArrayList<Usuario> buscaPorta(Usuario usuario) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from usuario where email =? ");
			comando.setString(1, usuario.getEmail());
			ResultSet rs = comando.executeQuery();
			ArrayList<Usuario> listaUsu = new ArrayList<Usuario>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Usuario usu = new Usuario();
					usu.setPorta(rs.getInt("porta"));
						listaUsu.add(usu);
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaUsu;
			}
		
}



