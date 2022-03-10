package Principiante;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Calendarioclase
{
    static String[] Dia = {"L", "MA", "MI", "J", "V", "S", "D"};
    static String[] Mes = {
            "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
    };
    static PrintWriter h, c;
    static int[] DiasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args)
    {

        if (args.length != 1)
        {
            System.err.println("Shit happens");
            System.exit(8);
        }

        String fechaCandiadata = args[0];
        if (fechaCandiadata.length() != 10)
        {
            System.err.println("Shit happens");
            System.exit(8);
        }

        int dia = 0, mes = 0, any = 0;

        try
        {

            dia = Integer.parseInt(fechaCandiadata.substring(0, 2));
            mes = Integer.parseInt(fechaCandiadata.substring(3, 5));
            any = Integer.parseInt(fechaCandiadata.substring(6, 10));
        } catch (NumberFormatException nfe)
        {
            System.err.println("Shit should be dd/mm/yyyy");
            System.exit(8);
        }

        char c = fechaCandiadata.charAt(2);
        if ((c != fechaCandiadata.charAt(5)) || ("./-&".indexOf(c) == -1))
        {
            System.err.println("Shit should be dd/mm/yyyy");
            System.exit(8);
        }

        if (mes < 1 || mes > 12)
        {
            System.err.println("Shit should be dd/mm/yyyy");
            System.exit(8);
        }

        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (bisiesto(any))
            diasMes[1] = 29;

        if (dia < 1 || dia > diasMes[mes - 1])
        {
            System.err.print("Shit should be dd/mm/yyyy");
            System.exit(8);
        }
        html(any);
        css();
    }


    static boolean bisiesto(int any)
    {
        if (any % 400 == 0)
            return true;
        if (any % 100 == 0)
            return false;
        if (any % 4 == 0)
            return true;
        return false;
    }

    static void html(int any)
    {
        try
        {
            h = new PrintWriter("calendarioClase.html");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        h.println("<!DOCTYPE html>");
        h.println("<html>");
        head();
        body(any);
        h.println("</html>");
        h.close();
    }

    static void head()
    {
        h.println("<head>");
        h.println("<meta charset=\"utf-8\"/>");
        h.println("<title>HORARIO</title>");
        h.println("<link href=\"CalendarioClase.css\" rel=\"stylesheet\"/>");
    }

    static void body(int any)
    {
        h.println("<body>");
        div(any);
        h.println("</body>");
    }

    static void div(int any)
    {

        h.println("<div>");
        for (int i = 0; i < Mes.length; i++)
        {
            h.println("<div>");
            h.println("<div>" + Mes[i] + "</div>");

            for (int k = 0; k < Dia.length; k++)
            {
                h.println("<div>" + Dia[k] + "</div>");
            }
            int libres = diaSemana(1, i + 1, any);
            for (int j = 0; j < libres; j++)
            {
                h.println("<div></div>");
            }
            for (int j = 0; j < DiasMes[i]; j++)
            {
                h.println("<div>" + (j + 1) + "</div>");
            }
            h.println("</div>");
        }
        h.println("</div>");
    }

    static int diaSemana(int dia, int mes, int any)
    {
        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        return (d + 6) % 7;
    }

    static void css()
    {

        try
        {
            c = new PrintWriter("CalendarioClase.css");
            c.println("body div { width: 600px; margin: auto;}");
            c.println("body{background-image: url(\"2.jpg\"); background-repeat: repeat;}");
            c.println("body div div { width: 670px; height: 520px; float: left; margin-left: 5px;margin-bottom: 7px; background-color: black; justify-content:center; align-items:center;}");//tabla
            c.println("body div div div:first-of-type { background-color:purple ; color: white; width: 660px; height: 30px; font-weight: bold; text-align: center;justify-content:center; align-items:center;}");//mes
            c.println("body div div div { width: 90px; height:60px; float: left; text-align: center; color: #9b00af; justify-content:center; align-items:center;display:flex; background-color: #ffc3c3; font-size:30px}");//dias numeros

            c.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

