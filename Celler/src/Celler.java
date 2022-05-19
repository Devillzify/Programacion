import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Celler
{
    List<String> apellidosLista, hombresLista, mujeresLista;
    PrintWriter xml;
    Random rnd = new Random(666);

    int clients, factures;

    public Celler(int clients, int factures)
    {
        this.clients = clients;
        this.factures = factures;
        try
        {
            apellidosLista = crearLista("apellidos.txt");
            hombresLista = crearLista("hombres.txt");
            mujeresLista = crearLista("mujeres.txt");
            xml = new PrintWriter("celler.xml");
            crearCeller();
            xml.close();
        }
        catch (FileNotFoundException exception)
        {
            System.err.println("Something went wrong");
        }
    }

    private List<String> crearLista(String nombreArchivo) throws FileNotFoundException
    {
        List<String> laLista = new ArrayList<>();
        Scanner s = new Scanner(new File(nombreArchivo));
        while (s.hasNextLine()) laLista.add(s.nextLine());

        return laLista;
    }

    private void crearCeller()
    {
        xml.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        xml.println("<?xml-stylesheet type=\"text/xsl\" href=\"celler.xsl\"?>");
        xml.println("<celler xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"celler.xsd\">");
//        xml.println("<celler>");
        crearProductes();
        crearClients();
        crearFactures();
        xml.println("</celler>");
    }

    String vinos = "BRT";
    String[] nombresVinos = {"Blanco", "Rosado", "Tinto"};
    String litros = "1235";
    double[] precios = {1.5, 2.5, 3.5, 5.5};

    private void crearProductes()
    {
        xml.println("<productes>");
        for (int i = 0; i < vinos.length(); i++)
        {
            for (int j = 0; j < litros.length(); j++)
            {
                xml.format("<producte codi=\"%c%c\" preu=\"%.2f\">", vinos.charAt(i), litros.charAt(j), precios[j]);
                xml.format("Vino %s de %c litro(s)</producte>\n", nombresVinos[i], litros.charAt(j));
            }
        }
        xml.println("</productes>");
    }

    private void crearClients()
    {
        xml.println("<clients>");
        for (int i = 0; i < clients; i++)
        {
            xml.format("<client codi=\"C%05d\">\n", 1 + i);
            if (rnd.nextInt(2) == 0)
                xml.println("<nom>" + mujeresLista.get(rnd.nextInt(mujeresLista.size())) + "</nom>");
            else
                xml.println("<nom>" + hombresLista.get(rnd.nextInt(hombresLista.size())) + "</nom>");
            xml.print("<cognoms>" + apellidosLista.get(rnd.nextInt(apellidosLista.size())));
            if (rnd.nextInt(5) != 2)
                xml.print(" " + apellidosLista.get(rnd.nextInt(apellidosLista.size())));
            xml.println("</cognoms>");
            xml.println("<contacte>");
            telefono();
            xml.println("</contacte>");
            xml.println("</client>");
        }
        xml.println("</clients>");
    }

    private void telefono()
    {
        int t = 1 + rnd.nextInt(3);

        for (int i = 0; i < t; i++)
        {
            int s = rnd.nextInt(2);
            xml.format("<telefon tipus=\"%s\">", (s == 0) ? "mobil" : "fix");
            xml.format("%d%02d %03d %03d", 2 * s + 6 + rnd.nextInt(2), rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
            xml.println("</telefon>");
        }
    }

    private void crearFactures()
    {
        xml.println("<factures>");
        for (int i = 0; i < factures; i++) 
        {
            xml.format("<factura numero=\"F%06d\">\n", 1 + i);
            xml.format("<comprador codi=\"C%05d\"/>\n", 1 + rnd.nextInt(clients));
            int pedido = 1 + rnd.nextInt(4095);
            int mask = 1;
            for (int j = 0; j < 12; j++)
            {
                if ((pedido & mask) != 0)
                {
                    xml.format("<unitats codi=\"%c%c\">%d</unitats>\n", vinos.charAt(j >> 2), litros.charAt(j % 4), 1 + rnd.nextInt(5));
                }
                mask <<= 1;
            }
            xml.println("</factura>");
        }
        xml.println("</factures>");
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Celler(10, 100);
    }
}
