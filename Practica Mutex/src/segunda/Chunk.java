package segunda;

import segunda.Coordenada;

public class Chunk {

	private Coordenada cpos;
	private int crows;
	private int ccols;
	
	public Chunk()
	{
		cpos = null;
		crows = 0;
		ccols = 0;
	}
	
	public Chunk(int x, int y, int r, int c)
	{
		cpos = new Coordenada(x, y);
		crows = r;
		ccols = c;
	}
	
	public int getCRows()
	{
		return crows;
	}
	
	public int getCCols()
	{
		return ccols;
	}
	
	public int getX()
	{
		return cpos.getX();
	}
	
	public int getY()
	{
		return cpos.getY();
	}
	
	public void setCRows(int r)
	{
		crows = r;
	}
	
	public void setCCols(int c)
	{
		ccols = c;
	}
	
	public void setX(int x)
	{
		cpos.setX(x);
	}
	
	public void setY(int y)
	{
		cpos.setY(y);
	}
}

