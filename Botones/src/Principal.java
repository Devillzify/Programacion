import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame
{
    Contingut ctg = new Contingut();

    public Principal()
    {
        initComponents();
    }

    private void initComponents()
    {
        setTitle("Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(ctg);

        pack();

        ctg.b1.addActionListener(b1ActionListener());

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Principal();
    }

    ActionListener b1ActionListener()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ctg.b1.setBackground(Color.blue);
            }
        };
    }
}