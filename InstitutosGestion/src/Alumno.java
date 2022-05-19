public class Alumno extends Persona
{
    public Alumno(String id, String name) // Creamos una ficha para alumno sin modulos
    {
        super(id, name);
    }

    public Alumno(String id, String name, Modulo ... mdls) // Creamos ficha para alumno con modulos
    {
        super(id, name, mdls);
    }
}