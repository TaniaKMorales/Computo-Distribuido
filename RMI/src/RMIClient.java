import java.rmi.*;
import java.io.*;

public class RMIClient {
	
	public static void  main(String argv[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			MyInterface objetoAsociado = (MyInterface)Naming.lookup("MyInterfaceRMI");
			
			System.out.println("Escribe una frase: ");
			String input=br.readLine();
			
			System.out.println(objetoAsociado.cuentaCaracteres(input));
		}
		catch(Exception e){
			System.out.println("Excepción ocurrida: "+e.getMessage());
		}
	}
}