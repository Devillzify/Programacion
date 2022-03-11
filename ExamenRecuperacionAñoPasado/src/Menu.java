import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    String header;
    String[] options;
    int longest = 0;

    public Menu(String header, String ... options)
    {
        this.header = header;
        this.options = new String[options.length];
        for (int i = 0; i < options.length; i++)
        {
            this.options[i] = options[i];
            if (options[i].length() > longest)
                longest = options[i].length();
        }
    }

    public void show()
    {
        longest += 4;
        System.out.println("=".repeat(longest));
        System.out.println(header);
        System.out.println("=".repeat(longest));
        for (int i = 0; i < options.length; i++)
            System.out.format("%d - %s\n", i + 1, options[i]);
        System.out.println("=".repeat(longest));
        System.out.println("0 - Salir");
        System.out.println("=".repeat(longest));
    }

    public int get()
    {
        Scanner s = new Scanner(System.in);
        int n;

        try
        {
            System.out.print("--> ");
            n = s.nextInt();
        }
        catch (InputMismatchException e)
        {
            return -1;
        }
        return n;
    }

    public static void main(String[] args)
    {
        /*
        Menu m1 = new Menu("Principal", "Altas", "Bajas", "Consultas", "Modificaciones");
        m1.show();
        System.out.println(m1.get());
        */
        Menu m2 = new Menu("Cliente", "Altas", "Bajas", "Consultas", "Modificaciones", "Listados", "Esternocleidomastoideo");
        m2.show();
        System.out.println(m2.get());
    }
}
