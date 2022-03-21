import java.util.Scanner;

public class Scannerutils
{
    Scanner sc;

    public Scannerutils()
    {
        sc = new Scanner(System.in);
    }

    public int showMessageAndGetInt(String message)
    {
        System.out.println(message);
        int numero = 0;
        try
        {
            numero = sc.nextInt();
            sc.nextLine();
            if(numero < 1 || numero > 3999)
            {
                System.out.println("El numero no es correcto Elija un valor entre 1 y 3999");
                System.exit(1);
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("El numero no es correcto Elija un valor entre 1 y 3999");
        }
        return numero;
    }

    public String showMessageAndGetRoman(String message)
    {
        char romanos[] = {'M','D','C','L','X','V','I'};
        System.out.println(message);
        String romans = "";

        romans = sc.nextLine();
        for (int i = 0; i < romans.length(); i++)
        {
            boolean correct = false;
            for (int j = 0; j < romanos.length; j++)   // si introduces un caracter fuera de este array se cancela el proceso
            {
                if (romans.charAt(i) == romanos[j])
                {
                    correct = true;
                }
            }
            if (!correct)
            {
                System.out.println("El numero Romano es incorrecto");
                System.exit(1);
            }
        }
        return romans;
    }
}
