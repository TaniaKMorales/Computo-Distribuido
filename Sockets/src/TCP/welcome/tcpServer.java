package TCP.welcome;

import java.io.*;
import java.net.*;

public class tcpServer 
{
	public static void main(String argv[]) throws Exception
	{
		String fraseCliente = " ";
		String frase;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		
		System.out.println( "ECO-Server started... " );
		Socket connectionSocket = welcomeSocket.accept();
			
			InputStream is = connectionSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader inFromClient = new BufferedReader(isr);
			
			OutputStream os = connectionSocket.getOutputStream();
			DataOutputStream outToClient = new DataOutputStream(os);
		while(!fraseCliente.isEmpty())
		{
			fraseCliente = inFromClient.readLine();
			System.out.println("Mensaje recibido: " + fraseCliente);
			
			frase = fraseCliente.toUpperCase() + '\n';
			outToClient.writeBytes( frase );
			welcomeSocket.close();
		}
		System.out.print( "Mensaje vacío.. Conexion terminada." );
	}
}
