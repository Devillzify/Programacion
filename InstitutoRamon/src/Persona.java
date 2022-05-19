import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persona
{
    String id,name;
    List<Modulos> modulos = new ArrayList();


    public Persona(String id,String name)
    {
        this.id = id;
        this.name = name;
    }

    public Persona(String id, String name,Modulos ... mdls)
    {
        this(id,name);
        modulos.addAll(Arrays.asList(mdls));
    }

    public void addModulo(Modulos mdl)
    {
        modulos.add(mdl);
    }
}
