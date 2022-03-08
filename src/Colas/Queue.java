package Colas;

public class Queue
{

    Node first;
    Node last;

    public Queue()
    {
        this.first = null;
        this.last = null;
    }

    public void insertar(String data)
    {

        Node work = new Node(data);

        if (first == null)
        {
            first = work;
        } else
        {
            last.next = work;
        }
        last = work;
    }

    public String extract()
    {
        String data = "";

        if (first != null)
        {
            data = first.data;
            first = first.next;

        }
        return data;
    }
    public void show()
    {
        Node work = first;

        while (work != null)
        {
            System.out.println(work.data);
            work = work.next;
        }
    }

    public void staff(String data)
    {
        Node work = first;
        Node previous = null;

        while (work != null)
        {
            if (data.equals(work.data))
            {
                if(work == first)
                {
                    first = first.next;
                }
                else
                previous.next = work.next;
                System.out.println(data + " has been removed");
                return;
            }
            previous = work;
            work = work.next;
        }
        System.out.println("Does not exist");
    }
}
