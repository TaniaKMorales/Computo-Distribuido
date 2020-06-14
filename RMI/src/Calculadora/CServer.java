package Calculadora;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CServer
{
	private static final int PUERTO = 1100;
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException
	{
		Remote remote = UnicastRemoteObject.exportObject(new CInterface(){
			
			public float sumar(float a, float b) throws RemoteException {
				return a + b;
			}
			public float restar(float a, float b) throws RemoteException {
				return a - b;
			}
			public float multiplicar(float a, float b) throws RemoteException {
				return a * b;
			}
			public float dividir(float a, float b) throws RemoteException {
				return a / b;
			}
		},0);
		Registry registry = LocateRegistry.createRegistry(PUERTO);
		System.out.println("Servidor conectado en el puerto " + String.valueOf(PUERTO));
		registry.bind("Calculadora", remote);
	}
}