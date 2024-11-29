package IOStream;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TestaSaida {

	public static void main(String[] args) throws IOException 
	
	{
		String texto = "teste teste teste";
		OutputStream	os	=	new	FileOutputStream("C:/arquivo.txt");
		OutputStreamWriter	osw	=	new	OutputStreamWriter(os);
		BufferedWriter	bw	=	new	BufferedWriter(osw);
		bw.write(texto);
		bw.close();
	}

}
