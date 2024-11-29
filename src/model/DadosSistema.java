package model;

public class DadosSistema 

{
	
	private String usuBD= "root";
	private String senhaBD = "root";
	//private String dirArq = "E:/ArquivosWeb/";
	//private String senhaBD = "admin";
	//private String dirArq = "C:/Users/71553649168/Desktop/Desenvolvimento/Arquivos";
	private String dirArq = "C:/eclipse/ArquivosWeb";
	
	
	
	public String getSenhaBD() 
	{
		return senhaBD;
	}
	public void setSenhaBD(String senhaBD) 
	{
		this.senhaBD = senhaBD;
	}
	public String getDirArq() 
	{
		return dirArq;
	}
	public void setDirArq(String dirArq) 
	{
		this.dirArq = dirArq;
	}
	public String getUsuBD() 
	{
		return usuBD;
	}
	public void setUsuBD(String usuBD) 
	{
		this.usuBD = usuBD;
	}


}
