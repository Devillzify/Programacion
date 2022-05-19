public class Circulitos extends Imatge
{

    public Circulitos(int width, int height)
    {
        super(width, height);
    }

    public String toString()
    {
        return String.format("Imatge de %dx%d pixels", width,height);
    }
}
