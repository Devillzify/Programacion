package Principiante;

public class Fechames
{
    public static void main(String[] args)
    {
        String data = "22/03/1995";
        String data2 = "25/05/2021";
        String[] nomsMes = {"Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre" };
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int any = Integer.parseInt(data.substring(6));
        int dia2 = Integer.parseInt(data2.substring(0,2));
        int mes2 = Integer.parseInt(data2.substring(3,5));
        int any2 = Integer.parseInt(data2.substring(6));
        int diasTotales = 0;
        int diasMesActualHastaFinDeMes = diasMes[mes - 1] - dia;
        int mesesRestantesPrimerAno = 0;

        diasTotales += diasMesActualHastaFinDeMes;


        for(int i = mes + 1; i < diasMes.length; i++){
            diasTotales += diasMes[i];
        }
        for(int i = any + 1; i < any2; i++)
        {
            for(int j = 0; j < diasMes.length; j++)
            {
                if (j == 1)
                {
                    if(bisiesto(i))
                    {
                        diasTotales += 1;
                    }
                }
                diasTotales += diasMes[j];
            }
        }
        diasTotales += dia2;
        for(int i = 0; i < mes2; i++){
            if (i == 1){
                if(bisiesto(any2)){
                    diasTotales += 1;
                }
            }
            diasTotales += diasMes[i];
        }
        int aniosTotales = diasTotales / 365;
        int sobra =  diasTotales % 365;
        int mesesTrans =  sobra / 3;
        int diasSobra = sobra % 3;

        System.out.println("dias: " + diasSobra + " - meses: " + mesesTrans + " - años: " + aniosTotales);
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
}