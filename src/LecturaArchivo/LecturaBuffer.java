package LecturaArchivo;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaBuffer
{
    public static void main(String[] args)
    {
        String cadena;
        FileReader f = null;

        try{
            f = new FileReader("Escritura.txt");

            BufferedReader bf = new BufferedReader(f);

            while ((cadena = bf.readLine()) != null)
            {
                System.out.println(cadena);
            }
            bf.close();

        }
        catch (FileNotFoundException ex)
        {

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
