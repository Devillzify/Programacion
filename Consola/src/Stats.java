package Consola;

public class Stats
{
    private int vida;
    private int defensa;
    private int ataque;


    public Stats(int vida, int defensa, int ataque)
    {
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getDefensa()
    {
        return defensa;
    }

    public void setDefensa(int defensa)
    {
        this.defensa = defensa;
    }

    public int getAtaque()
    {
        return ataque;
    }

    public void setAtaque(int ataque)
    {
        this.ataque = ataque;
    }

    @Override
    public String toString()
    {
        return "Stats{" +
                "vida=" + vida +
                ", defensa=" + defensa +
                ", ataque=" + ataque +
                '}';
    }
}
