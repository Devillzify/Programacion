package Pildoras;

import javax.swing.*;

public class Piladoras18
{
    public static void main(String[] args)
    {
        String clave = "Andres";

        String pass = "";

        while (clave.equals(pass) == false)
        {
            pass=JOptionPane.showInputDialog("Introduce la contraseña");

            if(clave.equals(pass)==false)
            {
                System.out.println("contraseña incorrecta");
            }
        }
        System.out.println("Contraseña correcta acceso permitido");

    }
}
