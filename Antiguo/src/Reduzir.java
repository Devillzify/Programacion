package Principiante;

public class Reduzir
{
    public static void main(String[] args)
    {
        String numerodado = args[0];
        if(args.length != 1)
        {
            System.out.println("introduce el año");
            System.exit(1);
        }
        while (numerodado.length() > 1)
        {
            int resultado = 0;

            for (int i = 0; i < numerodado.length(); i++)
            {
                int posicion = Integer.parseInt(numerodado.charAt(i) + "" );

                resultado += posicion;
                String suma = " + ";
                System.out.print(posicion + suma);
            }
            System.out.println(" = " + resultado + " ");
            numerodado =  resultado + "";
        }
    }
}
