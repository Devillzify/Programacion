package Principiante;

public class factorial
{
    public static void main(String[] args)
    {
        int numero = 10;
        int variable = numero;

        for(int i = numero - 1; i >= 1; --i )
        {
            variable = variable * i;
        }
        System.out.println(variable);
    }
}
