package Monitores;

public class Filosofos implements Runnable 
{
	Mesa mesa = null;
	int i;
	
	public Filosofos(Mesa mesa, int i)
	{
		this.i = i;
		this.mesa = mesa;
		
		new Thread(this).start();
	}
	
	public void run()
	{
		while(true)
		{
			System.out.println(" Filosofo: " + i + " Pensando ");
			mesa.Tomar_Tenedor(i);
			Util.mySleep(2000);
			
			System.out.println("Filosofo: " + i + " Tenedores Arriba: " + i + ", " + ((i + 1) % 5));
			Util.mySleep(2000);
			mesa.Bajar_Tenedores(i);
			
			System.out.println("Filosofo: " + i + " Tenedores Abajo: " + i + ", " + ((i + 1) % 5));
			
		}
	}

}
