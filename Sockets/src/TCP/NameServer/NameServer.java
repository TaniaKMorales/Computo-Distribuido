package TCP.NameServer;

import java.util.*;
import java.net.*;
import java.io.*;

public class NameServer 
{
	NameTable table;
	
	public NameServer() 
	{
		table = new NameTable();
	}
	
	void handleclient(Socket theClient) {
		try{
			System.out.println("se crea");
			
			BufferedReader din = new BufferedReader( new InputStreamReader( theClient.getInputStream() ) );
			PrintWriter pout = new PrintWriter( theClient.getOutputStream() );
			
			String getline = din.readLine();
			StringTokenizer st =  new StringTokenizer( getline );
			String tag = st.nextToken();
			
			if( tag.equals("search") ) {
				System.out.println("buscar");
				
				int index = table.search( st.nextToken() );
				
				if( index == -1 )
					pout.println( (-1) + " " + "nullhost" );
				else
					pout.println( table.getName( index ) + " " + table.getPort( index ) + " " + table.getHostName( index ) );
			}
			else
				if( tag.equals( "insert" ) ) {
					System.out.println("insertar");
					
					String name = st.nextToken();
					String hostName =  st.nextToken();
					int port = Integer.parseInt( st.nextToken() );
					int retValue = table.insert(name, hostName, port);		
					pout.println( retValue );
				}
			
			pout.flush();
			
		}catch( IOException e )
		{
			System.err.println(e);
		}
	}

	public static void main(String[] args) 
	{
		NameServer ns = new NameServer();
		System.out.println( "NameServer started: " );
		
		try{
			ServerSocket listener = new ServerSocket( Symbols.ServerPort );
			
			while( true )
			{
				//System.out.println("escuchando..");
				Socket aClient = listener.accept();
				ns.handleclient(aClient);
				aClient.close();
			}
		}catch( IOException e )
		{
			System.err.println( "Server aborted: " + e );
		}
	}
}