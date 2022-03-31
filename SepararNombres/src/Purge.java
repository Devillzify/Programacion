import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.*;

public class Purge
{
    File inFile, outFile;
    Set<String> outSet;

    public Purge(String inFilename, String outFilename)
    {
        this.inFile = new File(inFilename);
        this.outFile = new File(outFilename);

        this.outSet = new TreeSet<>(Collator.getInstance(Locale.forLanguageTag("es")));

        read();
        write();
    }

    private void read()
    {
        try (Scanner s = new Scanner(inFile))
        {
            int counter = 0;

            while (s.hasNextLine())
            {
                String line = s.nextLine();
                String[] chunks = line.split("\\|");
                String[] pieces = chunks[1].split(" ");

                for (String piece : pieces)
                    if (outSet.add(piece))
                        counter++;
            }

            System.out.println(counter);
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void write()
    {
        try (PrintWriter pw = new PrintWriter(outFile))
        {
            outSet.forEach(pw::println);
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        new Purge("hombres.csv", "hombres.txt");
        new Purge("mujeres.csv", "mujeres.txt");
//        new Purge("apellidos1.csv", "apellidos1.txt");
//        new Purge("apellidos2.csv", "apellidos2.txt");
        new Purge("apellidos.csv", "apellidos.txt");
    }
}
