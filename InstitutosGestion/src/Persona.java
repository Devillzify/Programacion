
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persona
{
    String id; //Para dar nombres de la persona
    String name;
    List<Modulo> modulos = new ArrayList<>();
    public Persona(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Persona(String id, String name, Modulo ... mdls) //La cantidad de elementos que se le pasan es desconocida.
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

    public void addModulo(Modulo mdl) // Esto añade 1 modulo en el caso de que queramos mas.
    {
        modulos.add(mdl);
    }
}