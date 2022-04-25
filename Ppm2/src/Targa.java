import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Targa
{
    int width, height;
    String filename;

    public Targa(int width, int height, String filename)
    {
        this.width = width;
        this.height = height;
        this.filename = filename;
    }

    public void process()
    {
        try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(filename)))
        {
            header(fos);
            //content();
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }



    private void writeByte(int n, OutputStream os) throws IOException
    {
        os.write(n);
    }

    private void writeShort(int n, OutputStream os) throws IOException
    {
        os.write(n);
        os.write(n >> 8);
    }

    private void writeInt(int n, OutputStream os) throws IOException
    {
        os.write(n);
        os.write(n >> 8);
        os.write(n >> 16);
        os.write(n >> 24);
    }

    int idLength = 0;
    int colourMapType = 0;
    int dataTypeCode = 2;
    int colourMapOrigin = 0;
    int colourMapLength = 0;
    int colourMapDepth = 0;
    int xOrigin = 0;
    int yOrigin = 0;
    int bitsPerPixel = 24;
    int imageDescriptor = 0x20;

    private void header(OutputStream os) throws IOException
    {
        writeByte(idLength, os);
        writeByte(colourMapType, os);
        writeByte(dataTypeCode, os);
        writeShort(colourMapOrigin, os);
        writeShort(colourMapLength, os);
        writeByte(colourMapDepth, os);
        writeShort(xOrigin, os);
        writeShort(yOrigin, os);
        writeShort(width, os);
        writeShort(height, os);
        writeByte(bitsPerPixel, os);
        writeByte(imageDescriptor, os);
    }

    private void headerBytes(OutputStream os) throws IOException
    {
        byte[] header = {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 66, 77, 77, 24, 0x20};

        header[12] = (byte) (width & 0xFF);
        header[13] = (byte) ((width >> 8) & 0xFF);

        header[14] = (byte) (height & 0xFF);
        header[15] = (byte) ((height >> 8) & 0xFF);

        os.write(header);
    }
}