import java.util.ArrayList;
import java.util.List;

public class Invoice {
    int number;
    String client;
    List<Product> purchase = new ArrayList<>();
    public Invoice(int number, String client){
        this.number = number;
        this.client = client;
        this.purchase = null;
    }

}
