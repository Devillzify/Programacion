public class Profesor extends Persona
{
    private Moduls Moduls;
    private int sueldo;

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public Profesor(String dni, String nom,int sueldo,Moduls moduls)
    {
        super(dni, nom);
        this.Moduls = moduls;
        this.sueldo = sueldo;
    }


    public Moduls getModuls()
    {
        return Moduls;
    }

    public void setModuls(Moduls moduls)
    {
        this.Moduls = moduls;
    }

    public int getSueldo()
    {
        return sueldo;
    }

    public void setSueldo(int sueldo)
    {
        this.sueldo = sueldo;
    }

    @Override
    public String toString()
    {
        return "Profesor{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' + "sueldo: " + sueldo + "\n" +
                "Moduls=" + Moduls;
    }
}
