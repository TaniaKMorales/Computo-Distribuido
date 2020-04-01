package segunda;

public class Coordenada {

	private int x;
	private int y;
	
	public Coordenada()
	{
		x = 0;
		y = 0;
	}
	
	public Coordenada(int cX, int cY)
	{
		x = cX;
		y = cY;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int cX)
	{
		x = cX;
		return;
	}
	
	public void setY(int cY)
	{
		y = cY;
		return;
	}
	
	public void setCoordenadas(int cX, int cY)
	{
		x = cX;
		y = cY;
		return;
	}
}
