class BufferLimitado 
{
	final int size = 10;
	double buffer[] = new double [size];
	int inBuf = 0, outBuf = 0;
	
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador isEmpty = new SemaforoContador(0);
	SemaforoContador isFull = new SemaforoContador(size);

public void deposit (double value)
{			
	isFull.P(); //espera si el buffer esta lleno
	mutex.P(); //asegura la exclusion mutua
	buffer[inBuf] = value;
	inBuf = (inBuf + 1) % size;
	mutex.V();
	isEmpty.V(); //notifica a algun consumidor en espera
}

public double fetch()
{
	double value;
	isEmpty.P();//espera si el buffer esta vacio
	mutex.P();//asegura la excluson mutua
	value = buffer[outBuf];//leee desde el buffer
	outBuf = (outBuf+1) % size;
	mutex.V();
	isFull.V();//notifica a cualquier productor en espera
	return value;
}
}