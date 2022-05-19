public class Alumno extends Persona
{
    public Alumno(String id, String name)
    {
        super(id, name);
    }

    public Alumno(String id, String name,Modulos ... mdls)
    {
        super(id, name,mdls);
    }
}
