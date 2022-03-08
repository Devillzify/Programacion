package Archivos;

import java.io.*;

public class ScannerLeer
{


    public static void main(String[] args)
    {
        try
        {
            FileReader fr = new FileReader("dates.txt");

            int i;
            // Holds true till there is nothing to read
            while ((i = fr.read()) != -1)

                System.out.print((char) i);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
