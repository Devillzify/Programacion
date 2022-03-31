import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Conjuntos
{
    Set<Integer> c1 = new HashSet<>();

    public Conjuntos(int size)
    {
        Random rnd = new Random(666);

        for(int i = 0; i < size; i++)
        {
            c1.add(1 + rnd.nextInt(100));
        }
    }
    void mostrar()
    {
      for(int elementos : c1)
      {
          System.out.println(elementos);
      }
      System.out.println("=================================");
      c1.forEach(x -> System.out.println(x));
    }

    public static void main(String[] args)
    {
        Conjuntos c = new Conjuntos(10);
        c.mostrar();
    }
}
