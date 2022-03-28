import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

// con la ayuda de nuestro compañero Devi
// Tengo problemas para entender la lectura de archivos correctamente
// aun asi me lo ha explicado bien y lo entiendo

/*
Este ejercicio es una mezcla de los archivos que creamos hace un tiempo donde generaban una cola y luego
los procesamos de 1 en 1, creamos la cola, cuando esta vacia las 2 son null, cuando uno entra
pasa a ser el primer y tambien el ultimo de la cola, dado que solo hay 1, al entrar el siguiente
el anterior pasa a ser primero y entra el ultimo y asi se va procesando hasta vaciar la cola.
Incluye un Scannerutils custom como el otro ejercicio con su control de errores, que he cambiado porque al decir
en clase que meter una cola de 0 daba error, el mio aceptaba ese parametro pero lo he cambiado.
Es el random creado en clase junto a los mismos de lectura, asi que es un copia y pega, no tiene nada propio.
 */

public class Ordenadalogics
{
    public Ordenadalogics()
    {
        this.first = null;
        this.last = null;
    }

    private void addpersons()
    {
        while (sa.hasNextLine())
            apellidosList.add(sa.nextLine());
        while (sh.hasNextLine())
            hombreList.add(sh.nextLine());
        while (sm.hasNextLine())
            mujeresList.add(sm.nextLine());
    }

    private String setNombre()
    {
        String persona = "";

        if (r.nextInt(10) != 4)
            persona += " " + apellidosList.get(r.nextInt(apellidosList.size()));
        persona += " " + apellidosList.get(r.nextInt(apellidosList.size()));
        persona += " , ";
        if (r.nextInt(2) == 0)
        {
            persona += mujeresList.get(r.nextInt(mujeresList.size()));
            if (r.nextInt(5) == 2)
                persona += " " + mujeresList.get(r.nextInt(mujeresList.size()));
        } else
        {
            persona += hombreList.get(r.nextInt(hombreList.size()));
            if (r.nextInt(5) == 2)
                persona += " " + hombreList.get(r.nextInt(hombreList.size()));
        }

        return persona;
    }

    public void introducir(String data)
    {
        Node work = new Node(data);
        Node current = first;
        Node previous = null;

        while (current != null && data.compareTo(current.data) > 0)
        {
            previous = current;
            current = current.next;
        }
        if (current == null)
        {
            if (first == null)
            {
                first = work;
            } else
            {
                last.next = work;
            }
            last = work;
        } else
        {
            if (previous == null)
            {
                first = work;
            } else
            {
                previous.next = work;
            }
            work.next = current;
        }
    }

    public void writeList()
    {
        Node work = first;
        while (work != null)
        {
            ag.println(work.data);
            work = work.next;
        }
    }

    class Node
    {
        String data;
        Node next;

        public Node(String data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public void lista()
    {
        try
        {
            sa = new Scanner(apellidos);
            sm = new Scanner(mujeres);
            sh = new Scanner(hombres);
            addpersons();
            sh.close();
            sm.close();
            sa.close();

            ag = new PrintWriter("persones.txt");
            int a = sc.showMessageAndGetInt("introduce el numero de personas a validar");
            for (int i = 0; i < a; i++)
            {
                introducir(setNombre());
            }
            writeList();
            ag.close();
        } catch (FileNotFoundException fnfe)
        {
            System.err.println("Error en la lectura de archivos");
        }
    }

    Scannerutilss sc = new Scannerutilss();
    File apellidos = new File("llinatges.txt");
    File hombres = new File("homes.txt");
    File mujeres = new File("dones.txt");

    Scanner sa, sm, sh;

    List<String> apellidosList = new ArrayList<>();
    List<String> hombreList = new ArrayList<>();
    List<String> mujeresList = new ArrayList<>();

    PrintWriter ag;
    Node first;
    Node last;
    Random r = new Random();
}
