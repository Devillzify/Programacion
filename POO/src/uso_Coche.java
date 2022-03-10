package POO;
import javax.swing.*;

public class uso_Coche
{
    public static void main(String[] args)
    {
        coche micoche = new coche();

        micoche.establece_color(JOptionPane.showInputDialog("de que color es?"));

        System.out.println(micoche.datos_generales());

        System.out.println(micoche.dime_color());

        micoche.configura_asientos(JOptionPane.showInputDialog("asientos de cuero?"));

        System.out.println(micoche.dime_asientos());

        micoche.configura_climatizador(JOptionPane.showInputDialog("tiene climatizador?"));

        System.out.println(micoche.dime_climatizador());

        System.out.println(micoche.dime_peso_coche());

        System.out.println(" el precio final del coche es: " + micoche.precio_coche() + " euros");

    }
}
