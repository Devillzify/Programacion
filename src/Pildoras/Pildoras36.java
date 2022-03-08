package Pildoras;

public class Pildoras36
{

    public static void main(String[] args)
    {
        Empleados trabajador1 = new Empleados("jose");
        Empleados trabajador2 = new Empleados("Ana");
        Empleados trabajador3 = new Empleados("Paco");

        trabajador1.cambiarSeccion("jesucristo");
        System.out.println(trabajador1.getSeccion());
        System.out.println(trabajador2.getSeccion());
        System.out.println(trabajador3.getSeccion());
    }


}
    class Empleados
    {
        private final String nombre;

        private String seccion;

        public Empleados(String nom)
        {
            nombre = nom;

            seccion = "administracion";
        }


        public void cambiarSeccion(String seccion)
        {
            this.seccion = seccion;
        }

        public String getSeccion()
        {
            return "el nombre es " + nombre + " y la seccion es " + seccion;
        }
    }

