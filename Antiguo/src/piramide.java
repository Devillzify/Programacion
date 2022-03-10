package Principiante;

public class piramide
{
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.print("Payaso");
            System.exit(6);
        }
        int altura = Integer.parseInt(args[0]);
        int espacios = altura;
        int asteriscos = 1;


        for (int i = 0; i < altura; i++)
        {
            for (int j = 0; j < espacios; j++)
            {
                System.out.print(" ");

            }
                for (int k = 0; k < asteriscos; k++)
                {
                System.out.print("*");
                }
                System.out.println();
            espacios--;
            asteriscos += 2;
        }



    }
}

