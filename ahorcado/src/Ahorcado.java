package ahorcado;

import java.util.Scanner;

public class Ahorcado
{
    static String[] palabras = {"skate","ordenador","paraguas","estropajo","nintendo"};
    static int vidas = 5;
    static boolean[] adivinadas;
    static String palabra;
    static Scanner input = new Scanner(System.in);



    public static String randomWord()
    {
        int random = (int)Math.floor(Math.random() * palabras.length) ;
        return palabras[random];
    }

     public static void ocultar()
    {
       adivinadas = new boolean[palabra.length()];
       for(int i = 0; i < palabra.length(); i++)
       {
           adivinadas[i] = false;
       }
    }

    public static void pintarPalabra()
    {
        for(int i = 0; i < palabra.length(); i++)
        {
            if(adivinadas[i])
            {
                System.out.print(palabra.charAt(i) + " ");
            }
            else
            {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }






    public static void main(String[] args)
    {
        palabra = randomWord();
        ocultar();
        pintarPalabra();
       while(vidas > 0)
       {

           System.out.println("Introduce una letra.\nte quedan " + vidas + " vidas");
           String letraIntroducida = input.nextLine();
           if(letraIntroducida.length() != 1)
           {
               System.out.println("Introduce un solo caracter");
               continue;
           }
           if(verificarLetra(letraIntroducida))
           {
               System.out.println("Has adivinado la letra");
           }
           else
           {
               vidas -= 1;
               System.out.println("Has fallado");
           }
           pintarPalabra();
           if(victoria())
           {
               System.out.println("Has ganado");
               System.exit(1);
           }
       }
        System.out.println("Has perdido");

    }

    private static boolean victoria()
    {
        for(int i = 0; i < adivinadas.length;i++)
        {
            if(!adivinadas[i])
            {
                return false;
            }
        }
        return true;
    }

    private static boolean verificarLetra(String letra)
    {
        boolean letraEncontrada = false;

        for(int i = 0; i < palabra.length(); i++)
        {
          if(letra.charAt(0) == palabra.charAt(i))
          {
              adivinadas[i] = true;
              letraEncontrada = true;
          }
        }
        return letraEncontrada;
    }

}
