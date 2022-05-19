import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Imatge
{
    int width, height;

    double xcenter = 0.0;
    double ycenter = 0.0;

    double zoom = 1.0;

    int samples = 13;
    double[] xrange, yrange;

    BufferedImage imatge = null;
    WritableRaster raster;

    public Imatge(int width, int height)
    {
        this.width = width;
        this.height = height;

        imatge = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        raster = imatge.getRaster();
    }

    public Imatge(int width, int height, double xcenter, double ycenter, double zoom)
    {
        this(width, height);

        this.xcenter = xcenter;
        this.ycenter = ycenter;
        this.zoom = zoom;
    }

    public void process()
    {
        startUp();
        content();
        endUp();
    }

    private void startUp()
    {
        double aspect;
        double radio = 1.0 / zoom;
        double xstart, xstop;
        double ystart, ystop;

        if (width > height)
        {
            aspect = (double) width / (double) height;
            xstart = xcenter - radio * aspect;
            xstop = xcenter + radio * aspect;
            ystart = ycenter + radio;
            ystop = ycenter - radio;
        }
        else
        {
            aspect = (double) height / (double) width;
            xstart = xcenter - radio;
            xstop = xcenter + radio;
            ystart = ycenter + radio * aspect;
            ystop = ycenter - radio * aspect;
        }

        xrange = new Mapping(xstart, xstop, width, samples).result;
        yrange = new Mapping(ystart, ystop, height, samples).result;
    }

    private void endUp()
    {
        try
        {
            ImageIO.write(imatge, "PNG", new File("imatge.png"));
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void content()
    {
        Color c1 = new Color(1.0, 0.0, 0.0);
        Color c2 = new Color(1.0, 1.0, 1.0);

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                Color k = new Color(0.0, 0.0, 0.0);

                for (int yy = 0; yy < samples; yy++)
                {
                    double cy = yrange[y * samples + yy];
                    for (int xx = 0; xx < samples; xx++)
                    {
                        double cx = xrange[x * samples + xx];

                        Color c = colores(cx, cy, c1, c2);
                        k = Color.add(k, c);
                    }
                }
                k = Color.times(1.0 / (samples * samples), k);
                raster.setPixel(x, y, k.toArray());
            }
        }
    }

    private Color colores(double x, double y, Color c1, Color c2)
    {
        double z1 = Math.sqrt((x - 1.0) * (x - 1.0) + (y - 0.0) * (y - 0.0));
        double z2 = Math.sqrt((x + 1.0) * (x + 1.0) + (y - 0.0) * (y - 0.0));

        double z = Math.min(z1, z2);

        if ((z1 < 2.0) && (z2 < 2.0)) return c1;
        if (z < 2.0) return Color.times(0.5, c1);
        return c2;
    }
}