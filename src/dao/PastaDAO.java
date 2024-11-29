package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pastas;




public class PastaDAO 

{
	
private Connection conexao;
	public PastaDAO() throws SQLException
	{
	this.conexao = ConectaBD.getContection();
	}
	
	
	public String criarPasta (Pastas pasta) throws SQLException 
		
		
		{
			
			
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO pastas (nome,usuario ) values (?,?)");
			
			comando.setString(1, pasta.getNome());
			comando.setString(2, pasta.getUsuario());
			comando.executeUpdate();
			comando.close();
			conexao.close();
			return null;
			
		
			
		}
	
	public ArrayList<Pastas> listarPastas(Pastas pasta) throws SQLException 
	{
	PreparedStatement comando = conexao.prepareStatement("select * from pastas where (usuario =?) order by nome");
	comando.setString(1, pasta.getUsuario());
	ResultSet rs = comando.executeQuery();
	ArrayList<Pastas> listaPastas = new ArrayList<Pastas>();
	rs = comando.executeQuery();
			while (rs.next()) 
			{
			Pastas pastas = new Pastas();
			pastas.setNome(rs.getString("nome"));
			
			
			listaPastas.add(pastas);
			}
	rs.close();
	comando.close();
	conexao.close();
	return listaPastas;
	}


	public void deletaPasta(Pastas pasta) throws SQLException {
		
		PreparedStatement comando = conexao.prepareStatement("delete from pastas where (usuario =?) AND (nome =?)");
		comando.setString(1, pasta.getUsuario());
		comando.setString(2, pasta.getNome());
		comando.executeUpdate();
		comando.close();
		conexao.close();
		
	}
	
	public void deletaTodos() throws SQLException  {
		
		PreparedStatement comando = conexao.prepareStatement("TRUNCATE TABLE pastas ");
		
		comando.executeUpdate();
		comando.close();
		conexao.close();
		
	}
	
	public ArrayList<Pastas> listarTodasPastas() throws SQLException 
	{
	PreparedStatement comando = conexao.prepareStatement("select * from pastas order by nome");
	ResultSet rs = comando.executeQuery();
	ArrayList<Pastas> listaPastas = new ArrayList<Pastas>();
	rs = comando.executeQuery();
			while (rs.next()) 
			{
			Pastas pastas = new Pastas();
			pastas.setNome(rs.getString("nome"));
			pastas.setUsuario(rs.getString("usuario"));
			
			
			listaPastas.add(pastas);
			}
	rs.close();
	comando.close();
	conexao.close();
	return listaPastas;
	}

	
	

}
