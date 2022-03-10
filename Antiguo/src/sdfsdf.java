package Principiante;

public class sdfsdf
{
    public static void main(String[] args)
    {
        String numerodado = "364523578982";


        for(int i = 0; i < numerodado.length(); i++)
        {
            int numero = Integer.parseInt(numerodado.charAt(i) + "");

            for(int j = 0; j < numero; j++)
            {
                System.out.print("*");

            }
            System.out.println();
        }




    }
}