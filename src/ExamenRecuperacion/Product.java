package ExamenRecuperacion;

public class Product
{
    String code;
    int price;
    String name;

    public Product(String code, int price,String name)
    {
        this.code = code;
        this.price = price;
        this.name = name;
    }
public String toString()
{
    return String.format("%s %-30s %3dC", code,name,price);
}
}
