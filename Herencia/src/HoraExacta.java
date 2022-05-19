public class HoraExacta extends Hora
{
    int segundos;

    public HoraExacta(int hora, int minuto,int segundos)
    {

        super(hora, minuto);
        this.segundos = segundos;
    }

    public void setSegundos(int segundos)
    {
        this.segundos = segundos;
        if(segundos > 59 || segundos < 0)
        {
            System.out.println("los segundos deben estar entre 0 y 59");
            System.err.println(2);
        }
    }

    @Override
    public String toString()
    {
        return "HoraExacta{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                ", segundos=" + segundos +
                '}';
    }

    public void inc()
    {
        segundos += 1;
        if(segundos > 59)
        {
            segundos = 0;
            minuto += 1;
            if(minuto > 59)
            {
                minuto = 0;
                hora += 1;
            }
        }

    }

    public void comparar( String fecha2)
    {

        int h = hora;;
        int m = minuto;
        int s = segundos;

        int h1;
        int m2;
        int s3;

        System.out.println(h);
        System.out.println(m);
        System.out.println(s);
        h1 = Integer.parseInt(fecha2.substring(0,2));
        m2 = Integer.parseInt(fecha2.substring(3,5));
        s3 = Integer.parseInt(fecha2.substring(6,8));

        if(h == h1)
        {
            System.out.println("la hora es igual");
        }
        else
        {
            System.out.println("las horas son diferentes");
        }
        if(m == m2)
        {
            System.out.println("los minutos son iguales");
        }
        else
        {
            System.out.println("los minutos son diferentes");
        }
        if(s == s3)
        {
            System.out.println("los segundos son iguales");
        }
        else
        {
            System.out.println("los segundos son diferentes");
        }

        if(h == h1 && m == m2 && s == s3)
        {
            System.out.println("Enhorabuena, las dos horas son iguales");
        }
    }



}
