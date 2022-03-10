

import java.io.PrintWriter;

public class SpirolineRenderer
{

    private static final int VBWIDTH = Spiroline.RADIO + 5;
    private static final int VBHEIGHT = Spiroline.RADIO + 5;
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 1024;
    private PrintWriter pw;
    private static boolean color = true;

    private void openSvg(){
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        pw.print("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
        pw.print("xmlns:xlink=\"http://www.w3.org/1999/xlink\" ");
        pw.format("viewBox=\"%d %d %d %d\" ", -VBWIDTH, -VBHEIGHT, VBWIDTH << 1, VBHEIGHT << 1);
        pw.format("width=\"%d\" height=\"%d\">\n", WIDTH, HEIGHT);
    }

    private void openGeometry(){
        pw.println("<rect x=\"-50%\" y=\"-50%\" width=\"100%\" height=\"100%\" fill=\"black\"/>");
        pw.println("<g fill=\"none\" stroke-width=\"0.2\" transform=\"rotate(-90)\">");
    }

    private void closeSvg(){
        pw.println("</svg>");
        pw.close();
    }

    public void renderCalculatedSpirolines(CalculatedLine[] calculatedLines, int number){
        initiatePrintWriter("Spiroline" + number + ".svg");
        openSvg();
        openGeometry();

        for (int i = 0; i < calculatedLines.length; i++){

            if (color)
                pw.format("<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"hsl(%f,100%%,50%%)\"/>\n", calculatedLines[i].getX1(), calculatedLines[i].getY1(), calculatedLines[i].getX2(), calculatedLines[i].getY2(), Math.toDegrees(calculatedLines[i].getAlfa()));
            else
                pw.format("<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"#5af\"/>\n", calculatedLines[i].getX1(), calculatedLines[i].getY1(), calculatedLines[i].getX2(), calculatedLines[i].getY2());
        }
        closeGeometry();
        closeSvg();
    }
    private void closeGeometry(){
        pw.format("<circle r=\"%d\" stroke=\"#666\"/>\n", Spiroline.RADIO);

        pw.println("</g>");
    }
    private void initiatePrintWriter(String nomArxiu){
        try
        {
            pw = new PrintWriter(nomArxiu);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
