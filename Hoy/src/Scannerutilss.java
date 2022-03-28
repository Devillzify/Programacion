import java.util.InputMismatchException;
import java.util.Scanner;
/*
En este scanner que es el de ordenada la unica restriccion que he puesto es que la cola debe ser mayor que 0
dado que con 0 no se puede hacer una cola
 */
public class Scannerutilss
{
    Scanner sc;

    public Scannerutilss()
    {
        sc = new Scanner(System.in);
    }

    public int showMessageAndGetInt(String message)
    {
        System.out.println(message);
        int numero = 0;
        {
            try
            {
                numero = sc.nextInt();
                if (numero < 1)
                    System.out.println("Solo se permiten valores enteros positivos con 0 personas no se hace una cola");
                else
                {
                    return numero;
                }

                sc.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println("Solo se permiten numeros Enteros");
                sc.nextLine();
            }
        }
        return numero;
    }
}
