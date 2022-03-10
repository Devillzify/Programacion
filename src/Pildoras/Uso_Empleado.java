package Pildoras;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado   // video 33,34,35
{
    public static void main(String[] args)
    {
        Empleado[] Empleados = new Empleado[4];

        Empleados[0] = new Empleado("Paco Gomez", 85000, 1990, 12, 17);
        Empleados[1] = new Empleado("Ana lopez", 95000, 1995, 6, 2);
        Empleados[2] = new Empleado("Maria Martin", 105000, 2002, 3, 15);
        Empleados[3] = new Empleado("Antonio Fernandez");

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

        public Empleado(String nom)
        {
            this(nom,30000,2000,01,01);
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
