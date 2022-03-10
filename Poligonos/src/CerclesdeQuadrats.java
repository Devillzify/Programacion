package ProgramacionCasa.Poligonos;

import static java.awt.Color.HSBtoRGB;

public class CerclesdeQuadrats
{
    ToolsSVG ts;

    public CerclesdeQuadrats(int caras, int nivel)
    {
        ts = new ToolsSVG(String.format("CerclesDeQuadrats%02d%02d", caras, nivel));
        ts.cabecera(-1.2, -1.2, 2.4, 2.4, 800, 800);
        ts.setFillColor("white");
        ts.rectangle(-1.2, -1.2, 2.4, 2.4);
        ts.setStroke("black");
        ts.setStrokeWidth(0.002);
        cajaNegra(1.0, caras, nivel);
        ts.cerrar();
    }

    private void cajaNegra(double radio, int caras, int nivel)
    {
        double alfa = 2.0 * Math.PI / caras;
        double beta = alfa / 2.0;
        double coseta = Math.cos(beta);
        double sineta = Math.sin(beta);
        double zeta = beta * (nivel % 2);

        Vertices[] puntos = new Vertices[caras];

        for (int k = 0; k < caras; k++)
        {
            puntos[k] = new Vertices(radio * Math.cos(zeta), radio * Math.sin(zeta));
            zeta += alfa;
        }
        for (int k = 0; k < caras; k++)
        {
            Vertices a = puntos[k];
            Vertices b = puntos[(k + 1) % caras];
            Vertices c = Vertices.medio(a, b);
            double p = Vertices.modulo(c);
            c = Vertices.escalar(1 / p, c);
            Vertices d = Vertices.escalar(radio * (coseta - sineta), c);
            Vertices e = Vertices.escalar(radio * (coseta + sineta), c);
            //ts.setFillColor(String.format("hsl(%f,100%%,50%%)", Math.toDegrees(Math.atan2(c.y, c.x))));
            float angulo = (float) (1.0 + Math.atan2(c.y, c.x) / (2.0 * Math.PI));
            ts.setFillColor(String.format("#%06X", HSBtoRGB(angulo, 1f, 1f) & 0xFFFFFF));
            ts.poligono(String.format("%f %f %f %f %f %f %f %f", a.x, a.y, d.x, d.y, b.x, b.y, e.x, e.y));
        }
        if (nivel > 1)
            cajaNegra(radio * (coseta - sineta), caras, nivel - 1);
    }
}