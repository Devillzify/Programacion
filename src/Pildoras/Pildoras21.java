package Pildoras;

import javax.swing.*;

public class Pildoras21
{
    public static void main(String[] args)
    {


        boolean punto = false;
        int arroba = 0;

        String mail = JOptionPane.showInputDialog("introduce mail");

        for(int i = 0; i < mail.length(); i++)
        {
            if(mail.charAt(i) == '@')
            {
                arroba++;
            }
            if(mail.charAt(i) == '.')
            {
                punto = true;
            }
        }
        if (arroba == 1 && punto == true)
        {
            System.out.println("es correcto");
        }
        else
        {
            System.out.println("no es correcto");
        }

    }
}
