package LecturaArchivo;

import ExamenRecuperacion.Product;

import java.io.File;
import java.util.Scanner;

public class ScannerReader
{

    static File productsFile = new File("Escritura.txt");
    static Product[] products = new Product[12];
    private static void readList()
    {
        try (Scanner reader = new Scanner(productsFile))
        {
            int indice = 0;

            while (reader.hasNextLine())
            {
                String[] pieces = reader.nextLine().split("\\|");

                String code = pieces[0];
                int price = Integer.parseInt(pieces[1]);
                String name = pieces[2];

                products[indice++] = new Product(code, price, name);
            }
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong reading products file");
            e.printStackTrace();
        }
    }
    public static void showList()
    {
        for (Product product : products)
            System.out.println(product);
    }

    public static void main(String[] args)
    {
        readList();
        showList();
    }
}
