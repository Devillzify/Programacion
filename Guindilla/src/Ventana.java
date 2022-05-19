import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame
{
    Container interior;
    public Ventana()
    {
        super("My first window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interior = getContentPane();
        setResizable(false);

        setLayout(null);
        interior.setPreferredSize(new Dimension(640,480));
        pack();
        interior.setBackground(Color.CYAN);

        JButton boton = new JButton("Press me");

        boton.setSize(new Dimension(100,40));
        boton.setLocation((interior.getWidth() - boton.getWidth()) >> 1,(interior.getHeight() - boton.getHeight()) >> 1);
        boton.addActionListener(botonActionListener());
        boton.addKeyListener(botonKeyListener());
        interior.add(boton);


        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int) s.getWidth() - getWidth()) >> 1,((int) s.getHeight() - getHeight()) >> 1);
        setVisible(true);
    }
    ActionListener botonActionListener()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               setVisible(false);
               dispose();
               System.exit(0);
            }
        };
    }
    public static void main(String[] args)
    {
        new Ventana();
    }

    KeyListener botonKeyListener()
    {
        return new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    setVisible(false);
                    dispose();
                    System.exit(0);
                }
            }

            @Override
            public void keyPressed(KeyEvent e)
            {

            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        };
    }
}
