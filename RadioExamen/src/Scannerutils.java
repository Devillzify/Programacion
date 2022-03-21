import java.util.Scanner;

public class Scannerutils
{
    Scanner sc;

    public Scannerutils()
    {
        sc = new Scanner(System.in);
    }

    public double showMessageAndGetDouble(String message)
    {
        System.out.println(message);
        double numero = 0;
        try
        {
            numero = sc.nextDouble();
            sc.nextLine();
        }
        catch(Exception e)
        {
            System.out.println("Solo se permiten numeros decimales");
            System.exit(1);
        }
        return numero;
    }

    public String showMessageAndGetEmisora(String message)
    {
        System.out.println(message);
        String emisora = "";

        do
        {
            emisora = sc.nextLine();
        }
        while(emisora.length() == 0 || emisora.length() > 50);

        return emisora;
    }

    public int showMessageAndGetInt(String message)
    {
        System.out.println(message);
        int numero = 0;
        try
        {
            numero = sc.nextInt();
            sc.nextLine();
        }
        catch(NumberFormatException e)
        {
            System.out.println("Solo se permiten numeros Enteros");
        }
        return numero;
    }
}
