package Principiante;

public class Interpolar
{
    public static void main(String[] args)
    {
        if(args.length != 3)
        {
            System.err.println("Introduce 3 numeros");
            System.exit(1);
        }
        try
        {
            double primero = Double.parseDouble(args[0]);
            double segundo = Double.parseDouble(args[1]);
            int cantidad = Integer.parseInt(args[2]);

            double delta = (segundo - primero) / ( cantidad - 1);
            double numero = primero;

            for( int c = 0; c < cantidad; c++)
            {
                System.out.format("%5.2f\n", numero);// el 5 son las posiciones. el 2 los decimales
                numero = numero + delta;
            }
        }
        catch(NumberFormatException nfe)
        {
            System.err.println("Error formato");
        }

    }
}
