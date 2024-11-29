
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Arquivos;
import model.ArquivosCompar;
import model.TabUsuariosCompar;

public class ArquivoDAO

{
	private Connection conexao;
	public ArquivoDAO() throws SQLException
	{
	this.conexao = ConectaBD.getContection();
	}
			
		
	public void inserir(ArquivosCompar arquivo) throws SQLException 
	
	{
		try 
			{
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO arquivos (codigo,nome,tamanho,tipo,usuario,pasta ) values (?,?,?,?,?,?)");
			comando.setString(1, arquivo.getCodigo());
			comando.setString(2, arquivo.getNome());
			comando.setLong(3, arquivo.getTamanho());
			comando.setString(4, arquivo.getTipo());
			comando.setString(5, arquivo.getUsuario());
			comando.setString(6, arquivo.getPasta());
			comando.executeUpdate();
			comando.close();
	
			} 
		
			catch (Exception e) 
			{
			e.printStackTrace();
			}
	
	conexao.close();
	}
	
	
	
	
	
	

		
		public ArrayList<Arquivos> listar() throws SQLException 
		{
		PreparedStatement comando = conexao.prepareStatement("select * from arquivos order by tipo");
		ResultSet rs = comando.executeQuery();
		ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
		rs = comando.executeQuery();
				while (rs.next()) 
				{
				Arquivos arq = new Arquivos();
				arq.setCodigo(rs.getString("codigo"));
				arq.setNome(rs.getString("nome"));
				arq.setTamanho(rs.getLong("tamanho"));
				arq.setTipo(rs.getString("tipo"));
				arq.setUsuario(rs.getString("usuario"));
				listaArq.add(arq);
				}
		rs.close();
		comando.close();
		return listaArq;
		}

		
		
		public void remover(Arquivos arquivo) throws SQLException, ClassNotFoundException
		
		{
		PreparedStatement comando = conexao.prepareStatement("delete from arquivos where codigo=?");
		comando.setString(1, arquivo.getCodigo());
		comando.executeUpdate();
		comando.close();
		}
		
		public void removerRegArqUsu(Arquivos arquivo) throws SQLException, ClassNotFoundException
		
		{
		PreparedStatement comando = conexao.prepareStatement("delete from arquivos where usuario=?");
		comando.setString(1, arquivo.getUsuario());
		comando.executeUpdate();
		comando.close();
		}
		
