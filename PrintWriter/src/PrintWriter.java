package EscrituraPrintwriter;

import java.io.File;
import java.io.FileNotFoundException;

public class PrintWriter
{
    public static void main(String[] args)
    {
        File archivo = new File("Escritura.txt");

        String nombre = "Ana";
        int edad = 34;
        try (java.io.PrintWriter pw = new java.io.PrintWriter(archivo))
        {
            for(int i = 0; i < 20; i++)  // cosas a escribir
            {
                pw.println("buenas a todos"); // cosas a escribir
            }
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}
