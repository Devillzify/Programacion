
public class Pile
{
    private Node first;

    public Pile()
    {
        this.first = null;
    }

    public void insert(String data)
    {
        Node work = new Node(data);

        work.next = first;
        first = work;
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
}
