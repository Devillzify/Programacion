package Archivos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CrearDates
{

    PrintWriter pw;
    int quantes;
    Random r = new Random(666);

    int[] dies = {31,28,31,30,31,30,31,31,30,31,30,31};

    public CrearDates(int quantes)
    {

        this.quantes = quantes;

        try
        {
            pw = new PrintWriter("dates.txt");
            for(int i = 0; i < quantes; i++)
            pw.println(novaData());
            pw.close();
        } catch (FileNotFoundException error)
        {
            System.err.println(error.getMessage());
            System.exit(404);
        }
    }

    private String novaData()
    {


        int any = 1583 + r.nextInt(10000 - 1583);

        FechaLarga fl = new FechaLarga("");
        dies[1] += FechaLarga.bisiesto(any);
        int mes = 1 + r.nextInt(12);
        int dia = 1 + r.nextInt(dies[mes - 1]);

        return String.format("%02d/%02d/%d\n", dia,mes,any);
    }



    private int bisiesto(int any){
        if(any % 400 == 0)
            return 1;
        if(any % 100 == 0)
            return 0;
        if(any % 4 == 0)
            return 1;
        return 0;
    }
}