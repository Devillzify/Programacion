
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Agenda
{
    File fa = new File("apellido");
    File fm = new File("mujer");
    File fh = new File("hombre");

    Scanner sa;
    Scanner sm;
    Scanner sh;

    List<String> la = new ArrayList<>();
    List<String> lm = new ArrayList<>();
    List<String> lh = new ArrayList<>();

    PrintWriter ag;

    public Agenda()
    {
        try
        {
            sa = new Scanner(fa);
            sm = new Scanner(fm);
            sh = new Scanner(fh);
            procesar();

            sh.close();
            sm.close();
            sa.close();

            ag = new PrintWriter("agenda.txt");
            agenda(10);
            ag.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Something went wrong!");
        }
    }

    private void procesar()
    {
        while (sa.hasNextLine())
        {
            la.add(sa.nextLine());
        }
        while (sm.hasNextLine())
        {
            lm.add(sm.nextLine());
        }
        while (sh.hasNextLine())
        {
            lh.add(sh.nextLine());
        }
    }

    private void agenda(int n)
    {
        Random r = new Random(21);

        for (int i = 0; i < n; i++)
        {
            String persona = "";

            if (r.nextInt(2) == 0)
            {
                persona += lm.get(r.nextInt(lm.size()));
                if (r.nextInt(5) == 2)
                    persona += " " + lm.get(r.nextInt(lm.size()));
            } else
            {
                persona += lh.get(r.nextInt(lh.size()));
                if (r.nextInt(5) == 2)
                    persona += " " + lh.get(r.nextInt(lh.size()));
            }
            persona += " " + la.get(r.nextInt(la.size()));
            if (r.nextInt(10) != 4)
                persona += " " + la.get(r.nextInt(la.size()));
            ag.println(persona);
        }
    }
}