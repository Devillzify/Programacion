package Principiante;

public class ocho
{
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.println("introduce un numero del 1 al 10");
            System.exit(1);
        }
        int nota = Integer.parseInt(args[0]);
        if(nota < 0 || nota > 10)
        {
            System.out.println("introduce un numero entre 0 y 10");
            System.exit(1);
        }
        if(nota < 5)
        {
            System.out.println("La nota " + nota + " es Insuficiente");
        }
        if(nota == 5)
        {
            System.out.println("La nota " + nota + " es suficiente");
        }
        if(nota > 5 && nota < 7)
        {
            System.out.println("La nota " + nota + " esta bé");
        }
        if(nota > 6 && nota <9)
        {
            System.out.println("La nota " + nota + " es un Notable");
        }
        if(nota >=9)
        {
            System.out.println("La nota " + nota + " es un Exelente");
        }

    }
}
