package Ejercicio1.Despachador;



class Despachador  
{
	static int a;
	static int b;
	
	public Despachador()
	{
		a = b = 0;		
	}
	
	public static int opc1()
	{
		a = 1;
		return b;
	}
	
	public static int opc2()
	{
		b = 2;
		return 3*a;
	}

class TestDespachador extends Despachador implements Runnable
{
	
	String nombre;

	public TestDespachador(String nombre)
	{
		this.nombre = nombre;
			
	}

	public void run() 
	{
		
		TestDespachador p1 = new TestDespachador(nombre);
		TestDespachador p2 = new TestDespachador(nombre);
		
		
		
		System.out.println( opc1() + "Opcion 1 " + p1);
		
		
				
	}

	

	public void main( String[] args )
	{
		TestDespachador p1 = new TestDespachador( nombre );
	
		TestDespachador p2 = new TestDespachador( nombre);
		
		System.out.println( opc2() + "Opcion 2 " + p2);
	}
	
}
}
