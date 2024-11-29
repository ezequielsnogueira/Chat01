package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TabUsuariosCompar;

public class UsuarioComparDAO 

{
	
	private Connection conexao;
	public UsuarioComparDAO() throws SQLException
	{
	this.conexao = ConectaBD.getContection();
	}
	
	public void inserir(TabUsuariosCompar usuarioCompar) 
	
	{
		try 
			{
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO tabusuarioscompar (usuario,usuarioCompar) values (?,?)");
			comando.setString(1, usuarioCompar.getUsuario());
			comando.setString(2, usuarioCompar.getUsuarioCompar());
			comando.executeUpdate();
			comando.close();
			conexao.close();
			} 
		
			catch (Exception e) 
			{
			e.printStackTrace();
			}
	
	}
	
	public String buscarCompar (TabUsuariosCompar usuarioCompar) throws SQLException //Busca compartilhamento entre usuários
	{
	PreparedStatement comando = conexao.prepareStatement("select * from tabusuarioscompar where (usuario=?) AND (usuarioCompar=?)");
	comando.setString(1, usuarioCompar.getUsuario());
	comando.setString(2, usuarioCompar.getUsuarioCompar());
	ResultSet rs = comando.executeQuery();	
	
			while (rs.next()) 
			{
				return usuarioCompar.getUsuarioCompar();
			}
			

	rs.close();
	comando.close();
	
	return null;
	

	}
	
	
	public ArrayList<TabUsuariosCompar> getLista(TabUsuariosCompar tabUsuarioCompar) throws SQLException 
	{
	 PreparedStatement comando = this.conexao.prepareStatement("select * from tabusuarioscompar where usuarioCompar =?"); 
	 comando.setString(1, tabUsuarioCompar.getUsuario());
	 ResultSet rs = comando.executeQuery();
	 ArrayList<TabUsuariosCompar> listUsuariosCompar = new ArrayList<TabUsuariosCompar>();
	 	while (rs.next()) 
		{
		TabUsuariosCompar usuarioCompar = new TabUsuariosCompar();
		usuarioCompar.setUsuario(rs.getString("usuario"));
		
		listUsuariosCompar.add(usuarioCompar);
		
		}
	rs.close();
	comando.close();
	conexao.close();
	return listUsuariosCompar;
	}
	
	public void remover(TabUsuariosCompar usuarioCompar) throws SQLException, ClassNotFoundException
		
		{
		PreparedStatement comando = conexao.prepareStatement("delete from tabusuarioscompar where usuarioCompar=?");
		comando.setString(1, usuarioCompar.getUsuarioCompar());
		comando.executeUpdate();
		comando.close();
		}
		
		
		public ArrayList<TabUsuariosCompar> getListaTudo() throws SQLException 
		{
		 PreparedStatement comando = this.conexao.prepareStatement("select * from tabusuarioscompar"); 
		 ResultSet rs = comando.executeQuery();
		 ArrayList<TabUsuariosCompar> listUsuariosCompar = new ArrayList<TabUsuariosCompar>();
		 	while (rs.next()) 
			{
			TabUsuariosCompar usuarioCompar = new TabUsuariosCompar();
			usuarioCompar.setUsuario(rs.getString("usuario"));
			usuarioCompar.setUsuarioCompar(rs.getString("usuarioCompar"));
			listUsuariosCompar.add(usuarioCompar);
			
			}
		rs.close();
		comando.close();
		conexao.close();
		return listUsuariosCompar;
		}
		
		public void deletaTodos() throws SQLException  {
			
			PreparedStatement comando = conexao.prepareStatement("TRUNCATE TABLE tabusuarioscompar ");
			
			comando.executeUpdate();
			comando.close();
			conexao.close();
			
		}

	

		

}



