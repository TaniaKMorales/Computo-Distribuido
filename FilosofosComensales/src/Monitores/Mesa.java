package Monitores;

class Mesa 
{
	ListaCircular<String> estadoOf = new ListaCircular<String>();
	
	public Mesa()
	{
		for (int i = 0; i < 5; i++)
		{
			estadoOf.add("PENSAR");
		}
	}
	
	public void Tomar_Tenedor(int i)
	{
		while(estadoOf.get(i -1) == "COMER" || estadoOf.get(i + 1) == "COMER")
		{
			Util.myWait(this);
		}
		estadoOf.set(i, "HAMBRE");
		Probar_Bocado(i);
	}
	
	public void Probar_Bocado(int i)
	{
		if(estadoOf.get(i) == "HAMBRE" && estadoOf.get(i -1) != "COMER" && estadoOf.get(i + 1) != "COMER")
		{
			estadoOf.set(i, "COMER");
		}
	}
	
	public void Bajar_Tenedores(int i)
	{
		Probar_Bocado(i - 1);
		Probar_Bocado(i + 1);
		estadoOf.set(i, "PENSAR");
	}

}
