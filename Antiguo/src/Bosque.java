package Principiante;

public class Bosque
{
    public static void main(String[] args)
    {
        int altura = 10;
        int estrellas = 1;
        int espacios = altura;


        for(int i = 0; i < altura; i++)
        {
            for(int j = 0; j < espacios; j++)
            {
                System.out.print(" ");
            }
            for(int k = 0; k < estrellas; k++)
            {
                System.out.print("*");
            }
            estrellas +=2;
            espacios --;
            System.out.println();
        }
    }
}
