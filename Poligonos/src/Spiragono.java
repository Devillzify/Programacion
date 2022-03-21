

import java.util.Locale;
public class Spiragono
{
    ToolsSVG ts;

    public Spiragono(Vertices p, int lados, int nivel)
    {
       String arxiu = String.format("Spirogano%03d%03d", lados, nivel);
       ts = new ToolsSVG(arxiu);
       ts.cabecera(-1.1,-1.1,2.2,2.2,600,600);
       ts.setStroke("black");
       ts.setStrokeWidth(0.002);
       ts.setFillColor("yellow");
       cajaNegra(p, lados, nivel);
       ts.cerrar();
    }

    private void cajaNegra(Vertices p, int lados, int nivel)
    {
        double alfa = Math.atan2(p.y, p.x); // arco tanjente, el angulo cuyo tanjete es y/x
        double beta = Math.PI * 2.0 / lados;
        Vertices[] vertices = new Vertices[lados];
        double radio = Vertices.modulo(p); // la distancia del origen
        String puntos = "";

        for (int k = 0; k < lados; k++)
        {
            vertices[k] = new Vertices(radio * Math.cos(alfa), radio * Math.sin(alfa));
            puntos += String.format(" %.2f %.2f", vertices[k].x,vertices[k].y);
            alfa += beta;
        }
        if(nivel %2 == 0)
        {
            ts.setFillColor("#00ffff");
        }
        else
        {
            ts.setFillColor("black");
        }
        ts.poligono(puntos);
        Vertices q = Vertices.resta(vertices[1], vertices[0]); //això fa sa resta
        q = Vertices.sumar(vertices[0], Vertices.escalar(0.1,q));
        if(nivel > 0)
        {
            cajaNegra(q, lados, nivel - 1);
        }
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Spiragono(new Vertices(0,1), 5, 80);
    }
}
