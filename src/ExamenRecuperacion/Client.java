package ExamenRecuperacion;

public class Client
{
    String id;
    String name;

    public Client(String id, String name)
    {
        this.id = id;
        this.name = name;
    }


    public String toString()
    {
        return String.format("%s %s",id,name);
    }
}
