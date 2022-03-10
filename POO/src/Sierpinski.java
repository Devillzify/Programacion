package POO;

public class Sierpinski
{

    public Sierpinski(){
        Vertice a = new Vertice(0.0, 1.0);
        Vertice b = new Vertice(0.866, -0.5);
        Vertice c = new Vertice(-0.866, -0.5);

        procesar(a,b,c, 2);
    }
    private void procesar(Vertice a, Vertice b, Vertice c, int nivel){

        if(nivel == 0){

            System.out.format("%f %f %f %f %f %f\n", a.x, a.y, b.x, b.y, c.x, c.y);
        }
        else{

            Vertice p = Vertice.medio(a, b);
            Vertice q = Vertice.medio(b, c);
            Vertice r = Vertice.medio(c, a);

            procesar(a, p, r, nivel -1);
            procesar(p, b, q, nivel -1);
            procesar(r, q, c, nivel -1);
        }

    }

    public static void main(String[] args)
    {
        new Sierpinski();
    }
}
