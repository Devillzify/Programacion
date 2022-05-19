
public class Profesor extends Persona
{
    public Profesor(String id, String name)
    {
        super(id, name);
    }

    public Profesor(String id, String name,Modulos ... mdls)
    {
        super(id, name,mdls);
    }
}
