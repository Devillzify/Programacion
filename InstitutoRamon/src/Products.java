import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Products
{
    private final String[] wines = {"Blanc", "Negre", "Rosat"};
    private final String[] sizes = {"1 litre", "2 litres", "3 litres", "5 litres"};
    private final double[] price = {2.5, 4.5, 6.5, 11.0};

    private ArrayList<Product> products = new ArrayList<>();

    private final File file = new File("products.dat");

    public Products()
    {
        if (!file.exists())
        {
            createList();
            writeList();
        }
        else
            readList();
        showList();
    }

    private void createList()
    {
        int counter = 0;

        for (String wine: wines)
            for (String size: sizes)
            {
                String code = String.format("%c%c", wine.charAt(0), size.charAt(0));
                String container = (counter < 2) ? "botella" : "garrafa";
                String description = String.format("Vi %s en %s de %s", wine, container, size);
                products.add(new Product(code, description, price[counter]));
                counter = (counter + 1) % price.length;
            }
    }

    public void showList()
    {
        for (Product p : products)
            System.out.println(p.toString());
    }

    private void writeList()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(products);
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong writing file");
        }
    }

    private void readList()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            products = (ArrayList<Product>) ois.readObject();
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong reading file");
        }
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Products();
    }
}