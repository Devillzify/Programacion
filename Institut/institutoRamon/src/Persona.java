import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persona implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    String id; //Para dar nombres de la persona
    String name;
    List<String> modulos = new ArrayList<>();
    public Persona(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Persona(String id, String name, String ... mdls) //La cantidad de elementos que se le pasan es desconocida.
    {
        this(id, name);

        //Esta rutina la puedes llamar con tantos modulos como tengas.

/*        for (int m = 0; m < mdls.length; m++)  //Mete en la lista todos los que quieras.
        {
           modulos.add(mdls[m]);
        }
 */
        modulos.addAll(Arrays.asList(mdls)); //Los mete en  la lista.
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getModulos()
    {
        return modulos;
    }

    public void setModulos(List<String> modulos)
    {
        this.modulos = modulos;
    }

    public void addModulo(String mdl) // Esto añade 1 modulo en el caso de que queramos mas.
    {
        modulos.add(mdl);
    }
}