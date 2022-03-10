package Principiante;

public class Diasvividos
{
    public static void main(String[] args)
    {
        String data = "29/08/1995";
        String data2 = "20/06/2000";
        String[] nomsMes = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre" };
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        try
        {
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int any = Integer.parseInt(data.substring(6));
            int dia2 = Integer.parseInt(data2.substring(0,2));
            int mes2 = Integer.parseInt(data2.substring(3,5));
            int any2 = Integer.parseInt(data2.substring(6));
            int menores = 0;
            char c = data.charAt(2);
            if ((c != data.charAt(5)) || (c != '/'))
            {
                System.err.println("Format dd/mm/yyyy");
                System.exit(8);
            }
            if (mes < 1 || mes > 12)
            {
                System.err.println("Format dd/mm/yyyy");
                System.exit(8);
            }
            if (bisiesto(any))
                diasMes[1] = 29;
            if (dia < 1 || dia > diasMes[mes - 1])
            {
                System.err.println("Format should be dd/mm/yyyy");
                System.exit(8);
            }





        }
        catch (NumberFormatException nfe)
        {
            System.err.println("Error de format");
        }
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

    static int diaSemana(int dia, int mes, int any)
    {
        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        return (d + 6) % 7;
    }
}
