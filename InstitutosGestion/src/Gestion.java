import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion
{
    String[] nombresModulos =
            {
                    "Database management",
                    "Entorns de desenvolupament",
                    "Fonaments de maquinari",
                    "Formació i orientació laboral",
                    "Implantació de sistemes operatius",
                    "Llenguatges de marques",
                    "Planificació i administració de xarxes",
                    "Programació",
                    "Sistemes informàtics"
            };

    List<Modulo> mLista = new ArrayList<>();
    List<Alumno> aLista = new ArrayList<>();
    List<Profesor> pLista = new ArrayList<>();

    File mFile = new File("modulos.pcn");
    File aFile = new File("alumnos.pcn");
    File pFile = new File("profesores.pcn");

    public Gestion()
    {
        if (!mFile.exists())
            crearModulos();
        else
            leerModulos();
        showList();
    }

    private void crearModulos()
    {
        for (int m = 0; m < nombresModulos.length; m++)
            mLista.add(new Modulo("m" + m, nombresModulos[m]));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(mFile)))
        {
            salida.writeObject(mLista);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void leerModulos()
    {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(mFile)))
        {
            mLista = (List<Modulo>) entrada.readObject();
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void showList()
    {
        for (Modulo m : mLista)
            System.out.format("%s - %s\n", m.id, m.name);
    }

    public static void main(String[] args)
    {
        new Gestion();
    }
}