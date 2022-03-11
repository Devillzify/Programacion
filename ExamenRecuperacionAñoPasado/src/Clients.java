import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clients {
    private final File clientsFile = new File("clients.txt");

    List<Client> clients = new ArrayList<>();

    public Clients() {
        if (clientsFile.exists()) {
            readList();
            showList();
        }
    }
    public void showList() {
        for (Client client : clients)
            System.out.println(client);
    }


    private void readList() {
        try (Scanner reader = new Scanner(clientsFile)) {
            while (reader.hasNextLine()) {
                String[] pieces = reader.nextLine().split("\\|"); // cada parte al sser un simbolo que no significa nada le añadimos "|" pieces= a cada pieza barra vertical y separar.

                String id = pieces[0];
                String name = pieces[1];
                clients.add(new Client(id, name));

            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong reading clients file");
        }
    }

    public static void main(String[] args) {

        new Clients();
    }
}
