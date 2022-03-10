
public class Spiroline
{
    public static final int RADIO = 100;
    private static final int SAMPLES = 400;
    private static double delta = 2.0 * Math.PI / SAMPLES;
    private static boolean color = true;
    private int factor;

    public Spiroline(int factor)
    {
        this.factor = factor;
    }

    public CalculatedLine[] calculateSpiroline()
    {
        CalculatedLine[] result = new CalculatedLine[SAMPLES];
        for (int p = 0; p < SAMPLES; p++)
        {
            double alfa = p * delta;
            double x1 = RADIO * Math.cos(alfa);
            double y1 = RADIO * Math.sin(alfa);
            double beta = ((p * factor) % SAMPLES) * delta;
            double x2 = RADIO * Math.cos(beta);
            double y2 = RADIO * Math.sin(beta);

            CalculatedLine newCalculatedLine = new CalculatedLine(alfa, x1, y1, beta, x2, y2);
            result[p] = newCalculatedLine;
        }

        return result;
    }
}
