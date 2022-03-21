public class ConvertRomans
{
    public ConvertRomans()
    {

    }
    public String numerosRomanos(int numero)
    {

        int i, miles, centenas, decenas, unidades;
        String romano = "";

        miles = numero / 1000;
        centenas = (numero / 100) % 10;
        decenas = (numero / 10) % 10;
        unidades = numero % 10;

        for (i = 1; i <= miles; i++) romano += "M";

        switch (centenas)
        {
            case 9 -> romano += "CM";
            case 5, 6, 7, 8 -> {
                romano += "D";
                for (i = 6; i <= centenas; i++) romano += "C";
            }
            case 4 -> romano += "CD";
            default -> {
                for (i = 1; i <= centenas; i++) romano += "C";
            }
        }

        switch (decenas)
        {
            case 9 -> romano += "XC";
            case 5, 6, 7, 8 -> {
                romano += "L";
                for (i = 6; i <= decenas; i++) romano += "X";
            }
            case 4 -> romano += "XL";
            default -> {
                for (i = 1; i <= decenas; i++) romano += "X";
            }
        }

        switch (unidades)
        {
            case 9 -> romano += "IX";
            case 5, 6, 7, 8 -> {
                romano += "V";
                for (i = 6; i <= unidades; i++) romano += "I";
            }
            case 4 -> romano += "IV";
            default -> {
                for (i = 1; i <= unidades; i++) romano += "I";
            }
        }

        return  romano;
    }
}
/*   Codigo sacado de clase */