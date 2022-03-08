package Consola;

public class Character
{
    private Raza raza;
    private String nombre;
    private Stats estadisticas;

    public Character(Raza raza, String nombre, Stats estadisticas)
    {
        this.raza = raza;
        this.nombre = nombre;
        this.estadisticas = estadisticas;
    }

    public Raza getRaza()
    {
        return raza;
    }

    public void setRaza(Raza raza)
    {
        this.raza = raza;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Stats getEstadisticas()
    {
        return estadisticas;
    }

    public void setEstadisticas(Stats estadisticas)
    {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString()
    {
        return "Character{" +
                "raza=" + raza +
                ", nombre='" + nombre + '\'' +
                ", estadisticas=" + estadisticas +
                '}';
    }
}
