package codigo;
import gui.MyCanvas;

public class Consumidor implements Runnable {

	BufferLimitado b = null;
	int n_consumos = 0, t_consumo = 0;
	MyCanvas canvas;
	
	public Consumidor( BufferLimitado initb, int n_consumos, int t_consumo, MyCanvas canvas ) {

		b = initb;
		new Thread( this ).start();
		this.n_consumos = n_consumos;
		this.t_consumo = t_consumo;
		this.canvas = canvas;

	}
	
	public void run() {
		double item;
		while( n_consumos > 0 ){
			item = b.fetch();
			System.out.printf( "Artículo extraído %.2f \n", item);
			canvas.nProductosBuffer--;
			canvas.consumidorActivo = true;
			canvas.slotConsumidorActivo = true;
			canvas.repaint();
			// * Original
			// Util.mySleep(200);
			// * A
			//Util.mySleep(2000);
			// * B
			Util.mySleep(t_consumo);
			canvas.consumidorActivo = false;
			canvas.slotConsumidorActivo = false;
			canvas.repaint();
			
			n_consumos--;
		}
	}

}