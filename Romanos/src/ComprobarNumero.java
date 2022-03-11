public class ComprobarNumero
{
    public ComprobarNumero(int numero)
    {
        if (numero < 1 || numero > 3999)
        {
            System.out.println("Error: Introduce un numero entre 1 y 3999");
            System.exit(6);
        }
        else
        {
            System.out.println(numero + " Convertido a Romanos es --> " + ConvertirRomanos.convertirANumerosRomanos(numero));

        }
    }
}
