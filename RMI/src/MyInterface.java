import java.rmi.*;

public interface MyInterface extends Remote {
	// Definici�n del m�todo remoto
	public String cuentaCaracteres(String input)throws RemoteException; 
}