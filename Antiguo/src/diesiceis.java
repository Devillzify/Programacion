package Principiante;

import java.util.Random;
import java.util.random.RandomGenerator;

public class diesiceis
{
    public static void main(String[] args)
    {

        final int medida =10;
        int[] numeros = new int[medida];

        for(int i = 0; i < medida; i++)
        {
            int random = (int)Math.floor(Math.random()*100);
            numeros[i] = random;
        }
        for(int i = 0; i < medida; i++)
        {
            System.out.println(numeros[i]);
        }
    }

}
