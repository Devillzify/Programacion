import java.util.Arrays;

public class Alumno extends Persona
{
    private Moduls moduls;

    public Alumno(String dni, String nom,Moduls assignaturas)
    {
        super(dni, nom);
        this.moduls = assignaturas;
    }

    public Moduls getModuls()
    {
        return moduls;
    }

    public void setModuls(Moduls moduls)
    {
        this.moduls = moduls;
    }

    @Override
    public String toString()
    {
        return "Alumno: " + nom +" "+ "dni: " + dni + " " + "\n" +
                "moduls=" + moduls ;
    }

}
