package ExamenRecuperacion;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Products
{
    String[] vinos = {"Blanco", "Rosado", "Tinto"};
    String[] litros = {"1L", "2L", "3L", "5L"};
    int[] precios = {3, 5, 7, 12};

    File productsFile = new File("products.txt");

    Product[] products = new Product[12];

    public Products()
    {
        if (!productsFile.exists())
        {
            createList();
            writeList();
        }
        else
            readList();
    }

    public void showList()
    {
        for (Product product : products)
            System.out.println(product);
    }

    private void createList()
    {
        int indice = 0;

        for (String vino : vinos)
            for (String litro : litros)
            {
                String code = String.format("%c%c", vino.charAt(0), litro.charAt(0));
                int price = precios[indice % precios.length];
                String name = String.format("Vino %s en formato de %s", vino, litro);

                products[indice++] = new Product(code, price, name);
            }
    }

    private void writeList()
    {
        try (PrintWriter writer = new PrintWriter(productsFile))
        {
            for (Product product : products)
                writer.format("%s|%d|%s\n", product.code, product.price, product.name);
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong writing products file");
        }
    }

    private void readList()
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
        }
    }

    public void modify()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("What product do you want to modify? ");
        String code = sc.nextLine();
        int result = codeExist(code);
        if (result != -1)
        {
            System.out.println(products[result].name);
            System.out.println("Price: " + products[result].price);
            int oldPrice = products[result].price;
            System.out.print("New price: ");
            try
            {
                products[result].price = sc.nextInt();
                writeList();
            }
            catch (NumberFormatException e)
            {
                products[result].price = oldPrice;
            }
        }
    }

    private int codeExist(String code)
    {
        for (int i = 0; i < products.length; i++)
            if (code.equals(products[i].code))
                return i;

        return -1;
    }

    public static void main(String[] args)
    {
        Products celler = new Products();
        celler.showList();
/*
        celler.modify();
        celler.showList();
*/
    }
}