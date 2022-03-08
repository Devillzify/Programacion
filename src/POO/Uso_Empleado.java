package POO;


import java.util.*;

public class Uso_Empleado {

    public static void main(String[] args) {

       /* Empleado empleado1 = new Empleado ("paco", 85000,1990,12,17);
        Empleado empleado2 = new Empleado ("ana lopez", 95000,1995,06,02);
        Empleado empleado3 = new Empleado ("maria martin", 105000,2002,03,15);

        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);

        System.out.println("nombre" + empleado1.getNombre() + " " + empleado1.getSueldo() + " " + empleado1.getAltaContrato());  */

        Empleado[] misEmpleado = new Empleado[3];

        misEmpleado[0] = new Empleado("paco", 85000,1990,12,17);
        misEmpleado[1] = new Empleado("sofia", 90000,1995,06,03);
        misEmpleado[2] = new Empleado("lucia", 70000, 2000,12,05);

        /*for(int i = 0; i < 3; i++){
            misEmpleado[i].subeSueldo(5);
        }

        for( int i = 0; i < 3; i++){
            System.out.println(" nombre " + misEmpleado[i].getNombre() + " sueldo " + misEmpleado[i].getSueldo() + " fecha alta " + misEmpleado[i].getAltaContrato());
        }
    */
        for(Empleado e: misEmpleado){
            System.out.println(" nombre " + e.getNombre() + " sueldo " +e.getSueldo() + " fecha alta " + e.getAltaContrato());
        }

        for(Empleado e: misEmpleado){
            e.subeSueldo(5);
        }


    }


        static class Empleado{

        public Empleado(String nom, double sue, int agno, int mes, int dia){

            nombre = nom;
            sueldo = sue;
            GregorianCalendar calenadrio = new GregorianCalendar(agno, mes -1, dia);
            altaContrato = calenadrio.getTime();



        }
        public String getNombre(){
            return nombre;
        }
        public double getSueldo(){
            return sueldo;
        }

        public Date getAltaContrato(){
            return altaContrato;
        }

        public void subeSueldo(double porcentaje){ // setter
            double aumento = sueldo * porcentaje/100;
            sueldo += aumento;
        }



        private String nombre;
        private double sueldo;
        private Date altaContrato;

    }
}
