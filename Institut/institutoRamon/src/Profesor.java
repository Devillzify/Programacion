public class Profesor extends Persona
{
    public Profesor (String id, String name)
    {
        super(id, name);
    }

    public Profesor(String id, String name, String ... mdls) //La cantidad de elementos que se le pasan es desconocida.
    {
        super(id, name, mdls);
    }

    @Override
    public String toString()
    {
        return "Profesor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", modulos=" + modulos +
                '}';
    }
}