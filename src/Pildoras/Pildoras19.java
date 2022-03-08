package Pildoras;

import java.util.*;
public class Pildoras19
{
    public static void main(String[] args)
    {
        int aleatorio =(int)(Math.random() * 100);

        System.out.println(aleatorio);

        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        int intentos = 0;

        while( numero != aleatorio)
        {
            intentos++;
            System.out.println("Introduce un numero");

            numero = entrada.nextInt();

            if(aleatorio<numero)
            {
                System.out.println("mas bajo");
            }
            if(aleatorio>numero)
            {
                System.out.println("mas alto");
            }

        }
        System.out.println("Correcto");
        System.out.println("has necesitado " + intentos + " intentos ");
    }
}
