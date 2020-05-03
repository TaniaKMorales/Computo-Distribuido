package Monitores;

public class Main 
{
	public static void main(String[] args)
	{
		Mesa buffer = new Mesa();
		Filosofos filosofos[] = new Filosofos[5];
		
		for (int i = 0; i < 5; i++)
		{
			filosofos[i] = new Filosofos(buffer,i);
		}
	}

}
