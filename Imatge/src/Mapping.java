import java.util.stream.IntStream;

public class Mapping
{
    double[] result;

    public Mapping(double start, double stop, int steps)
    {
        double gap = (stop - start) / (steps - 1.0);

        result = IntStream.range(0, steps).mapToDouble(t -> start + t * gap).toArray();
    }

    public Mapping(double start, double stop, int steps, int samples)
    {
        double gap = (stop - start) / (steps - 1.0);
        double smallGap = gap / samples;

        double newStart = start - (gap - smallGap) / 2.0;

        result = IntStream.range(0, steps * samples).mapToDouble(t -> newStart + t * smallGap).toArray();
    }
}