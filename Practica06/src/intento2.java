
class intento2 implements Lock
{
	boolean pedirCR[] = {false, false};
	
	public void requestCR (int i)
	{
		pedirCR[i] = true;
		while(pedirCR[1-i]);
	}
	
	public void releaseCR (int i)
	{
		pedirCR[i] = false;
	}

}
