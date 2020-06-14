package Calculadora;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class CClient 
{
	private static final String url = "localhost";
	private static final int PUERTO = 1100;
	private static Scanner sc;
	
	public static void  main(String argv[]) throws RemoteException, NotBoundException 
	{
		Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
		CInterface cinterface = (CInterface) registry.lookup("Calculadora");
		sc = new Scanner(System.in);
		int opc;
		float a = 0 , b, res=0;
		String menu = "\n\n --------------\n\n[-1] => Salir\n[0] => Sumar\n[1] => Restar\n[2] => Multiplicar\n[3] => Dividir\n Elige una opcion:";
		do
		{
			System.out.println(menu);
			
			try{
				opc = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e){
				opc = -1;
			}
			
			if(opc != -1)
			{
				System.out.println("Ingresa el primer número: ");
            	try{
                	a = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		b = 0;
            	}
            	System.out.println("Ingresa el segundo número: ");
            	try{
                	b = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		b = 0;
            	}
            	
            	 switch (opc) {
	                case 0:
	                    res = cinterface.sumar(a, b);
	                    break;
	                case 1:
	                    res = cinterface.restar(a, b);
	                    break;
	                case 2:
	                    res = cinterface.multiplicar(a, b);
	                    break;
	                case 3:
	                    res = cinterface.dividir(a, b);
	                    break;
	            }
            	System.out.println("E resultado es: => " + String.valueOf(res));
                System.out.println("Presiona ENTER para continuar");
                sc.nextLine();
			}
		}while (opc != -1);
	}
}
