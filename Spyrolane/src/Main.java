
import java.util.Locale;

public class Main
{
    static SpirolineRenderer renderer = new SpirolineRenderer();

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ROOT);

        for (int i = 2; i < 20; i++)
        {

           Spiroline piroline = new Spiroline(i);
           CalculatedLine[] calculatedLines = piroline.calculateSpiroline();
           renderer.renderCalculatedSpirolines(calculatedLines,i);

        }
    }
}
