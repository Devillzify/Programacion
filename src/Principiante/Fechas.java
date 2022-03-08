package Principiante;

public class Fechas {

    static String[] nomsDia = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};
    static String[] nomsMes = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Septembre", "Octubre", "Novembre", "Decembre"};

    public static void main(String[] args) {

        String fechaCandidata = args[0];
        int numerodias = 10;



        int dia = 0, mes = 0, any = 0;
        try
        {
            dia = Integer.parseInt(fechaCandidata.substring(0, 2));
            mes = Integer.parseInt(fechaCandidata.substring(3, 5));
            any = Integer.parseInt(fechaCandidata.substring(6));
        }
        catch (NumberFormatException nfe)
        {
            System.err.println("Format should be dd/mm/yyyy");
            System.exit(8);
        }
        char c = fechaCandidata.charAt(2);

        if ((c != fechaCandidata.charAt(5)) || (c != '/'))
        {
            System.err.println("Format should be dd/mm/yyyy");
            System.exit(8);
        }
        if (mes < 1 || mes > 12)
        {
            System.err.println("Format should be dd/mm/yyyy");
            System.exit(8);
        }
        int[] diasMes = {31, 28, 31, 30, 31, 31, 30, 31, 30, 31, 30, 31};
        if (bisiesto(any))
            diasMes[1] = 29;
        if (dia < 1 || dia > diasMes[mes - 1])
        {
            System.err.println("Format should be dd/mm/yyyy");
            System.exit(8);
        }

        for (int i = 0; i < numerodias; i++)
        {
            dia++;

            if (dia > diasMes[mes - 1])
            {
                dia = 1;
                mes++;

            }
            if(mes > 12)
            {
                mes = 1;
                any++;
            }
            System.out.println(nomsDia[diaSemana(dia, mes, any)] + "," + dia + " del mes " + nomsMes[mes - 1] + " del año " + any);

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

        return (d + 6) % 7; /*con esta correccion da lunes el primero para evitar que empiece por domingo*/
    }
}
