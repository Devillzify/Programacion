package POO;

public class Vertice {
    double x, y;

    public Vertice(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static public Vertice medio(Vertice a, Vertice b){

        return new Vertice((a.x + b.x) / 2, (a.y + b.y) / 2 );
    }
}
