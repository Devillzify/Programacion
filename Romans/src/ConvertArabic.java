public class ConvertArabic
{
    public ConvertArabic()
    {

    }

    public int value(char r)
    {                            // la logica al transformar un numero romano a un numero entero es que si el valor de la letra es menor que la que tiene a su derecha ese valor pasa a ser una resta
        if (r == 'I')            //me he informado de como se hace, dado que al desconocer el como se hace a papel o  de cabeza me era imposible pasar el projecto a java
            return 1;            // he obtenido toda la teoria de la pagina esta https://www.matesfacil.com/ESO/sistemas-numeracion/sistema-romano/sistema-numeracion-romano-alfabeto-teoria-ejemplos-ejercicios-resueltos-numeros-cambio.html
        if (r == 'V')            // aunque el ejercicio es de internet
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public int romanToDecimal(String romano)
    {
        int resultadoentero = 0;

        for (int i = 0; i < romano.length(); i++)
        {
            int s1 = value(romano.charAt(i));

            if (i + 1 < romano.length())
            {
                int s2 = value(romano.charAt(i + 1));

                if (s1 >= s2)
                {
                    resultadoentero = resultadoentero + s1;
                }
                else
                {
                    resultadoentero = resultadoentero + s2 - s1;
                    i++;
                }
            }
            else {
                resultadoentero = resultadoentero + s1;
            }
        }
        return resultadoentero;
    }
}
/*     Codigo sacado de internet      */