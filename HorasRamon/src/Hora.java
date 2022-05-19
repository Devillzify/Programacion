public class Hora
{
    protected int hora = 0;
    protected int minutos = 0;

    public Hora(int hora, int minutos)
    {
        setHora(hora);
        setMinuto(minutos);
    }

    protected void setHora(int valor)
    {
        if (valor >= 0 && valor < 24)
            this.hora = valor;
    }

    private void setMinuto(int valor)
    {
        if (valor >= 0 && valor < 60)
            this.minutos = valor;
    }

    public void inc()
    {
        if (++minutos == 60)
        {
            minutos = 0;
            if (++hora == 24) hora = 0;
        }
    }

    public String toString()
    {
        return String.format("%02d:%02d", this.hora, this.minutos);
    }
}