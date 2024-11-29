package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.DadosSistema;

public class ConectaBD 
{
	public static Connection getContection() throws SQLException
	{
		DadosSistema dados = new DadosSistema();
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Conectando ao banco");
		return DriverManager.getConnection("jdbc:mysql://localhost/dados", dados.getUsuBD(), dados.getSenhaBD());
		} 
			catch (ClassNotFoundException e) 
			{
			throw new SQLException(e.getMessage());
			}
			}
}
