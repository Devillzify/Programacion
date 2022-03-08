package Principiante;

public class trece
{
    public static void main(String[] args)
    {
        int numero = Integer.parseInt(args[0]);
        int cantidad = 0;
        int primos = 0;


        for (int i = numero; i > 0; i--)
        {
            boolean esprimo = true;
            for (int j = i - 1; j > 1; j--)
            {
                if (i % j == 0)
                {
                    esprimo = false;
                }
            }
            if (esprimo)
            {
                primos++;
                System.out.println(i + " es primo");
            }
        }
        System.out.println("Hay " + primos + " primos entre 1 y " + numero);

    }
}

