package ExamenRecuperacion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clients
{

    File clientsFile = new File("Clients.txt");

    List<Client> Clients = new ArrayList<>();

    public Clients()
    {
        if(clientsFile.exists())
            readList();
    }

    private void readList()
    {
        try (Scanner reader = new Scanner(clientsFile))
        {
            while (reader.hasNextLine())
            {
                String[] pieces = reader.nextLine().split("\\|");

                String id = pieces[0];
                String name = pieces[1];

                Clients.add(new Client(id,name));
            }
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong reading clients file");
        }
    }

}
