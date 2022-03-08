package Principiante;

public class factorio
{
    public static void main(String[] args)
    {
        int factor = Integer.parseInt(args[0]);
        float resultado = 1;
        for( int i = factor; i > 0; i --)
        {
            System.out.print(i);
            if(i > 1)
            {
                System.out.print(" x ");
            }
            else
            {
                System.out.print(" = ");
            }
           resultado = resultado * i;

        }
        System.out.print(resultado);

    }
}
