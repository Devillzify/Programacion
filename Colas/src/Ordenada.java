

public class Ordenada<current>
{
    static Node first;
    static Node last;

    public Ordenada()
    {
        this.first = null;
        this.last = null;
    }

    public static void insert(String data)
    {

        data = ClientGenerator.GeneradorClient();
        Node work = new Node(data);

        Node current = first;
        Node previous = null; // para empezar no existe anterior y empieza en null

        while (current != null && data.compareTo(current.data) > 0)
        { //mientras current sea diferente null si la lista esta vacia es null porque no hay nada, pero tmb puede ser que el dato que queremos meter sea menor a lo que ya esta puesto en el current. y el && si el primero es falso lo demas sera falso, es decir si el primero es falso ya no mira el resto.
            previous = current;
            current = current.next;
        }// si se acaba porque  first es igual null, hemos de meter uno al final, "lo de llegar a la cola" y se convierte en el ultimo
        if (current == null)
        {

            if (first == null)
                first = work;

            else  // si los dos son null es que no hay nada en la lista, por lo tanto el elemento sera tanto el primero como el ultimo de la lista.
                last.next = work;// el siguiente del último
            last = work;// y este que es el último
        } else
        {//

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

    public static void show()
    {
        Node work = first; // si no hay nadie en la cola no hay ada qu mostrar , por lo tanto si es null, mientras work sea diferente de null, imprime los datos y pasa al siguiente

        while (work != null)
        {
            System.out.println(work.data);
            work = work.next;
        }
    }
}