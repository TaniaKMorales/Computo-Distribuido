package Semaforos;

class Mesa
{
	
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoBinario sinc[] = new SemaforoBinario[5];
	ListaCircular<String> estadoOf = new ListaCircular<String>();
	
	public Mesa() 
	{
		for(int i =0; i < 5 ; i++) 
		{
			sinc[i] = new SemaforoBinario(false);
			estadoOf.add("PENSAR");
		}
	}
	
	public void Probar_Bocado(int i) 
	{
		if (estadoOf.get(i) == "HAMBRE" && estadoOf.get(i - 1) != "COMER" && estadoOf.get(i + 1) != "COMER") 
		{
			estadoOf.set(i, "COMER");
			sinc[i].V();
		}
	}
	
	public void Tomar_Tenedores(int i) 
	{
		mutex.P();
			estadoOf.set(i, "HAMBRE");
			Probar_Bocado(i);
		mutex.V();
		sinc[i].P();
	}

	public void Bajar_Tenedores(int i) 
	{
		mutex.P();
			Probar_Bocado(i - 1);
			Probar_Bocado(i + 1);
		mutex.V();
	}
	
}