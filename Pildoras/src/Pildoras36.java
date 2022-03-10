package Pildoras;

public class Pildoras36
{

    public static void main(String[] args)
    {

        Empleados trabajador1 = new Empleados("jose");
        Empleados trabajador2 = new Empleados("Ana");
        Empleados trabajador3 = new Empleados("Paco");
        Empleados trabajador4 = new Empleados("Sofia");

        trabajador1.cambiarSeccion("RRHH");

        System.out.println(trabajador1.getSeccion() + "\n" + trabajador2.getSeccion() + "\n" + trabajador3.getSeccion() + "\n" + trabajador4.getSeccion());
        System.out.println(Empleados.dameIdSiguiente());

    }


}
    class Empleados
    {
        private final String nombre;

        private String seccion;

        private int ID;

        private static int IdSiguiente = 1;

        public Empleados(String nom)
        {
            nombre = nom;

            seccion = "administracion";

            ID =IdSiguiente;;
            IdSiguiente++;
        }


        public void cambiarSeccion(String seccion)
        {
            this.seccion = seccion;
        }

        public String getSeccion()
        {
            return "el nombre es " + nombre + " y la seccion es " + seccion + " la ID es: " + ID;
        }

        public static String dameIdSiguiente()
        {
            return "El IdSiguiente es: " + IdSiguiente;
        }
    }

