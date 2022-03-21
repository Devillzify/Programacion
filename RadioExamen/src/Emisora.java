public class Emisora
{
    private double frequencia;
    private String emisora;  // aqui solo creamos el objeto con sus estadisiticas para usarlo mas adelante, generando los getters y setters

    public Emisora(double frequencia, String emisora)
    {
        this.frequencia = frequencia;
        this.emisora = emisora;
    }

    public double getFrequencia()
    {
        return frequencia;
    }

    public void setFrequencia(double frequencia)
    {
        this.frequencia = frequencia;
    }

    public String getEmisora()
    {
        return emisora;
    }

    public void setEmisora(String emisora)
    {
        this.emisora = emisora;
    }
}
