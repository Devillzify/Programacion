package Pildoras;

public class Furgoneta extends Coche
{
    private int capacidad_carga;
    private int plazas_extra;

    public Furgoneta(int plazas_extra,int capacidad_carga)
    {
        super();  // llamar al counstructor Coche

        this.capacidad_carga = capacidad_carga;
        this.plazas_extra = plazas_extra;
    }
}
