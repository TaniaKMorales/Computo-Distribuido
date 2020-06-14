package UDP;

import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.InetAddress; 
import java.net.Socket; 
import java.net.UnknownHostException; 
import java.util.Scanner; 

public class CalculadoraClient 
{
	public static void main(String[] args) throws IOException 
    { 
        InetAddress ip = InetAddress.getLocalHost(); 
        int port = 4444; 
        Scanner sc = new Scanner(System.in); 
  

        Socket s = new Socket(ip, port); 

        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
  
        while (true) 
        { 
          
            System.out.print("Ingrese la operacion de la siguiente forma: "); 
            System.out.println("'NumeroUno Operador NumeroDos'"); 
  
            String inp = sc.nextLine(); 
  
            if (inp.equals("Salir")) 
                break; 
  
            dos.writeUTF(inp); 
  

            String ans = dis.readUTF(); 
            System.out.println("Resultado =" + ans); 
        } 
    }
}
