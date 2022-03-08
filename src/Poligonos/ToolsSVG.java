package ProgramacionCasa.Poligonos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

public class ToolsSVG
{
    private String xmlns="http://www.w3.org/2000/svg";
    private String xlink="http://www.w3.org/1999/xlink";

    String stroke = "none";
    double strokeWidth = 1.0;
    String fillColor = "#000"; //color negro

    private PrintWriter pw;

    public ToolsSVG(String archivo)
    {
        Locale.setDefault(Locale.ROOT);
        try
        {
            pw = new PrintWriter(archivo + ".svg");
        }
        catch (FileNotFoundException err)
        {
            System.err.println(err.getMessage());
            System.exit(9 * (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) - 1);
        }
    }

    public  void cabecera()
    {
        pw.format("<svg xmlns=\"%s\" xmlns:xlink=\"%s\" ", xmlns, xlink);
        pw.format("viewBox=\"%f %f %f %f\" ", -10.0, -10.0, 20.0, 20.0);
        pw.format("width=\"%d\" height=\"%d\">\n", 800, 800);
       // pw.println("<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">");
    }

    public void cabecera(double x, double y, double xlen, double ylen, int width, int height)
    {
        pw.format("<svg xmlns=\"%s\" xmlns:xlink=\"%s\" ", xmlns, xlink);
        pw.format("viewBox=\"%f %f %f %f\" ", x, y, xlen, ylen);
        pw.format("width=\"%d\" height=\"%d\">\n", width, height);
    }

    public void poligono(String points)
    {
        pw.format("<polygon points=\"%s\" %s/>\n", points, colores()); // esta sería la linia que se imprimiría
    }

    /*HAY QUE CERRAR EL SVG Y PRINTWRITTER */
    public void cerrar()
    {
        pw.println("</svg>");
        pw.close();

    }

    public void rectangle(double x, double y, double width, double height)
    {
        pw.format("<rect x=\"%f\" y=\"%f\" width=\"%f\" height=\"%f\" %s/>\n",x, y, width, height,colores());
    }

    public void lina(double x1, double y1, double x2, double y2)
    {
        pw.format("<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" %s/>\n",x1,y1,x2,y2, colores());
    }
/*Creamos los diferentes Setter para modificar los colores y tamaños de la figura pero esta no los incluye */
    public void setStroke(String color)
    {
        this.stroke = color;
    }

    public void setStrokeWidth(double width)
    {
        this.strokeWidth = width;
    }

    public void setFillColor(String color)
    {
        this.fillColor = color;
    }

    private String colores()
    {
        return String.format("stroke=\"%s\" stroke-width=\"%f\" fill=\"%s\"", stroke, strokeWidth, fillColor);
    }

    public void circulo(double cx, double cy, double r)
    {
        pw.format("<circle cx=\"%f\" cy=\"%f\" r=\"%f\" %s/>\n", cx, cy, r, colores());
    }
}
