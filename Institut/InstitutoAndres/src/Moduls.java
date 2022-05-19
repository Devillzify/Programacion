
public class Moduls
{
    private boolean Programacion;
    private boolean Base_de_datos;
    private boolean Entorns;
    private boolean Fol;
    private boolean llenguatges;


    public Moduls(boolean Programacion,boolean Base_de_Datos,boolean Entorns,boolean fol, boolean llenguatges)
    {
     this.Programacion = Programacion;
     this.Base_de_datos = Base_de_Datos;
     this.Entorns = Entorns;
     this.Fol = fol;
     this.llenguatges = llenguatges;
    }

    public boolean isProgramacion()
    {
        return Programacion;
    }

    public void setProgramacion(boolean programacion)
    {
        Programacion = programacion;
    }

    public boolean isBase_de_datos()
    {
        return Base_de_datos;
    }

    public void setBase_de_datos(boolean base_de_datos)
    {
        Base_de_datos = base_de_datos;
    }

    public boolean isEntorns()
    {
        return Entorns;
    }

    public void setEntorns(boolean entorns)
    {
        Entorns = entorns;
    }

    public boolean isFol()
    {
        return Fol;
    }

    public void setFol(boolean fol)
    {
        Fol = fol;
    }

    public boolean isLlenguatges()
    {
        return llenguatges;
    }

    public void setLlenguatges(boolean llenguatges)
    {
        this.llenguatges = llenguatges;
    }

    @Override
    public String toString()
    {
        return "Moduls{" +
                "Programacion=" + Programacion +
                ", Base_de_datos=" + Base_de_datos +
                ", Entorns=" + Entorns +
                ", Fol=" + Fol +
                ", llenguatges=" + llenguatges +
                '}';
    }
}
