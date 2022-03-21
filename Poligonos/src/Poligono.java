

import java.util.Locale;

public class Poligono
{
    int lados;
    Vertices[] vertices;
    ToolsSVG ts;

    public Poligono(int lados)
    {
        this.lados = lados;
        vertices = new Vertices[lados];
        ts = new ToolsSVG(String.format("poligono%03d", lados));
        ts.cabecera(-1.1,-1.1,2.2,2.2,6,6);
        calcular(1);
        ts.poligono(toString());
        ts.cerrar();
    }

    public String toString()
    {
        String puntos = "";
        for(int k = 0; k < vertices.length; k++)
        {
            puntos += String.format(" %.2f %.2f", vertices[k].x,vertices[k].y);
        }
        return puntos;
    }

    public void calcular(double radio)
    {
        double alfa = -Math.PI / 2.0;
        double beta = 2.0 * Math.PI / lados;

        for (int k = 0; k < lados; k++)
        {
            /* Los puntos medios de un poligono*/
            vertices[k] = new Vertices(radio * Math.cos(alfa), radio * Math.sin(alfa));
            alfa += beta;
        }
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Poligono(5);
    }

}
