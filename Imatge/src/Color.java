public class Color
{
    double r, g, b;

    public Color(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(int r, int g, int b)
    {
        this.r = (double) r / 255.0;
        this.g = (double) g / 255.0;
        this.b = (double) b / 255.0;
    }

    public static Color add(Color p, Color q)
    {
        return new Color(p.r + q.r, p.g + q.g, p.b + q.b);
    }

    public static Color sub(Color p, Color q)
    {
        return new Color(p.r - q.r, p.g - q.g, p.b - q.b);
    }

    public static Color times(double t, Color q)
    {
        return new Color(t * q.r, t * q.g, t * q.b);
    }

    public byte[] toRGB()
    {
        byte r = (byte) Math.floor(255.0 * this.r + 0.5);
        byte g = (byte) Math.floor(255.0 * this.g + 0.5);
        byte b = (byte) Math.floor(255.0 * this.b + 0.5);

        return new byte[]{r, g, b};
    }

    public byte[] toBGR()
    {
        byte r = (byte) Math.floor(255.0 * this.b + 0.5);
        byte g = (byte) Math.floor(255.0 * this.g + 0.5);
        byte b = (byte) Math.floor(255.0 * this.r + 0.5);

        return new byte[]{r, g, b};
    }

    public double[] toArray()
    {
        return new double[]{255.0 * r, 255.0 * g, 255.0 * b};
    }
}