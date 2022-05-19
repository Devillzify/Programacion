public class Proves
{
    public static void main(String[] args)
    {
        Hora h1 = new Hora(23, 59);
        h1.inc();
        System.out.println(h1);

        Hora12 h2 = new Hora12(11, 59, Meridiano.PM);
        h2.inc();
        System.out.println(h2);
    }
}