public class Hora
{
    protected int hora;
    protected int minuto;

    public Hora(int hora,int minuto)
    {
      setHora(hora);
      setMinuto(minuto);
    }



    public void inc()
    {
        minuto += 1;
        if(minuto > 59)
        {
            minuto = 0;
            hora += 1;
        }

        if(hora > 23)
        {
            hora = 0;
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

    @Override
    public String toString()
    {
        return "Hora{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                '}';
    }
}
