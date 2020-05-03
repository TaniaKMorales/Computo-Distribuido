package codigo;

import gui.MyCanvas;

public class BufferLimitado{

	final int size = 10;
	double buffer[] = new double[size];
	int inBuf = 0, outBuf = 0;
	MyCanvas canvas;
	
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador isEmpty = new SemaforoContador(0);
	SemaforoContador isFull = new SemaforoContador( size );
	
	public BufferLimitado(MyCanvas canvas) {
		this.canvas = canvas;
	}
	
	public void deposit( double value ){
		
		canvas.cableProductorActivo = false;
		canvas.globalActivo = false;
		canvas.repaint();
		
		isFull.P(); // espera si el buffer está lleno
			mutex.P(); // asegura la exclusión mutua
				canvas.cableProductorActivo = true;
				canvas.globalActivo = true;
				canvas.repaint();
				buffer[inBuf] = value;
				inBuf = (inBuf + 1) % size;
			mutex.V();
		isEmpty.V(); // notifica a algún consumidor en espera
	}
	
	public double fetch(){	
		double value;
		
		canvas.cableConsumidorActivo = false;
		canvas.globalActivo = false;
		canvas.repaint();
		
		isEmpty.P(); // esperar si el buffer está vacío
			mutex.P(); // asegura la exclusión mutua
				canvas.cableConsumidorActivo = true;
				canvas.globalActivo = true;
				canvas.repaint();
				value = buffer[outBuf]; // lee desde el buffer
				outBuf = (outBuf+1) % size;
			mutex.V();
		isFull.V(); // notifica a cualquier productor en espera
		
		return value;
	}
	
}