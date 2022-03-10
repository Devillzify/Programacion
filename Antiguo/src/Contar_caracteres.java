package Principiante;

public class Contar_caracteres
{

    public static void main(String[] args)
    {
        String frase = "la letra mas usada en esta frase es"; // frase
        int letras = 0;  // variable del numero de veces que sale la letra
        char letra = 'a'; // variable para la posicion de charAt(i)
        int max = 0; // variable para sacar el mas grande
        char letramax = '@'; // variable para la letra



        for (int i = 0; i < frase.length(); i++)// recorre posicion de letras
        {

            letras = 0; //reinicia el contador
            letra = frase.charAt(i); // indica la letra de la posicion



            for(int j = 0; j < frase.length(); j++) // recorre de nuevo el String y dice cuantas veces sale la letra de la posicion que tiene el primer bucle
            {
                if(letra==frase.charAt(j))
                {
                    letras++;  // cuando acaba el bucle suma 1 al bucle primero  y pasa de la posicion 0 que es la L a la posicion 1 que es a
                }

            }
            if (letras > max) // si letras es mayor que max, que max es 0 entonces pasamos a los cambios
            {
                max = letras; // mas sera igual a letras, y letras es igual al numero de veces que sale: es decir, si la l sale 2 veces y la i sale 5, se queda con max = 5
                letramax = letra; // si se cumple la condicion letras > max se cambia la letra por esa
            }
        }

        System.out.println("la que mas sale es " + letramax + " y sale " + max);


    }
}

