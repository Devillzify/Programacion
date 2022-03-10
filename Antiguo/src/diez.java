package Principiante;

import java.util.Scanner;
public class diez
{
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.println("mete un numero");
            System.exit(1);
        }
        int numero = Integer.parseInt(args[0]);
        Scanner entrada = new Scanner(System.in);
        while (numero != 0)
        {
            int numerocuadrado = (numero * numero);
            System.out.println("El cuadrado de " + numero + " es igual a " + numerocuadrado);
            if (numero % 2 == 0)
            {
                System.out.println("El numero es par");
            }
            else
            {
                System.out.println("El numero " + numero + " no es par");
            }

            if (numero > 0)
            {
                System.out.println("el numero " + numero + "es positivo");
            }
            if (numero < 0)
            {
                System.out.println("el numero " + numero + "es negativo");
            }
            System.out.println("mete un numero");
            numero = entrada.nextInt();
        }
    }
}
