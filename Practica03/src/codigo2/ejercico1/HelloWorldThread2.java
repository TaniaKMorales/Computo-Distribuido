package codigo2.ejercico1;

public class HelloWorldThread2 extends Thread 
{
	int pid;
	static String nombre;
	
	public HelloWorldThread2(String nombre)
	{
		HelloWorldThread2.nombre = nombre;
	}
	
	public long getId(int pid)
	{
		return this.getId();
	}
	public void run()
	{
		System.out.println("Mi nombre es");	
		System.out.println("Mi ID es");
	}

	public static void main(String[] args)
	{
		HelloWorldThread2 t = new HelloWorldThread2(nombre);
		t.start();

	}

}
