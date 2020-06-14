import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Practica01 {
 
    public static void main(String[] args) {
 
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
        	System.out.println("Tania Karina Castillo Morales");
        	System.out.println("1. Salida de texto y asignacion de variables");
            System.out.println("2. Nombres validos de variables y operaciones");
            System.out.println("3. Salida de texto, variables y operaciones");
            System.out.println("4. Expresiones aritmeticas");
            System.out.println("5. Jerarquia de operadores");
            System.out.println("6. Tres formas distintas de imprimir en consola");
            System.out.println("7. Resolucion de problemas");
            System.out.println("8. Salir");
             
            try {
 
                System.out.println("Ingresa una opcion");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa un flotante");
                        float a = 0, b = 0, c= 0;
                        a = b *c;
					break;                        
                    case 2:
                        System.out.println("Nombres validos de variables y operaciones");
                        System.out.println("Repuestas en el documento");
                        break;
                    case 3:
                    	int x=3, y=2;
                    	System.out.printf("x= %d \n", x);
                    	System.out.printf("El valor de %d + %d es %d \n", x, x, (x+x));
                    	System.out.printf("x =");
                    	System.out.printf("%d = %d \n", (x+y), (y+x));
                        break;
                    case 4:
                        System.out.println("Nombres validos de variables y operaciones");
                        System.out.println("Repuestas en el documento");
                        break;
                    case 5:
                        System.out.println("Jerarquia de operadores");
                        a = 7 + 3 * 6 / 2 - 1;
                        System.out.println(a);
                        b = 2 % 2 + 2 * 2 - 2 / 2;
                        System.out.println(b);
                        c = (3 * 9 * (3 + ( 9 * 3 / (3))));
                        System.out.println(c);
                        break;
                    case 6:
                        System.out.println("Tres formas distintas de imprimir en consola");
                        System.out.print("1 2 3 4");
                        System.out.println("1");
                        System.out.println("2");
                        System.out.println("3");
                        System.out.println("4");
                        System.out.printf("1 2 3 4");
                        break;
                    case 7:
                        System.out.println("Resolucion de problemas");
                        int n,k;
                        System.out.println("Ingresa el valor de N");
                        n = sn.nextInt();
                        double suma = 0.0;
                        for (k = 1; k <= n; k++)
                        {
                        	suma += 1.0 / k;
                        }
                        System.out.printf("H(%d) = %f \n", k ,suma);
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
 
}