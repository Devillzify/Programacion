package Principiante;

public class Reduir
{
    public static void main(String[] args)
    {
        String numerodado = args[0]; // pedimos el numero
        if(args.length != 1)
        {
            System.out.println(" solo un conjunto de numeros");
            System.exit(1);
        }
        while (numerodado.length() > 1) // cuando haya mas de 1 numero sigue
        {
            int resultado = 0;// nueva variable
            for (int i = 0; i < numerodado.length(); i++) // recorre numero por numero
            {
                int lugar = Integer.parseInt(numerodado.charAt(i) + ""); // el sitio donde esta
                resultado += lugar;

                String suma = " + "; // metemos el + detras del numero
                System.out.print(lugar + suma);//metemos la posicion + el signo +
            }
            System.out.println(" = " + resultado + " ");
            numerodado = resultado + ""; // cambiamos la variable por el resultado
        }
    }
}






