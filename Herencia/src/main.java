public class main
{
    public static void main(String[] args)
    {
/*
        Hora h = new Hora(22,10);
        h.setHora(12);
        h.setMinuto(33);
        System.out.println(h.toString());
*/

        Hora12 h12 = new Hora12(13,33);
        System.out.println(h12.toString());


/*
        HoraExacta he = new HoraExacta(23,20,10);
        he.setHora(15);
        he.setMinuto(25);
        he.setSegundos(59);
       // he.inc();
        System.out.println(he.toString());

*/

        HoraExacta he = new HoraExacta(12,20,33);
        he.comparar("12:20:40");


    }
}
