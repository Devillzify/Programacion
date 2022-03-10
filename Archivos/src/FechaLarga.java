package Archivos;

public class FechaLarga
{
    private final String[] nomsDia = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};
    private final String[] nomsMes = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre" };

    private int dia, mes, any;

    public FechaLarga(String fechaOrigen)
    {
        if (fechaOrigen.matches("\\d{2}/\\d{2}/\\d{4}"))
        {
            dia = Integer.parseInt(fechaOrigen.substring(0, 2));
            mes = Integer.parseInt(fechaOrigen.substring(3, 5));
            any = Integer.parseInt(fechaOrigen.substring(6));
        }
    }

    public FechaLarga(int dia, int mes, int any)
    {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    public boolean esValida()
    {
        try
        {
            dayTest();
        }
        catch (NumberFormatException uno)
        {
            System.err.println(uno.getMessage());
            return false;
        }
        catch (ArrayIndexOutOfBoundsException dos)
        {
            System.err.println("Month out of bounds");
            return false;
        }
        return true;
    }

    private void dayTest()
    {
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(bisiesto(any) == 1)
        {
            diasMes[1] = 29;
        }
        if (dia < 1 || dia > diasMes[mes - 1])
            throw new NumberFormatException("Day out of bounds");
    }

    public String toString()
    {
        String resultat = String.format("%s, %d ", nomsDia[diaSemana(dia, mes, any)], dia);
        if (mes == 4 || mes == 8 || mes == 10)
            resultat += "d'";
        else
            resultat += "de ";
        return resultat + String.format("%s de %d", nomsMes[mes - 1], any);
    }

    static public int bisiesto(int any)
    {
        if (any % 400 == 0)
            return 1;
        if (any % 100 == 0)
            return 0;
        if (any % 4 == 0)
            return 1;
        return 0;
    }

    private int diaSemana(int dia, int mes, int any)
    {
        int a = (14 - mes) / 12;
        int y = any - a;
        int m = mes + 12 * a - 2;
        int d = (dia + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

        return (d + 6) % 7;
    }

    public int numeroFecha()
    {
        return 10000 * any + 100 * mes + dia;
    }
}