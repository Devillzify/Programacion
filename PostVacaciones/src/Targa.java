import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Targa
{
    int width, height;
    String filename;

    double xcenter = 0.0;
    double ycenter = 0.0;

    double zoom = 1.0;

    double[] xrange, yrange;

    public Targa(int width, int height, String filename)
    {
        this.width = width;
        this.height = height;
        this.filename = filename;

        process();
    }

    public Targa(int width, int height, String filename, double xcenter, double ycenter, double zoom)
    {
        this.width = width;
        this.height = height;
        this.filename = filename;

        this.xcenter = xcenter;
        this.ycenter = ycenter;

        this.zoom = zoom;

        process();
    }

    public void process()
    {
        startUp();
        try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(filename)))
        {
            header(fos);
            content(fos);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void header(OutputStream fos) throws IOException
    {
        byte[] header = {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 66, 77, 77, 24, 0x20}; // el 3 numero indica el color
// el 24 son los bits
        header[12] = (byte) (width & 0xFF);
        header[13] = (byte) ((width >> 8) & 0xFF);

        header[14] = (byte) (height & 0xFF);
        header[15] = (byte) ((height >> 8) & 0xFF);

        fos.write(header);
    }

    private void startUp()
    {
        double aspect = (double) width / (double) height;
        double radio = 1.0 / zoom;
        double xstart, xstop;
        double ystart, ystop;

        if (width > height)
        {
            xstart = xcenter - radio * aspect;
            xstop = xcenter + radio * aspect;
            ystart = ycenter + radio;
            ystop = ycenter - radio;
        }
        else
        {
            xstart = xcenter - radio;
            xstop = xcenter + radio;
            ystart = ycenter + radio * aspect;
            ystop = ycenter - radio * aspect;
        }

        xrange = new Mapping(xstart, xstop, width).result;
        yrange = new Mapping(ystart, ystop, height).result;
    }

    private void content(OutputStream fos) throws IOException
    {
        Color c1 = new Color(1.0, 1.0, 0.0);
        Color c2 = new Color(0.0, 0.0, 1.0);

        for (double y: yrange)
            for (double x: xrange)
                fos.write(colores(x, y, c1, c2).toBGR());
    }

    private Color colores(double x, double y, Color c1, Color c2)
    {
        double z = Math.sqrt(x * x + y * y);

        z = Math.floor(Math.toDegrees(z) / 2.0);

        double t = 0.5 + Math.sin(z) / 2.0;

        return Color.add(c1, Color.times(t, Color.sub(c2, c1)));
    }
}