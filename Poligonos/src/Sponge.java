package ProgramacionCasa.Poligonos;

import java.util.Locale;

public class Sponge
{
    Vertices origen;
    double lado;
    int nivel;
    ToolsSVG svg;


    public Sponge(Vertices origen, double lado, int nivel)
    {
        this.origen = new Vertices(origen.x,origen.y);
        this.lado = lado;
        this.nivel = nivel;
        svg = new ToolsSVG("Sponge");//Se le pasa un nombre de archivo
        svg.cabecera();
        procesar(origen, lado, nivel);
        svg.cerrar();
    }

    public void procesar(Vertices origen,double lado, int nivel)
    {
        if(nivel == 0)
        {
            svg.rectangle(origen.x, origen.y,lado,lado);
        }
        else
        {
            double nuevoLado = lado / 3.0;
            for(int k = 0; k < 9; k++)
            {
                int p = k / 3;
                int q = k % 3; // para pasar de una cosa lineal a modular
                if (k != 4) // El del medio será el que no queremos que se dibuje
                {
                 procesar(new Vertices(origen.x + nuevoLado * p, origen.y + nuevoLado * q),
                         nuevoLado, nivel - 1);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        new Sponge(new Vertices(-95,-95),190,3);
    }
}
