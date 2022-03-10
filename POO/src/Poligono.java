package POO;

public class Poligono
{
    int lados;
    private Vertice[] vertices;

    public Poligono(int lados)
    {

        this.lados = lados;
    }

    public void calcular(double radio)
    {
        Vertice[] vertices = new Vertice[lados];

        double alfa = Math.PI / 2;
        double beta = 2.0 * Math.PI / lados;

        for(int k = 0; k < lados; k++){

            vertices[k] = new Vertice(radio * Math.cos(alfa), radio*Math.sin(alfa));
            alfa += beta;
        }
    }
    public void dibujar(){

    }
}
