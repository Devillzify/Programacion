import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    String code;
    String description;
    double price;

    public Product(String code, String description, double price)
    {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String toString()
    {
        return String.format("%s %-31s %6.2f€", code, description, price);
    }
}

