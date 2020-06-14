package ejercicio1.codigo3;

public class Fib extends Thread
{
	private int x;
	public int resultado;

public Fib(int x) 
{
	this.x = x;
}

public void run() 
{
	if( x <= 2 )
		resultado = 1;
	else 
	{
		try 
		{
			Fib f1 = new Fib(x-1);
			Fib f2 = new Fib(x-2);
			f1.start();
			f2.start();
			f1.join();
			f2.join();
			resultado = f1.resultado + f2.resultado;
		}
		catch(InterruptedException ex) { }
	}
}

public static void main(String[] args)
throws Exception
{
	try 
	{
		Fib f = new Fib( Integer.parseInt(args[0]) );
		f.start();
		f.join();
		System.out.println("La Respuesta es: " + f.resultado);
	}
	catch(Exception e) 
	{
		System.out.println("usage: java Fib NUMBER");
}
}
}