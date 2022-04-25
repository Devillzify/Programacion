import java.io.PrintWriter;

public class coloresmil
{
    int r;
    int g;
    int b;
    int ancho = 4096;
    int alto = 4096;
    public coloresmil()
    {

    }

    public void crearcolor()
    {
        for (int r = 0; r <= 255; r++)
        {
            for(int g = 0; g <= 255; g++)
            {
                for(int b = 0; b <= 255; b++)
                {
                    System.out.println(r + " " + g + " " + b + " ");
                }
            }
        }
    }

    public void crearPPM()
    {
        try
        {
            PrintWriter pw = new PrintWriter("imatge.ppm");
            String cabezera = "P3\n" + ancho + " " + alto + "\n255\n";
            pw.print(cabezera);
            pw.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
