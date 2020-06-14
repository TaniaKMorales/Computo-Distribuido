package UDP;

import java.io.DataInputStream;
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.StringTokenizer; 

public class CalculadoraServer 
{
	 public static void main(String args[]) throws IOException 
	    { 
	  
	       
	        ServerSocket ss = new ServerSocket(4444); 
	        Socket s = ss.accept(); 
	  
	 
	        DataInputStream dis = new DataInputStream(s.getInputStream()); 
	        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
	  
	        while (true) 
	        { 

	            String input = dis.readUTF(); 
	  
	            if(input.equals("Salir")) 
	                break; 
	  
	            System.out.println("Operacion recibida: -" + input); 
	            int result; 
	  
	           
	            StringTokenizer st = new StringTokenizer(input); 
	  
	            int oprnd1 = Integer.parseInt(st.nextToken()); 
	            String operation = st.nextToken(); 
	            int oprnd2 = Integer.parseInt(st.nextToken()); 
	  
	            
	            if (operation.equals("+")) 
	            { 
	                result = oprnd1 + oprnd2; 
	            } 
	  
	            else if (operation.equals("-")) 
	            { 
	                result = oprnd1 - oprnd2; 
	            } 
	            else if (operation.equals("*")) 
	            { 
	                result = oprnd1 * oprnd2; 
	            } 
	            else
	            { 
	                result = oprnd1 / oprnd2; 
	            } 
	            System.out.println("Calculando..."); 
	  

	            dos.writeUTF(Integer.toString(result)); 
	        } 
	    } 
}
