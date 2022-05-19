public class Hora12 extends Hora
{
    protected Meridiano mrdn;

    public Hora12(int hora, int minutos, Meridiano mrdn)
    {
        super(hora, minutos);
        setHora(hora);
        this.mrdn = mrdn;
    }

    @Override
    protected void setHora(int valor)
    {
        if (valor >= 1 && valor <= 12)
            super.setHora(valor);
        else
            hora = 12;
    }

    @Override
    public void inc()
    {
        if (++minutos == 60)
        {
            minutos = 0;
            if (++hora == 12)
                mrdn = (mrdn == Meridiano.AM) ? Meridiano.PM : Meridiano.AM;
            else
                hora %= 12;
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + mrdn.spanish;
    }
}