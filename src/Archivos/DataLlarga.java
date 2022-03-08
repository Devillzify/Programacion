package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DataLlarga
{
    File entrada = new File("dates.txt");
    File sortida = new File("dates_llarges.txt");
    Scanner llegir;
    PrintWriter escriure;



    List<String> lista = new ArrayList<>();

    public DataLlarga()
    {
        try
        {
             llegir = new Scanner(entrada);
             escriure = new PrintWriter(sortida);
            procesar();
            escriure.close();
            llegir.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("error de algo");
        }
        mostrarLista();

    }
    private void procesar()
    {
        while (llegir.hasNextLine())
        {
            String linea = llegir.nextLine();

            if (linea.length() != 0)
            {
                //lista.add(linea);
                FechaLarga fl = new FechaLarga(linea);
                String lineaLarga = fl.toString();
                lista.add(lineaLarga);
                escriure.println(lineaLarga);

            }

        }
    }
        private void mostrarLista()
        {
            Collections.sort(lista);
            for (String fecha: lista)
                System.out.println(fecha);
        }
    }

