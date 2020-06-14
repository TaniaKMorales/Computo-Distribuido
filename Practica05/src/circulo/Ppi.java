
package circulo;

import java.util.Scanner;

public class Ppi {

double conta_cir=0;
double radio=0.5;
double PI=0;
double Xcentro=0.5;
double Ycentro=0.5;

 
 public void genera_p(double numPuntos){
	 
	 double aleatorio1=0;
	 double aleatorio2=0;
	 for (int i = 1; i <= numPuntos; i++) {
		    
		    
 aleatorio1=Math.random();
 aleatorio2=Math.random();

System.out.println("X: "+aleatorio1+"  Y: "+aleatorio2);
	 
if (Math.sqrt (((aleatorio1-Xcentro) *(aleatorio1-Xcentro)) + ((aleatorio2-Ycentro) *(aleatorio2-Ycentro))) < radio) 
{ System.out.println ("El punto si está en el círculo.");
conta_cir=conta_cir+1;
} 
else { System.out.println ("El punto no está en el círculo."); }	
	




	
	 
	 }
	 System.out.println("Puntos dentro del circulo "+conta_cir);
	 System.out.println("Total de puntos "+numPuntos);
	 
	 PI = 4.0* conta_cir/numPuntos;
	 System.out.println("El valor que mas se aproxima a PI es "+PI);

}
 
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		long time_ini, time_fin,timetotal;
		time_ini=System.currentTimeMillis();
		
		Ppi n=new Ppi();
		double puntos;
		System.out.println("Inserte el numero de puntos ");
		puntos=s.nextDouble();
		n.genera_p(puntos);
		time_fin=System.currentTimeMillis();
		
		timetotal=time_fin-time_ini;
		 System.out.println("****************************************");
		 System.out.println("Tiempo total de ejecucion "+timetotal+" en milisegundos");

		

	}

}