		public ArrayList<Arquivos> listarUsuArqui(Arquivos arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where usuario =? order  by data DESC  ");
			comando.setString(1, arquivo.getUsuario());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setCodigo(rs.getString("codigo"));
					arq.setNome(rs.getString("nome"));
					arq.setTamanho(rs.getLong("tamanho"));
					arq.setTipo(rs.getString("tipo"));
					arq.setUsuario(rs.getString("usuario"));
					arq.setData(rs.getString("data"));
					arq.setPasta(rs.getString("pasta"));
					listaArq.add(arq);
					}
			rs.close();
			comando.close();
			return listaArq;
			}
		
		public ArrayList<Arquivos> deletarUsuArqui(Arquivos arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where usuario =?");
			comando.setString(1, arquivo.getUsuario());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setCodigo(rs.getString("codigo"));
					listaArq.add(arq);
					
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}
		
		public ArrayList<Arquivos> listaArqExe(Arquivos arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where (usuario =?) and (nome like '%.exe%') ");
			comando.setString(1, arquivo.getUsuario());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setNome(rs.getString("nome"));
				
					listaArq.add(arq);
					
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}
		
		public ArrayList<Arquivos> listarVid(Arquivos arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where (usuario =?) and (tipo like '%video%') ");
			comando.setString(1, arquivo.getUsuario());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setNome(rs.getString("nome"));
					arq.setCodigo(rs.getString("codigo"));
				
					listaArq.add(arq);
					
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}
		
		public ArrayList<Arquivos> listarImag(Arquivos arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where (usuario =?) and (tipo like '%image%') ");
			comando.setString(1, arquivo.getUsuario());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setNome(rs.getString("nome"));
					arq.setCodigo(rs.getString("codigo"));
				
					listaArq.add(arq);
					
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}

		
		public ArrayList<Arquivos> listarAud(Arquivos arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where (usuario =?) and (nome like '%.mp3%') ");
			comando.setString(1, arquivo.getUsuario());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setNome(rs.getString("nome"));
					arq.setCodigo(rs.getString("codigo"));
				
					listaArq.add(arq);
					
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}
		
		
		public void inserirArqCompar (ArquivosCompar arquivo) throws SQLException, ClassNotFoundException
		
			{
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO arquivoscompar (codigo,data,nome,tamanho,tipo,usuario,usuarioCompar, pasta, texto) values (?,?,?,?,?,?,?,?,?)");
			comando.setString(1, arquivo.getCodigo());
			comando.setString(2, arquivo.getData());
			comando.setString(3, arquivo.getNome());
			comando.setLong(4, arquivo.getTamanho());
			comando.setString(5, arquivo.getTipo());
			comando.setString(6, arquivo.getUsuario());
			comando.setString(7, arquivo.getUsuarioCompar());
			comando.setString(8, arquivo.getPasta());
			comando.setString(9, arquivo.getTexto());

			
			comando.executeUpdate();
			comando.close();
			conexao.close();
			}
		
		
		
		public ArrayList<Arquivos> listarArquiCompar(ArquivosCompar arquivo) throws SQLException 
		{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos where codigo =? ");
			comando.setString(1, arquivo.getCodigo());
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setCodigo(rs.getString("codigo"));
					arq.setData(rs.getString("data"));
					arq.setNome(rs.getString("nome"));
					arq.setTamanho(rs.getLong("tamanho"));
					arq.setTipo(rs.getString("tipo"));
					arq.setUsuario(rs.getString("usuario"));
					arq.setPasta(rs.getString("pasta"));
					
					listaArq.add(arq);
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}
		
			public ArrayList<ArquivosCompar> listarUsuArqCompar(ArquivosCompar arquivoCompar) throws SQLException 
			{
				PreparedStatement comando = conexao.prepareStatement("select * from arquivoscompar where usuarioCompar =? ");
				System.out.println("arquivoCompar.getUsuario()");
				System.out.println(arquivoCompar.getUsuario());
				comando.setString(1, arquivoCompar.getUsuario());
				ResultSet rs = comando.executeQuery();
				ArrayList<ArquivosCompar> listaArq = new ArrayList<ArquivosCompar>();
				rs = comando.executeQuery();
						while (rs.next()) 
						{
						ArquivosCompar arq = new ArquivosCompar();
						arq.setCodigo(rs.getString("codigo"));
						arq.setData(rs.getString("data"));
						arq.setNome(rs.getString("nome"));
						arq.setTamanho(rs.getLong("tamanho"));
						arq.setTipo(rs.getString("tipo"));
						arq.setUsuario(rs.getString("usuario"));
						arq.setUsuarioCompar(rs.getString("usuarioCompar"));
						
						listaArq.add(arq);
						}
				rs.close();
				comando.close();
				conexao.close();
				return listaArq;
				}
		
			public ArrayList<Arquivos> listarUsuArquiPast(Arquivos arquivo) throws SQLException 
			{
				PreparedStatement comando = conexao.prepareStatement("select * from arquivos where (usuario =?) and (pasta =?)order by data ");
				comando.setString(1, arquivo.getUsuario());
				comando.setString(2, arquivo.getPasta());
				ResultSet rs = comando.executeQuery();
				ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
				rs = comando.executeQuery();
						while (rs.next()) 
						{
						Arquivos arq = new Arquivos();
						arq.setCodigo(rs.getString("codigo"));
						arq.setNome(rs.getString("nome"));
						arq.setTamanho(rs.getLong("tamanho"));
						arq.setTipo(rs.getString("tipo"));
						arq.setUsuario(rs.getString("usuario"));
						arq.setData(rs.getString("data"));
						arq.setPasta(rs.getString("pasta"));
						listaArq.add(arq);
						}
				rs.close();
				comando.close();
				conexao.close();
				return listaArq;
				}
			
			
			public ArrayList<Arquivos> listarTodosArquivos() throws SQLException 
			{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivos order by nome");
			ResultSet rs = comando.executeQuery();
			ArrayList<Arquivos> listaArq = new ArrayList<Arquivos>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					Arquivos arq = new Arquivos();
					arq.setCodigo(rs.getString("codigo"));
					arq.setData(rs.getString("data"));
					arq.setPasta(rs.getString("pasta"));
					arq.setNome(rs.getString("nome"));
					arq.setTamanho(rs.getLong("tamanho"));
					arq.setTipo(rs.getString("tipo"));
					arq.setUsuario(rs.getString("usuario"));
					
					listaArq.add(arq);
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}
			
			
			public ArrayList<ArquivosCompar> listarTodosArquivosCompar() throws SQLException 
			{
			PreparedStatement comando = conexao.prepareStatement("select * from arquivosCompar order by nome");
			ResultSet rs = comando.executeQuery();
			ArrayList<ArquivosCompar> listaArq = new ArrayList<ArquivosCompar>();
			rs = comando.executeQuery();
					while (rs.next()) 
					{
					ArquivosCompar arq = new ArquivosCompar();
					arq.setCodigo(rs.getString("codigo"));
					arq.setData(rs.getString("data"));
					arq.setPasta(rs.getString("pasta"));
					arq.setNome(rs.getString("nome"));
					arq.setTamanho(rs.getLong("tamanho"));
					arq.setTipo(rs.getString("tipo"));
					arq.setUsuario(rs.getString("usuario"));
					arq.setUsuarioCompar(rs.getString("usuarioCompar"));
					
					listaArq.add(arq);
					}
			rs.close();
			comando.close();
			conexao.close();
			return listaArq;
			}


			public ArrayList<ArquivosCompar> listarArqComumCompar(TabUsuariosCompar usuariosCompar) throws SQLException 
			{
			PreparedStatement comando = conexao.prepareStatement("SELECT codigo, pasta, nome, tamanho, tipo, usuario, usuarioCompar, texto,  DATE_FORMAT(`data`, '%d/%m/%Y às %Hh%i') as `data_formatada` from arquivosCompar where ((usuario = ?) and (usuarioCompar = ?)) or  ((usuario = ?) and (usuarioCompar = ?))   order by data ASC");
			comando.setString(1, usuariosCompar.getUsuario());
			comando.setString(2, usuariosCompar.getUsuarioCompar());
			comando.setString(4, usuariosCompar.getUsuario());
			comando.setString(3, usuariosCompar.getUsuarioCompar());
			ResultSet rs = comando.executeQuery();
			ArrayList<ArquivosCompar> listaArqCompar = new ArrayList<ArquivosCompar>();
			rs = comando.executeQuery();
				while (rs.next()) 
				{
				ArquivosCompar arq = new ArquivosCompar();
				arq.setCodigo(rs.getString("codigo"));
				arq.setData(rs.getString("data_formatada"));
				arq.setPasta(rs.getString("pasta"));
				arq.setNome(rs.getString("nome"));
				arq.setTamanho(rs.getLong("tamanho"));
				arq.setTipo(rs.getString("tipo"));
				arq.setUsuario(rs.getString("usuario"));
				arq.setUsuarioCompar(rs.getString("usuarioCompar"));
				arq.setTexto(rs.getString("texto"));
				
				listaArqCompar.add(arq);
				}
			rs.close();
			comando.close();
			conexao.close();
			return listaArqCompar;
			}
			
			
			public ArrayList<ArquivosCompar> testelistarData() throws SQLException 
			{
			PreparedStatement comando = conexao.prepareStatement("SELECT codigo,  DATE_FORMAT(`data`, '%d/%m/%Y às %Hh%i') as `data_formatada`  from arquivosCompar");
			
			ResultSet rs = comando.executeQuery();
			ArrayList<ArquivosCompar> listaArqCompar = new ArrayList<ArquivosCompar>();
			rs = comando.executeQuery();
				while (rs.next()) 
				{
				ArquivosCompar arq = new ArquivosCompar();
				arq.setCodigo(rs.getString("codigo"));
				arq.setData(rs.getString("data_formatada"));
				listaArqCompar.add(arq);
				}
			rs.close();
			comando.close();
			conexao.close();
			return listaArqCompar;
			}
			
			
			public ArrayList<ArquivosCompar> TestelistarArqComumCompar(TabUsuariosCompar usuariosCompar) throws SQLException 
			{
			PreparedStatement comando = conexao.prepareStatement("SELECT   DATE_FORMAT(`data`, '%d/%m/%Y às %Hh%i') as `data_formatada`  from arquivosCompar where ((usuario = ?) and (usuarioCompar = ?)) or  ((usuario = ?) and (usuarioCompar = ?))   order by data ASC");
			comando.setString(1, usuariosCompar.getUsuario());
			comando.setString(2, usuariosCompar.getUsuarioCompar());
			comando.setString(4, usuariosCompar.getUsuario());
			comando.setString(3, usuariosCompar.getUsuarioCompar());
			ResultSet rs = comando.executeQuery();
			ArrayList<ArquivosCompar> listaArqCompar = new ArrayList<ArquivosCompar>();
			rs = comando.executeQuery();
				while (rs.next()) 
				{
				ArquivosCompar arq = new ArquivosCompar();
				arq.setCodigo(rs.getString("codigo"));
				arq.setData(rs.getString("data_formatada"));
				arq.setPasta(rs.getString("pasta"));
				arq.setNome(rs.getString("nome"));
				arq.setTamanho(rs.getLong("tamanho"));
				arq.setTipo(rs.getString("tipo"));
				arq.setUsuario(rs.getString("usuario"));
				arq.setUsuarioCompar(rs.getString("usuarioCompar"));
				arq.setTexto(rs.getString("texto"));
				
				listaArqCompar.add(arq);
				}
			rs.close();
			comando.close();
			conexao.close();
			return listaArqCompar;
			}
			
}


	

	



