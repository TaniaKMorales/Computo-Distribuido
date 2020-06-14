package calculadora.op;

public class OpComplejas
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
	public String raiz(float num1)
	{
		return String.valueOf(Math.sqrt(num1));
	}
	
	public String PotenciaCuadrada(float num1)
	{
		return String.valueOf(num1 * num1);
	}
	
	public String Potencia(float num1, float num2)
	{
		return String.valueOf(Math.pow(num1, num2));
	}
	
	public String Modulo(float num1, float num2)
	{
		return String.valueOf(num1 % num2);
	}
}