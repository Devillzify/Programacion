import javax.swing.*;
import java.awt.*;

public class Contingut extends JPanel
{
    Botons b1 = new Botons(10, 10, "primer");
    Botons b2 = new Botons(10, 50, "segon");
    Botons b3 = new Botons(10, 90, "tercer");

    public Contingut()
    {
        initComponents();
    }

    private void initComponents()
    {
        setBackground(Color.gray);
        setPreferredSize(new Dimension(800, 600));
        setLayout(null);
        add(b1);
        add(b2);
        add(b3);
    }
}