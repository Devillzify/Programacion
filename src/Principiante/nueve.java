package Principiante;

public class nueve
{
    static String[] nomsDia = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};
    static String[] nomsMes = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Septembre", "Octrubre", "Novembre", "Desembre"};

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
        dia++;
        if (dia > diasMes[mes - 1])
        {
            mes++;
            dia= 1;
            if ( mes > 12)
            {
                any++;
                mes = 1;
            }
        }

        System.out.println(dia + "/" + mes + "/" + any);
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