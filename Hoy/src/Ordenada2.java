import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ordenada2
{
    int elements;

    List<String> dones, homes, llinatges;
    Random r = new Random(666);

    public Ordenada2(int elements)
    {
        this.elements = elements;

        dones = llegir("dones.txt");
        homes = llegir("homes.txt");
        llinatges = llegir("llinatges.txt");
    }

    List<String> llegir(String arxiu)
    {
        List<String> llista = new ArrayList<>();

        try (Scanner s = new Scanner(new File(arxiu)))
        {
            while (s.hasNextLine()) llista.add(s.nextLine());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        return llista;
    }

    private String persona()
    {
        StringBuilder nomComplet = new StringBuilder();

        nomComplet.append(llinatges.get(r.nextInt(llinatges.size())));
        if (r.nextInt(10) != 2) nomComplet.append(" ").append(llinatges.get(r.nextInt(llinatges.size())));
        nomComplet.append(", ");
        if (r.nextBoolean())
        {
            nomComplet.append(dones.get(r.nextInt(dones.size())));
            if (r.nextInt(5) != 2) nomComplet.append(" ").append(dones.get(r.nextInt(dones.size())));
        }
        else
        {
            nomComplet.append(homes.get(r.nextInt(homes.size())));
            if (r.nextInt(5) != 2) nomComplet.append(" ").append(homes.get(r.nextInt(homes.size())));
        }

        return nomComplet.toString();
    }


    public void crear()
    {
        List<String> llista = new ArrayList<>();

        for (int i = 0; i < elements; i++)
        {
            String novaPersona = persona();

            int j;
            for (j = 0; j < llista.size(); j++)
                if (llista.get(j).compareTo(novaPersona) > 0) break;

            llista.add(j, novaPersona);
        }

        for (String persona : llista)
            System.out.println(persona);
    }

    public static void main(String[] args)
    {
        Ordenada2 o = new Ordenada2(200);
        o.crear();
    }
}