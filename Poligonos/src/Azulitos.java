package ProgramacionCasa.Poligonos;

public class Azulitos
{
    ToolsSVG ts;

    public Azulitos(int caras, int nivel)
    {
        ts = new ToolsSVG(String.format("azulitos%02d%02d", caras));
        ts.cabecera();
        cajaNegra(caras, nivel);
        ts.cerrar();
    }

    public void cajaNegra(int caras, int nivel)
    {
        double alfa = 2.0 * Math.PI / caras;
        double beta = alfa / 2.0;
        double zeta = 0.0;
        Vertices[] puntos = new Vertices[caras];
        for (int k = 0; k < caras; k++)
        {
            puntos[k].x = Math.cos(zeta);
            puntos[k].y = Math.sin(zeta);
            zeta += alfa;
        }
        for (int k = 0; k < caras; k++)
        {
            Vertices a = puntos[k];
            Vertices b = puntos[(k+1) % caras];
            Vertices c = Vertices.medio(a, b);
            double p = Vertices.modulo(a);

        }
    }
}
