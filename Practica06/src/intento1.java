import java.util.concurrent.locks.Lock;

abstract class intento1 implements Lock
{
	boolean abrePuerta = true;
	
	public void requestCR (int i)
	{
		while(!abrePuerta);
		abrePuerta = false;
	}
	
	public void releaseCR (int i)
	{
		abrePuerta = true;
	}

}
