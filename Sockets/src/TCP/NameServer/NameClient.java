package TCP.NameServer;

import java.lang.*; 
import java.util.*;
import java.net.*; 
import java.io.*;

public class NameClient 
{
	BufferedReader din;
    PrintStream pout;
    
    public void getSocket()throws IOException 
    {
    	System.out.println("entra - name: "+Symbols.nameServer+", port: "+Symbols.ServerPort);
        Socket server = new Socket( Symbols.nameServer, Symbols.ServerPort );
        //System.out.println("sale");
        din = new BufferedReader( new InputStreamReader( server.getInputStream() ) );
        pout = new PrintStream( server.getOutputStream() );
    }
    
    public int insertName( String name, String hname, int portnum )throws IOException 
    {
        getSocket();
        pout.println( "insert " + name + " " + hname + " " + portnum );
        pout.flush();
        System.out.println( "insert " + name + " " + hname + " " + portnum );
        return Integer.parseInt( din.readLine() );
    }
    
    
    public PortAddr searchName( String name )throws IOException
    {
        getSocket();
        pout.println( "search " + name );
        pout.flush();
        System.out.println("pasa");
        String result = din.readLine();
        StringTokenizer st = new StringTokenizer( result );
        String named = st.nextToken();
        int portnum = Integer.parseInt( st.nextToken() );
        String hname = st.nextToken();
        
        return new PortAddr( named, hname, portnum );
    }
    
    public static void main(String[] args) {
        NameClient myClient = new NameClient();
        try {
            myClient.insertName( "mydomain", "climate.cs.buap.mx", 1000 );
            System.out.println("se inserta");
            PortAddr pa = myClient.searchName( "mydomain" );
            System.out.println("se encuentra");
            System.out.println( pa.getName() + ":" + pa.getHostName() + ":" + pa.getPort() );
        } catch (Exception e) 
        {
            System.err.println("Client aborted: " + e);
        }
    }
}
