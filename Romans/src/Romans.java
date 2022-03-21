

public class Romans
{
    public static void main(String[] args)
    {
        Scannerutils sc = new Scannerutils();

        ConvertRomans romans = new ConvertRomans();
        int numero = sc.showMessageAndGetInt("Introduce un numero entre 1 y 3999");
        String romano = romans.numerosRomanos(numero);
        System.out.println("el numero " + numero + " Convertido a romano es: " + romano );

        ConvertArabic arabic = new ConvertArabic();
        String roman = sc.showMessageAndGetRoman("Introduce el numero Romano");
        int arabico = arabic.romanToDecimal(roman);
        System.out.println("El numero Romano " + roman + " En formato arabico es: " + arabico);
    }
}