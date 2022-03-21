public class RadioFrequencia
{
    private final double minFreq = 88.1;
    private final double maxFreq = 108.1;
    private final int maxEmisoras = 50;
    private double freqActual;
    private Emisora[] emisoras;
    private int emisorasGuardadas = 0;
    private Emisora emisoraActual;


    public RadioFrequencia(double frequencia)
    {
        this.emisoras = new Emisora[maxEmisoras];
        setFrequencia(frequencia);
    }

    public boolean validarFrequencia(double frequencia)
    {
        if(frequencia >= minFreq && frequencia <= maxFreq)    // control errores para asegurar que metes una frequencia dentro del rango aceptado 88.1 y 108.1
        {
            return true;
        }
        System.out.println("La frequencia debe estar entre" + minFreq + "Mhz y " + maxFreq + "Mhz");
        return false;
    }

    public double getFreqActual()
    {
        return freqActual;
    }

    public void setFrequencia(double nuevafrequencia)
    {
        if(validarFrequencia(nuevafrequencia))
        {
            this.freqActual = nuevafrequencia;   // en el metodo estableces frequencia se pasa un double con la frequencia y se modifca, en caso de poner un numero incorrecto se pone un valor por defecto, que esta puesto en 88.1 minFreq
            System.out.println("Se ha establecido la frequencia en: " + nuevafrequencia + "Mhz");
        }
        else
        {
            this.freqActual = minFreq;
            System.out.println("Se ha establecido la frequencia minima por defecto " + minFreq + "Mhz");
        }
        buscarEnEmisoras();
    }

    private void buscarEnEmisoras()
    {
        for(int i = 0; i < this.emisoras.length; i++)
        {
            if(this.emisoras[i] == null)
            {
                this.emisoraActual = null;
                break;
            }

            if(this.emisoras[i].getFrequencia() == this.freqActual)
            {
                this.emisoraActual = this.emisoras[i];
                break;
            }
        }
    }

    public String getNombreEmisoraActual()
    {
        if(this.emisoraActual == null)
        {
            return "Emisora sin guardar"; // para buscar el nombre de la emisora, revisamos si  esta vacio o no, en caso de estar vacio suelta el mensaje, en caso de estar lleno
        }
        return this.emisoraActual.getEmisora(); // enseña la emisora actual guardada
    }

    public void guardarEmisora(String nombre)
    {
        if(emisorasGuardadas >= maxEmisoras)  // establecemos el nombre de la emisora a guardar y hacemos el control de errores por si hemos introducido mas emisoras de las permitidas
        {
            System.out.println("No hay capacidad para mas emisoras");
            return;
        }
        Emisora nuevaEmisora = new Emisora(freqActual,nombre);
        this.emisoras[emisorasGuardadas] = nuevaEmisora;

        this.emisorasGuardadas++;
        buscarEnEmisoras();
        System.out.println("Se ha guardado la emisora: " + nombre + " en la frequencia de " + freqActual);
    }

    public void showEmisoras()
    {
        for(int i = 0; i < this.emisoras.length; i++)   // recorre el array con las emisoras guardadas y sus frequencias
        {
            if(this.emisoras[i] == null) break;
            System.out.println("Emisora: " + this.emisoras[i].getEmisora() + " - Frequencia: " + this.emisoras[i].getFrequencia());
        }
    }
}
