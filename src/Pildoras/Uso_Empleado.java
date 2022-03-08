package Pildoras;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado   // video 33,34,35
{
    public static void main(String[] args)
    {
       /* Empleado empleado1 = new Empleado("Paco Gomez", 85000, 1990, 12, 17);
        Empleado empleado2 = new Empleado("Ana lopez", 95000, 1995, 06, 02);
        Empleado empleado3 = new Empleado("Maria Martin", 105000, 2002, 03, 15);

        empleado1.setSueldo(5);
        empleado2.setSueldo(5);
        empleado3.setSueldo(5);

       System.out.println("Nombre: " + empleado1.getNombre() + "con un sueldo: " + empleado1.getSueldo() + " Contratado con Fecha de alta: " + empleado1.getAltaContrato());
        System.out.println("Nombre: " + empleado2.getNombre() + "con un sueldo: " + empleado2.getSueldo() + " Contratado con Fecha de alta: " + empleado2.getAltaContrato());
        System.out.println("Nombre: " + empleado3.getNombre() + "con un sueldo: " + empleado3.getSueldo() + " Contratado con Fecha de alta: " + empleado3.getAltaContrato()); */

        Empleado[] Empleados = new Empleado[3];

        Empleados[0] = new Empleado("Paco Gomez", 85000, 1990, 12, 17);
        Empleados[1] = new Empleado("Ana lopez", 95000, 1995, 6, 2);
        Empleados[2] = new Empleado("Maria Martin", 105000, 2002, 3, 15);

       /* for(int i = 0; i < 3; i++)
        {
            Empleados[i].setSueldo(5);
        }
        */
        for(Empleado e: Empleados)
        {
            e.setSueldo(5);
        }

        for(Empleado e: Empleados)
        {
            System.out.println("Nombre: " + e.getNombre() + " Con un sueldo de: " + e.getSueldo() + " Con fecha de alta: " + e.getAltaContrato());
        }
    }
}


    class Empleado
    {
        public Empleado(String nom, double sue, int agno, int mes, int dia)
        {
            nombre = nom;
            sueldo = sue;
            GregorianCalendar calendario = new GregorianCalendar(agno, mes -1, dia);
            altaContrato = calendario.getTime();
        }



    public String getNombre() // getter
    {
        return nombre;
    }

    public double getSueldo()
    {
        return sueldo;
    }

    public Date getAltaContrato()
    {
        return altaContrato;
    }

    public void setSueldo(double porcentaje)
    {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }


    private String nombre;
    private double sueldo;
    private Date altaContrato;
}
