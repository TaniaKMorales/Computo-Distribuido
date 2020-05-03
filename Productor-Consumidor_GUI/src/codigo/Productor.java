package codigo;
import java.util.Random;

import gui.MyCanvas;

public class Productor implements Runnable {

	BufferLimitado b = null;
	int n_productos = 0, t_produccion = 0;
	MyCanvas canvas;
	
	public Productor( BufferLimitado initb, int n_productos, int t_produccion, MyCanvas canvas) {
		b = initb;
		new Thread( this ).start();
		this.n_productos = n_productos;
		this.t_produccion= t_produccion;
		this.canvas = canvas;
	}
	
	public void run() {
		double item;
		Random r = new Random();
		while( n_productos > 0 ){
			item = r.nextDouble();
			System.out.printf( "Artículo producido %.2f \n", item );
			canvas.nProductosBuffer++;
			canvas.productorActivo = true;
			canvas.slotProductorActivo= true;
			canvas.repaint();
			b.deposit( item );
			// * Original
			//Util.mySleep(200);
			// * A
			//Util.mySleep(20);
			// * B
			Util.mySleep(t_produccion);
			canvas.productorActivo = false;
			canvas.slotProductorActivo= false;
			canvas.repaint();
			
			n_productos--;
		}
	}
	
}