package teste;

import java.sql.Connection;
import java.sql.SQLException;
import dao.ConectaBD;

public class TestaBD 

{

	public static void main(String[] args) throws SQLException 
	{
	
		Connection connection = ConectaBD.getContection();
		connection.close();
		
		System.out.print("Conexão ao banco ok");
		
		


	

	}

}
