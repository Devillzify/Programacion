public class Hora12
{
    private String momento;
    private int hora;
    private int minuto;
    @Override
    public String toString()
    {
        return "Hora12{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                ", momento='" + momento + '\'' +
                '}';
    }

    public Hora12(int hora, int minuto)
    {
    setHora(hora);
    setMinuto(minuto);
       if(hora >= 13)
       {
           this.hora = hora - 12;
           if(hora >= 13)
           {
               momento = "PM";
           }
       }

       if(hora < 13)
       {
           momento = "AM";
       }

    }
    public void setHora(int hora)
    {
        this.hora = hora;
        if(hora > 24 || hora < 0)
        {
            System.out.println("la hora debe estar entre 0 y 23");
            System.err.println(2);
        }

    }

    public void setMinuto(int minuto)
    {
        this.minuto = minuto;

        if(minuto < 0 || minuto > 59)
        {
            System.out.println("el minuto debe estar entre 0 y 59");
        }
    }



}
