

public class CirclePinterest
{
    ToolsSVG ts;

    public CirclePinterest(int nivel)
    {
        ts = new ToolsSVG(String.format("CerclesPinterest%02d", nivel));
        ts.cabecera(-1.2, -1.2, 2.4, 2.4, 800, 800);
        if (nivel % 2 != 0)
            ts.setFillColor("darkred");
        else
            ts.setFillColor("red");
        ts.rectangle(-1.2, -1.2, 2.4, 2.4);
        ts.setStroke("white");
        ts.setStrokeWidth(0.003);
        cajaNegra(4, nivel);
        ts.cerrar();
    }

    private void cajaNegra(int base, int nivel)
    {
        double alfa = 2.0 * Math.PI / base;
        double beta = alfa / 2.0;

        double radio = 1.0 / Math.cos(beta);

        Vertices[] puntos = new Vertices[base];

        double zeta = beta;
        for (int k = 0; k < base; k++)
        {
            puntos[k] = new Vertices(radio * Math.cos(zeta), radio * Math.sin(zeta));
            zeta += alfa;
        }
        if (nivel % 2 == 0)
            ts.setFillColor("darkred");
        else
            ts.setFillColor("red");
        for (int k = 0; k < base; k++)
        {
            ts.circulo(puntos[k].x, puntos[k].y, radio * Math.sin(beta));
        }
        if (nivel > 1)
            cajaNegra(base + base, nivel - 1);
    }
}