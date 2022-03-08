package Spyrolane;

public class CalculatedLine
{
    private double alfa;
    private double x1;
    private double y1;
    private double beta;
    private double x2;
    private double y2;

    public CalculatedLine(double alfa, double x1, double y1, double beta, double x2, double y2)
    {
        this.alfa = alfa;
        this.x1 = x1;
        this.y1 = y1;
        this.beta = beta;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getAlfa()
    {
        return alfa;
    }

    public void setAlfa(double alfa)
    {
        this.alfa = alfa;
    }

    public double getX1()
    {
        return x1;
    }

    public void setX1(double x1)
    {
        this.x1 = x1;
    }

    public double getY1()
    {
        return y1;
    }

    public void setY1(double y1)
    {
        this.y1 = y1;
    }

    public double getBeta()
    {
        return beta;
    }

    public void setBeta(double beta)
    {
        this.beta = beta;
    }

    public double getX2()
    {
        return x2;
    }

    public void setX2(double x2)
    {
        this.x2 = x2;
    }

    public double getY2()
    {
        return y2;
    }

    public void setY2(double y2)
    {
        this.y2 = y2;
    }
}


