

public class Vertices
{
    double x, y;

    public  Vertices(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    static public Vertices medio(Vertices a, Vertices b)
    {
        return escalar(1.0/2.0, sumar(a,b));
    }

    static public Vertices resta(Vertices a, Vertices b)
    {
        return new Vertices(a.x - b.x, a.y - b.y);
    }

    static public Vertices escalar(double valor, Vertices a)
    {
        return new Vertices(valor * a.x, valor * a.y);
    }

    static public Vertices sumar(Vertices a, Vertices b)
    {
        return new Vertices( a.x + b.x, a.y + b.y);
    }

    static public double modulo(Vertices a)
    {
        return Math.sqrt(a.x * a.x + a.y * a.y);
    }


}
