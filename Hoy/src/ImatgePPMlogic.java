import java.io.PrintWriter;
/*
El ejercicio una vez que he practicado creando imagenes pequeñas a mano, ya que es una matada hacerlo a mano
he entendido que al crear columnas y filas se basa en la cabecera, al poner P3 luego ponemos el numero de filas y columnas
que se van a crear, junto a otro parametro que es la  cantidad de color aceptado, en este caso he puesto 255 porque es
lo generico que encontre por internet, dado que he tenido que buscar informacion para entender como funciona.
luego solo es poner los colores de los pixeles, que son 3x3 valores en caso de rgb.
Hay tamaños que rompen la imagen, no he conseguido arreglar eso, aunque he estado probando y solo he pensado la manera
de hacer que salga siempre bien haciendo multiples, porque al poner por ejemplo un numero grandes x uno pequeño y luego cambiar
el tamaño del pixel la imagen se deforma, existe la posibilidad de arreglarlo poniendo un tamaño pixel adequado a la
anchura y altura, pero entonces ya no seria full personalizable como pide el ejercicio, asi que lo he dejado de eleccion libre
Como siempre programa incluye un ScannerUtils custom al que solo tengo que hacerle el control de errores, de tal manera
que no tenga problemas al pedir informacion.

en este necesitamos saber los parametros de los pixeles de altura y ancho y despues de cuantos pixeles va a a estar formado
cada cuadrado, para asi saber cuando hacer el cambio de color, desde mi ignorancia dire que perdi 1 hora mirando como cambiar
el tamaño de los pixeles, hasta que encontre que no se cambia el tamaño de los pixeles, sino que se crea un conjunto de pixeles
formando un cuadrado y de ahi sale el ejercicio este.

El booleano se utiliza para saber que pixels se pintan de negro y que pixels se pintan de un color y que pixels de otro.

He estado pensando en una formula que al poner la altura por ancho y poner un tamaño de pixel se reescale el tamaño del pixel a
lo mas cercado posible de un multiple, pero no he conseguido esa opcion. la manera simple seria hacer que la altura y ancho sean
iguales o multiples del tamaño del ancho del pixel, pero lo dicho, asi ya no se podria cambiar cada parametro al gusto.
 */


public class ImatgePPMlogic
{
    public String color2 = "0 0 0 ";
    public String color1 = "255 255 255 ";
    public int ancho = 400;
    public int altura = 320;
    public int cuadradotam = 10;
    boolean color = true;

    public ImatgePPMlogic()
    {

    }


    private void setColor(int index)
    {
        if (index % cuadradotam == 0)
        {
            color = !color;
        }
    }

    public void setAncho(int anchura)
    {
        this.ancho = anchura;
    }

    public void setAltura(int alto)
    {
        this.altura = alto;
    }

    public void setAnchocuadrado(int cuadradopixel)
    {
        this.cuadradotam = cuadradopixel;
    }

    public void setColor1(String colornuevo)
    {
        this.color1 = colornuevo;
    }

    public void setColor2(String colornuevo2)
    {
        this.color2 = colornuevo2;
    }

    public void menu()
    {
        Scannerutils sc = new Scannerutils();
        ImatgePPMlogic im = new ImatgePPMlogic();

        int opcion = -1;
        int opcion2 = -1;
        do
        {
            opcion = sc.showMessageAndGetIntmenu("1-- Cambiar altura y ancho \n2-- Cambiar altura, ancho y pixeles del cuadrado\n3-- Cambiar Altura, ancho, pixeles del cuadrado y color1\n4-- Cambiar Altura, ancho, pixeles del cuadrado, color1 y color2\n5-- Por defecto\n6-- Cambiar valor individual\n0-- Terminar creacion");
            switch (opcion)
            {
                case 1:
                    im.setAncho(sc.showMessageAndGetInt("introduce el ancho"));
                    im.setAltura(sc.showMessageAndGetInt("introduce la altura"));
                    im.crearPPM();
                    break;

                case 2:
                    im.setAncho(sc.showMessageAndGetInt("introduce el ancho"));
                    im.setAltura(sc.showMessageAndGetInt("introduce la altura"));
                    im.setAnchocuadrado(sc.showMessageAndGetInt("introduce los pixeles del cuadrado"));
                    im.crearPPM();
                    break;
                case 3:
                    im.setAncho(sc.showMessageAndGetInt("introduce el ancho"));
                    im.setAltura(sc.showMessageAndGetInt("introduce la altura"));
                    im.setAnchocuadrado(sc.showMessageAndGetInt("introduce los pixeles del cuadrado"));
                    im.setColor2(sc.showMessageAndGetColor("introduce el nuevo color"));
                    im.crearPPM();
                    break;
                case 4:
                    im.setAncho(sc.showMessageAndGetInt("introduce el ancho"));
                    im.setAltura(sc.showMessageAndGetInt("introduce la altura"));
                    im.setAnchocuadrado(sc.showMessageAndGetInt("introduce los pixeles del cuadrado"));
                    im.setColor1(sc.showMessageAndGetColor("introduce el nuevo color1"));
                    im.setColor2(sc.showMessageAndGetColor("introduce el nuevo color2"));
                    im.crearPPM();
                    break;
                case 5:
                    im.setAncho(400);
                    im.setAltura(320);
                    im.setAnchocuadrado(10);
                    im.setColor1("255 255 255 ");
                    im.setColor2("000 000 000 ");
                    im.crearPPM();
                    break;
                case 6:
                    do
                    {
                        opcion2 = sc.showMessageAndGetIntmenudos("1-- Cambiar ancho\n2-- Cambiar altura\n3-- Cambiar tamaño de cuadrado\n4-- Cambiar color 1\n5-- Cambiar color 2\n0-- Salir");
                        switch (opcion2)
                        {
                            case 1:
                                im.setAncho(sc.showMessageAndGetInt("introduce el ancho"));
                                break;
                            case 2:
                                im.setAltura(sc.showMessageAndGetInt("introduce la altura"));
                                break;
                            case 3:
                                im.setAnchocuadrado(sc.showMessageAndGetInt("introduce el tamaño del cuadro"));
                                break;
                            case 4:
                                im.setColor1(sc.showMessageAndGetColor("introduce el color primario deseado"));
                                break;
                            case 5:
                                im.setColor2(sc.showMessageAndGetColor("introduce el color secundario deseado"));
                                break;
                        }
                        im.crearPPM();
                    }
                    while (opcion2 != 0);
            }
        }
        while (opcion != 0);
    }

    public void crearPPM()
    {
        try
        {
            PrintWriter pw = new PrintWriter("imatge.ppm");
            String cabezera = "P3\n" + ancho + " " + altura + "\n255\n";
            pw.print(cabezera);
            for (int i = 0; i < altura; i++)
            {
                setColor(i);
                for (int j = 0; j < ancho; j++)
                {
                    setColor(j);
                    if (color)
                    {
                        pw.print(color1);
                    }
                    else
                    {
                        pw.print(color2);
                    }
                }
            }
            pw.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
