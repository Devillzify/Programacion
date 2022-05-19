import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.prefs.PreferencesFactory;

public class Gestion
{
    String[] nombresModulos =
            {
                    "Database management",
                    "Entorns de desenvolupament",
                    "Fonaments de maquinari",
                    "Formacio i orientacio laboral",
                    "Implantacio de sistemes operatius",
                    "Llenguatges de marques",
                    "Planificacio i administracio de xarxes",
                    "Programacio",
                    "Sistemes informatics"
            };

    String[] nombreAlumnos =
            {
                    "jose luis",
                    "alberto lara",
                    "yisus crist",
                    "azar suertes",
                    "tic tac",
                    "toc tuc",
                    "toni marmol",
                    "miguel frafra",
                    "nuria lopez"
            };

    String[] nombreProfesor =
            {
                    "pedro campos",
                    "clara oscura",
                    "alicia bases",
                    "fol odios",
                    "jaume toc",
                    "kley zas",
                    "lopp mir",
                    "cryu jume"
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
        {
            crearModulos();
            crearAlumno();
            crearProfesor();
        } else
        {
            leerModulos();
            leerAlumnos();
            leerProfesor();
        }
        // showList();
    }

    private void crearModulos()
    {
        for (int m = 0; m < nombresModulos.length; m++)
            mLista.add(new Modulo("m" + m, nombresModulos[m]));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(mFile)))
        {
            salida.writeObject(mLista);
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void crearProfesor()
    {
        for (int p = 0; p < nombreProfesor.length; p++)
        {
                pLista.add(new Profesor("p" + p, nombreProfesor[p], "m" + p));
        }
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(pFile)))
        {
            salida.writeObject(pLista);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }


    private void crearAlumno()
    {
        for (int a = 0; a < nombreAlumnos.length; a++)
            if (a % 2 == 0)
            {
                aLista.add(new Alumno("a" + a, nombreAlumnos[a], "m0", "m1", "m2", "m3"));
            } else
            {
                aLista.add(new Alumno("a" + a, nombreAlumnos[a], "m4", "m5", "m6", "m7", "m8"));
            }

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(aFile)))
        {
            salida.writeObject(aLista);
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void leerModulos()
    {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(mFile)))
        {
            mLista = (List<Modulo>) entrada.readObject();
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }


    private void leerProfesor()
    {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(pFile)))
        {
            pLista = (List<Profesor>) entrada.readObject();
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void leerAlumnos()
    {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(aFile)))
        {
            aLista = (List<Alumno>) entrada.readObject();
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void showList()
    {
        for (Modulo m : mLista)
            System.out.format("%s - %s\n", m.id, m.name);
        System.out.println("=================");
        for (Alumno a : aLista)
            System.out.format("%s - %s - %s\n", a.id, a.name, a.modulos);
        System.out.println("==================");
        for(Profesor p : pLista)
            System.out.format("%s - %s - %s\n", p.id, p.name, p.modulos);
    }


public void plista()
{
    for(Modulo m : mLista)
    {
        for(Profesor p : pLista)
        {
            if(m.id.equals(p.id))
            {
                System.out.println(p.name + " " + p.id);
            }
        }
    }
}

    public void ListadoAssignatura(String id)
    {
        for(Profesor p : pLista)
        {
            for(String m : p.getModulos())
            {
                if(m.equals(id))
                {
                    System.out.println("Profesor del modulo " + " " + p.getModulos() +" " + p.getName());
                }
            }
        }

        for(Alumno a : aLista)
        {
            for(String m : a.getModulos())
            {
                if(m.equals(id))
                {
                    System.out.println("Alumno: " + a.getName());
                }
            }
        }
    }

    public void addProfesor(String id, String name, String ... mdls)
    {

        {
            pLista.add(new Profesor(id,name,mdls));
        }
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(pFile)))
        {
            salida.writeObject(pLista);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void addAlumno(String id, String name, String ... mdls)
    {

        {
            aLista.add(new Alumno(id,name,mdls));
        }
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(aFile)))
        {
            salida.writeObject(aLista);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }


    private void addModulos(String id, String name)
    {

            mLista.add(new Modulo(id,name));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(mFile)))
        {
            salida.writeObject(mLista);
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private void vermodulos()
    {
        for(Modulo m : mLista)
        {
            System.out.println(m.id + " " + m.name);
        }
    }

    public static void main(String[] args)
    {
        Gestion g = new Gestion();
        // g.ListadoAssignatura("m3");
        System.out.println("============================");
        // g.vermodulos();
        System.out.println("============================");
         g.showList();
        // g.addAlumno("a12","hhuuuuuuu","m3","m8","m1");
        System.out.println("============================");
        // g.addProfesor("m12","Yuiiiiiii","m0");
        System.out.println("============================");
        // g.addModulos("m12","exxee");
        System.out.println("============================");

        System.out.println("============================");
    }
}