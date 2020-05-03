package codigo;

public class ProductorConsumidor
{
	
	public static void main(String args[]) {
		BufferLimitado buffer = new BufferLimitado(null);
		Productor productor = new Productor( buffer, 0, 0, null );
		Consumidor consumidor = new Consumidor( buffer, 0, 0, null );
	}
	
}