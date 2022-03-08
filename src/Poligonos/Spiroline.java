package ProgramacionCasa.Poligonos;

import java.util.Locale;

public class Spiroline
{
    final int MUESTRAS = 360;

    ToolsSVG ts;

    public Spiroline(String nomArxiu, int factor)
    {

        ts = new ToolsSVG(nomArxiu);
        ts.cabecera(-1.08,-1.08, 2.16, 2.16, 600, 600);
        ts.setStroke("white");
        ts.setStrokeWidth(0.002);
        cajaNegra(factor);
        ts.cerrar();
    }

    private void cajaNegra(int factor)
    {
        double delta = 2.0 * Math.PI / MUESTRAS; //delta es el desplazamiento desde donde empiezan las lineas

        boolean color = false;

        ts.rectangle(-1.08,-1.08, 2.16, 2.16);
        for (int p = 0; p < MUESTRAS; p++)
        {
            double alfa = p * delta;
            double x1 = Math.cos(alfa);
            double y1 = Math.sin(alfa);
            double beta = ((p * factor) % MUESTRAS) * delta;
            double x2 = Math.cos(beta);
            double y2 = Math.sin(beta);
            if(color)
                ts.setStroke(String.format("hs1(%f,100%%,50%%", Math.toDegrees(alfa)));
            ts.lina(x1, y1, x2, y2);
       }
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        for (int i = 2; i < 9; i++)
        {
            new Spiroline(String.format("SpiroLine%03d.svg", i), i);
        }
    }
}
