

public class Raza
{
    private String nombre;
    private Stats initialStats;

    public Raza(String nombre, Stats initialStats)
    {
        this.nombre = nombre;
        this.initialStats = initialStats;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Stats getInitialStats()
    {
        return initialStats;
    }

    public void setInitialStats(Stats initialStats)
    {
        this.initialStats = initialStats;
    }

    @Override
    public String toString()
    {
        return "Raza{" +
                "nombre='" + nombre + '\'' +
                ", initialStats=" + initialStats +
                '}';
    }
}
