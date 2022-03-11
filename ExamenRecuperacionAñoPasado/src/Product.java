public class Product {

    String code;
    String name;
    int price;
    int quantity;

    public Product (String code, int price, String name, int quantity){

        this.code = code;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
    public String toString(){

        return String.format("%s %-30s %3d€ %3d", code, name, price,quantity); //
    }
}
