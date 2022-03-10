package ProgramacionCasa.Poligonos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

public class Flake
{
    final int sides;
    final int level;
    final int limit;

    final int side = 1024;
    final double radio = 0.98 * side / 2.0;

    final double alfa;
    final double beta;

    double scale = 0.0;

    PrintWriter svg;

    public Flake(int sides, int level)
    {
        this.sides = sides;
        this.level = level;
        this.limit = sides >> 2;

        this.alfa = 1.5 * Math.PI;
        this.beta = 2.0 * Math.PI / sides;

        for (int k = 1; k <= limit; k++)
            scale += Math.cos(2.0 * Math.PI * k / sides);
        scale = 1.0 / (2.0 * scale + 2.0);

        try
        {
            svg = new PrintWriter(String.format("flake%02d%02d.svg", sides, level));
            svgContent(level, 0.0, 0.0, radio);
            svg.println(svgClose());
            svg.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Something went wrong!");
        }
    }

    private String svgClose()
    {
        return "</svg>";
    }

    private void svgContent(int n, double x, double y, double r)
    {
        if (n == 0)
        {
            String points = "";
            double a = alfa;
            for (int k = 0; k < sides; k++)
            {
                points += String.format(" %.2f, %.2f", x + r * Math.cos(a), y + r * Math.sin(a));
                a += beta;
            }
            svg.println(svgPolygon(points));
        }
        else
        {
            double s = r * scale;
            double t = r - s;
            double a = alfa;
            for (int k = 0; k < sides; k++)
            {
                svgContent(n - 1, x + t * Math.cos(a), y + t * Math.sin(a), s);
                a += beta;
            }
        }
    }

    private String svgPolygon(String points)
    {
        return String.format("<polygon points=\"%s\"/>", points);
    }

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);
        for (int k = 0; k < 7; k++)
            new Flake(12, k);
    }
}