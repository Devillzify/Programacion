package POO;

public class coche
{
    private int ruedas;

    private int largo;

    private int ancho;

    private int motor;

    private int peso_base;

    private String color;

    private int peso_total;

    private boolean asientos_cuero, climatizador;

    public coche()
    {
        ruedas = 4;

        largo = 2000;

        ancho = 300;

        motor = 1600;

        peso_base = 500;
    }
    public String datos_generales()
    {
        return " la plataforma del vehiculo tiene " + ruedas + " ruedas"
                + " mide de largo" + largo/1000 + " metros con un ancho de " + ancho + " cm y un peso de plataforma de " + peso_base + " kg";
    }


    public void establece_color(String color_coche) //setter
    {
      color = color_coche;
    }


    public String dime_color() // getter
    {
        return " el color del coche es " + color;
    }

    public void configura_asientos(String asientos_cuero) // setter
    {
        if(asientos_cuero.equalsIgnoreCase("si") )
        {
            this.asientos_cuero = true;
        }
        else
        {
            this.asientos_cuero = false;
        }
    }

    public String dime_asientos() // getter
    {
        if(asientos_cuero == true)
        {
            return " tiene asientos de cuero";
        }
        else
        {
            return " no tiene asientos de cuero";
        }
    }

    public void configura_climatizador(String climatizador) // setter
    {
        if(climatizador.equalsIgnoreCase("si"))
        {
            this.climatizador = true;
        }
        else
        {
            this.climatizador = false;
        }
    }

    public String dime_climatizador() //getter
    {
        if(climatizador = true)
        {
            return " el coche tiene climatizador";
        }
        else
        {
            return " el coche tiene aire acondicionado";
        }
    }

    public String dime_peso_coche() // setter + getter
    {
        int peso_carroceria = 500;

        peso_total = peso_base + peso_carroceria;

        if(asientos_cuero == true)
        {
            peso_total = peso_total + 50;
        }
        if(climatizador == true)
        {
            peso_total = peso_total + 20;
        }

        return " el peso del coche es " + peso_total + " kg";
    }

    public int precio_coche() // getter
    {
        int precio_final = 10000;

        if(asientos_cuero == true)
        {
            precio_final += 2000;
        }
        if(climatizador == true)
        {
            precio_final += 1500;
        }
        return precio_final;
    }


}
