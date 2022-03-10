package Principiante;

public class Doblers
{
    public static void main(String[] args)
    {
        int[] currency ={50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        if(args.length != 1)
        {
            System.err.println("Debe proporcionar un precio");
            System.exit(4);
        }
        double precio = Double.parseDouble(args[0]);
        int centimos = (int)(precio * 100);

        for( int i = 0; i < currency.length; i++)
        {
            int cantidad = 0;
            while (centimos >= currency[i])
            {
                cantidad++;
                centimos -= currency[i];
            }
            if (cantidad != 0)
            {
                System.out.format("%d de %d" , cantidad, currency[i]);
            }
        }
    }
}
