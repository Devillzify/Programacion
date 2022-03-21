

import java.util.Locale;
public class Sierpinskii
{
    ToolsSVG ts;

    public Sierpinskii()
    {
        Vertices a = new Vertices(0.0, -1.0);
        Vertices b = new Vertices(0.866, 0.5);
        Vertices c = new Vertices(-0.866,0.5);

        ts = new ToolsSVG("Sierpinskii");
        ts.cabecera(-1.0,-1.0,2.0,2.0,6,6);
        ts.setFillColor("purple");
        ts.rectangle(-1.0,-1.25,2.0,2.0);
        ts.setFillColor("deepskyblue");
        procesar (a, b, c, 6);
        ts.cerrar();
    }

    private void procesar(Vertices a, Vertices b, Vertices c, int nivel)
    {
        if (nivel == 0)
        {
            ts.poligono(String.format("%.2f %.2f %.2f %.2f %.2f %.2f", a.x, a.y, b.x, b.y, c.x, c.y));
        }
        else
        {
            Vertices p = Vertices.medio(a,b);
            Vertices q = Vertices.medio(b,c);
            Vertices r = Vertices.medio(c,a);
            procesar(a,p,r, nivel -1); // nivel - 1 para que solo nos salga un triangulo
            procesar(p,b,q, nivel -1);
            procesar(r,q,c, nivel -1);
        }
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Sierpinskii();
    }
}
