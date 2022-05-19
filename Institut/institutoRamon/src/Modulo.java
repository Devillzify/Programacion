import java.io.Serial;
import java.io.Serializable;
public class Modulo implements Serializable
{
    @Serial
            private static final long serialVersionUID = 1L;
    String id;
    String name;

    public Modulo(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
}