import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MockClients {
    ArrayList<String> la;
    ArrayList<String> lm;
    ArrayList<String> lh;

    PrintWriter writer;

    Random rnd = new Random(1701);

    public MockClients(int numero) {
        la = loadFile("apellidos.txt");
        lm = loadFile("mujeres.txt");
        lh = loadFile("hombres.txt");

        try {
            writer = new PrintWriter("clients.txt");
            for (int i = 0; i < numero; i++) {
                Client clt = client();
                writer.format("%s|%s\n", clt.id, clt.name);
            }
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        invoice(1);
    }

    private ArrayList<String> loadFile(String filename) {
        ArrayList<String> list = new ArrayList<>();

        try (Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine())
                list.add(reader.nextLine());
        }
        catch (Exception e) {
            System.out.println("Something went wrong reading " + filename);
        }

        return list;
    }

    private Client client() {
        int number = rnd.nextInt(100000000);
        char letter = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(number % 23);

        String id = String.format("%08d%c", number, letter);

        String name = "";

        if (rnd.nextInt(2) == 0) {
            name += lm.get(rnd.nextInt(lm.size()));
            if (rnd.nextInt(5) == 2) {
                name += " " + lm.get(rnd.nextInt(lm.size()));
            }
        } else {
            name += lh.get(rnd.nextInt(lh.size()));
            if (rnd.nextInt(5) == 2) {
                name += " " + lh.get(rnd.nextInt(lh.size()));
            }
        }
        name += " " + la.get(rnd.nextInt(la.size()));
        if (rnd.nextInt(10) != 4) {
            name += " " + la.get(rnd.nextInt(la.size()));
        }

        System.out.println(id + "|" + name);

        return new Client(id, name);
    }

    private void invoice(int number) {
        Clients cl = new Clients();
        cl.showList();

        int whatClient = rnd.nextInt(cl.clients.size());
        Client client = cl.clients.get(whatClient);

        Invoice inv = new Invoice(number, client.id);// le pasamos el numero de parametro que sera el numero factura

        int election = 1 + rnd.nextInt(4095);// hacemos que en binario sean 12 digitos

        Products prd = new Products();

        for (int i = 0; i < prd.products.length; i++) {
            if (election % 2 == 1) { //
                String code = prd.products[i].code; //accedemos a la posicion indicada por la i y de ese producto lo guardamos
                int price = prd.products[i].price;
                String name = prd.products[i].name;
                int quantity = prd.products[i].quantity;

                inv.purchase.add(new Product(code, price, name, quantity));
                prd.products[i].quantity -= quantity;
            }
            election /= 2; //dividir  a nivel binario desplaza hacia la izquierda
        }
    }

    public static void main(String[] args) {

        new MockClients(10);
    }
}
