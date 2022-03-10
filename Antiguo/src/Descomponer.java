package Principiante;

public class Descomponer
{
    public static void main(String[] args)
    {
        int numero = 101;
        int resultado = 0;

        for (int contador = 2; contador <= numero; contador++)
        {
            if (numero == 1)
            {
                break;
            }
            if (numero % contador == 0)
            {
                resultado = numero / contador;
                System.out.println(" el numero " + numero + " dividido entre " + contador + " da el resultado de " + resultado);
                numero = resultado;
                contador = 2;
            }
        }
    }
}


