import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Tga
{
    int width, height;

    public Tga(String filename, int width, int height)
    {
        this.width = width;
        this.height = height;

        try (OutputStream image = new BufferedOutputStream(new FileOutputStream(filename)))
        {
            header(image);
            content(image);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void header(OutputStream output) throws IOException
    {
        output.write(String.format("P6\n%d %d\n255\n", width, height).getBytes());
    }

    private void content(OutputStream output) throws IOException
    {
        for (int h = 0; h < height; h++)
            for (int w = 0; w < width; w++)
            {
                output.write(0xCC);
                output.write(0x00);
                output.write(0x00);
            }
    }
}