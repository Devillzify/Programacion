package Principiante;

public class bidimensionales
{
    public static void main(String[] args)
    {

        int [][] array = new int [4][5];

        array[0][0]= 15;
        array[0][1]= 21;
        array[0][2]= 18;
        array[0][3]= 9;
        array[0][4]= 15;

        array[1][0]= 10;
        array[1][1]= 52;
        array[1][2]= 17;
        array[1][3]= 19;
        array[1][4]= 7;

        array[2][0]= 19;
        array[2][1]= 2;
        array[2][2]= 19;
        array[2][3]= 17;
        array[2][4]= 7;

        array[3][0]= 92;
        array[3][1]= 13;
        array[3][2]= 13;
        array[3][3]= 32;
        array[3][4]= 41;


      for(int i = 0; i < 4; i++)
      {
          for(int j = 0; j < 5; j++)
          {
              System.out.println("en la posicion I =  " + i + " y en la J = " + j + " da el resultado " +  array[i][j]);
          }
          System.out.println();
      }
    }
}
