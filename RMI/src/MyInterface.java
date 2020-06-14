import java.rmi.*;

public interface MyInterface extends Remote {
	// Definición del método remoto
	public String cuentaCaracteres(String input)throws RemoteException; 
}