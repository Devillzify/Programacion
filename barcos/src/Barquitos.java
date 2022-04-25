public class Barquitos
{
    int[][] barquitos = new int[5][5];

    public Barquitos()
    {

    }


    private void setfalse()
    {
        for(int i = 0; i <= 4; i++)
        {
            for(int j = 0; j <= 4; j++)
            {
                barquitos[i][j] = 0;
            }
        }
    }

    private void setTrueBoat(int o, int p)
    {
        for(int k = 0; k <= 5; k++)
        {
            for(int l = 0; l <= 5; l++)
            {
                barquitos [o][p] = 1;
            }
        }
    }

    private void printBoat()
    {
        for (int i = 0; i <= 4; i++)
        {
            for (int j = 0; j <= 4;j++)
            {
                System.out.print(barquitos[i][j]);
                if(j == 4)
                {
                    System.out.println("");
                }
            }
        }
    }

    public void menuBarco()
    {
        int opciones = -1;

        while(opciones != 0)
        {
            switch (opciones)
            {
                case 1:

            }
        }
    }

    public static void main(String[] args)
    {
        Barquitos b = new Barquitos();
        b.setTrueBoat(3,2);
        b.printBoat();
    }


}
