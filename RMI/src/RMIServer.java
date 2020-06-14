import java.rmi.*;
import java.rmi.server.*;

public class RMIServer extends UnicastRemoteObject implements MyInterface { 
	
  	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RMIServer()throws RemoteException {
        System.out.println("Servidor remoto en ejecución!!"); 
    }  
    
	public static void main(String argv[]) { 
		try {
			RMIServer objetoRemoto = new RMIServer();
		    Naming.rebind("MyInterfaceRMI", objetoRemoto);
		}  
		catch(Exception e) {
			System.out.println("Excepción ocurrida: "+e.getMessage()); 
		} 
	}
		
	public String cuentaCaracteres(String input) throws RemoteException {
	    System.out.println("Se recibe "+ input+"  en el servidor!!");
		String respuesta;
		respuesta = "Has escrito "+ input.length() +"  caracteres!!";
		return respuesta;
	}
}