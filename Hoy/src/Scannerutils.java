import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
/*
Aqui hay 3 scanners diferentes, uno de ellos te pide un int para los tamaños que no pueden ser menores a 0
porque no tiene sentido, que es el getint.
otro te pide en un bucle 3 veces un valor entre 0 y 255 para el rgb, queria hacer que cada bucle te pidiera
la letra correspondiente a lo plan color R color G color B pero me daba error y he optado por ponerlo de manera
menos trabajada, pero funciona bien que de eso se trata, Basicamente hay que poner un valor entre 0 y 255 3 veces para generar 1 color.
los otros 2 son scanners para los menus, cada uno con las opciones posibles que tienen y aceptando el valor 0
lo que lo diferencia de los otros.
 */
public class Scannerutils
{
    Scanner sc;

    public Scannerutils()
    {
        sc = new Scanner(System.in);
    }

    public int showMessageAndGetInt(String message)
    {
        System.out.println(message);
        int numero = -1;
        while (numero < 1)
        {
            try
            {
                numero = sc.nextInt();
                if (numero < 1)
                    System.out.println("Solo se permiten valores enteros positivos");
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

    public String showMessageAndGetColor(String message)
    {
        System.out.println(message);
        String colorCode = "";
        int correctNumbers = 0;
        while (correctNumbers < 3)
        {
            try
            {
                System.out.println("Introduce el primer valor de R entre 0 y 255 intro, luego valor de G entre 0 y 255 intro y luego valor B entre 0 y 255 intro");
                int numero = sc.nextInt();
                if (numero > 255 || numero < 0)
                    System.out.println("Solo se permiten valores entre 0 y 255");
                else
                {
                    colorCode += numero + " ";
                    correctNumbers++;
                }
                sc.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println("Solo se permiten numeros Enteros");
                sc.nextLine();
            }
        }
        return colorCode;
    }

    public int showMessageAndGetIntmenu(String message)
    {
        System.out.println(message);
        int numero = -1;
        while (numero < 0 || numero > 6)
        {
            try
            {
                numero = sc.nextInt();
                if (numero < 0)
                    System.out.println("Solo se permiten valores enteros positivos");
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

    public int showMessageAndGetIntmenudos(String message)
    {
        System.out.println(message);
        int numero = -1;
        while (numero < 0 || numero > 5)
        {
            try
            {
                numero = sc.nextInt();
                if (numero < 0)
                    System.out.println("Solo se permiten valores enteros positivos");
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

