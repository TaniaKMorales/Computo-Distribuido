package segunda;

public class Despachador implements Lock
{
	volatile int N;
	volatile boolean[] choosing;
	volatile int[] number;
	
	public Despachador(int numProc)
	{
		N = numProc;
		choosing = new boolean[N];
		number = new int[N];
		for(int j=0; j<N; j++)
		{	
			choosing[j] = false;
			number[j] = 0;
		}
	}
	
	public void requestCR(int pid)
	{
		choosing[pid] = true;
		for(int j=0; j<N; j++)
		{
			if(number[j] > number[pid])
			{
				number[pid] = number[j];
			}
		}
		number[pid]++;
		choosing[pid] = false;
			
		for(int j=0; j<N; j++)
		{		
			while(choosing[j]);
			while((number[j] != 0) && ((number[j] < number[pid]) || ((number[j] == number[pid]) && j < pid)));
		}
	}
	
	public void releaseCR(int pid)
	{
		number[pid] =0;
	}
}
