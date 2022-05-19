import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Botons extends JButton
{
    public Botons(int x, int y, String text)
    {
        this.setText(text);
        this.setLocation(x, y);
        initComponents();
    }

    private void initComponents()
    {
        setSize(150, 35);
        setFocusPainted(false);
        setFont(new Font("SansSerif", Font.BOLD, 18));
        setBackground(Color.red);
        setForeground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.orange, 4, true));

        addMouseListener(theMouseListener());
    }

    MouseListener theMouseListener()
    {
        return new MouseListener()
        {
            Color actual;

            @Override
            public void mouseClicked(MouseEvent e)
            {
                actual = getBackground();
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                actual = getBackground();
                setBackground(new Color(0x336699));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                setBackground(actual);
            }
        };
    }
}
 