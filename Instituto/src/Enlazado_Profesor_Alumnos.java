import java.util.Arrays;

public class Enlazado_Profesor_Alumnos
{

    public final Profesor[] listado_Profesores =
            {
                    new Profesor("3222232", "Antonio Marmol", 200000,
                            new Moduls(true, false, false, false, false)
                    ),

                    new Profesor("29323982", "Ramon", 5000,
                            new Moduls(false, true, false, false, false)
                    ),

                    new Profesor("2382938", "Alicia", 3000,
                            new Moduls(false, false, true, false, false)
                    ),
                    new Profesor("23829338", "tuttt", 3000,
                            new Moduls(false, false, false, true, false)
                    ),
                    new Profesor("2382938", "Allalaa", 3000,
                            new Moduls(false, false, false, false, true)
                    )
            };


    public final Alumno[] listado_Alumnos =
            {
                    new Alumno("3948384", "Andres",
                            new Moduls(true, true, true, true, false)
                    ),

                    new Alumno("4930800", "Ginard",
                            new Moduls(true, true, true, false, true)),

                    new Alumno("52257", "Dani",
                            new Moduls(true, true, false, true, true)
                    ),
                    new Alumno("998257", "Fflflf",
                            new Moduls(true, false, true, true, true)
                    ),
                    new Alumno("798257", "nununununu",
                            new Moduls(false, true, true, true, true)
                    )
            };

    @Override
    public String toString()
    {
        return "Enlazado_Profesor_Alumnos{" +
                "listado_Profesores=" + Arrays.toString(listado_Profesores) +
                ", listado_Alumnos=" + Arrays.toString(listado_Alumnos) +
                '}';
    }

    public void imprimir_Array_Profesores()
    {
        for (Profesor listado_profesores : listado_Profesores)
        {
            System.out.println(listado_profesores);
        }
    }

    public void imprimir_Array_Alumnos()
    {
        comprobarfol();
        comprobarprogramacion();
        comprobarbases();
        comprobarentorns();
        comprobarllenguatge();
        for (Alumno lista_alumnos : listado_Alumnos)
        {
            System.out.println(lista_alumnos);
        }
    }

    public void comprobarfol()
    {
        boolean hayprofedefol = false;
        for (Profesor listado_profesore : listado_Profesores)
        {
            if (listado_profesore.getModuls().isFol())
            {
                hayprofedefol = true;
            }
        }
        if (!hayprofedefol)
        {
            for (Alumno listado_alumno : listado_Alumnos)
            {
                listado_alumno.getModuls().setFol(false);
            }
        }
    }

    public void comprobarprogramacion()
    {
        boolean hayprofedeprogramacion = false;
        for (Profesor listado_profesore : listado_Profesores)
        {
            if (listado_profesore.getModuls().isProgramacion())
            {
                hayprofedeprogramacion = true;
            }
        }
        if (!hayprofedeprogramacion)
        {
            for (Alumno listado_alumno : listado_Alumnos)
            {
                listado_alumno.getModuls().setProgramacion(false);
            }
        }
    }

    public void comprobarbases()
    {
        boolean hayprofedebases = false;
        for (Profesor listado_profesore : listado_Profesores)
        {
            if (listado_profesore.getModuls().isBase_de_datos())
            {
                hayprofedebases = true;
            }
        }
        if (!hayprofedebases)
        {
            for (Alumno listado_alumno : listado_Alumnos)
            {
                listado_alumno.getModuls().setBase_de_datos(false);
            }
        }
    }

    public void comprobarentorns()
    {
        boolean hayprofedeent = false;
        for (Profesor listado_profesore : listado_Profesores)
        {
            if (listado_profesore.getModuls().isEntorns())
            {
                hayprofedeent = true;
            }
        }
        if (!hayprofedeent)
        {
            for (Alumno listado_alumno : listado_Alumnos)
            {
                listado_alumno.getModuls().setEntorns(false);
            }
        }
    }

    public void comprobarllenguatge()
    {
        boolean hayprofedell = false;
        for (Profesor listado_profesore : listado_Profesores)
        {
            if (listado_profesore.getModuls().isLlenguatges())
            {
                hayprofedell = true;
            }
        }
        if (!hayprofedell)
        {
            for (Alumno listado_alumno : listado_Alumnos)
            {
                listado_alumno.getModuls().setLlenguatges(false);
            }
        }
    }

    public void asignaturaFol()
    {
        for (int i = 0; i < listado_Profesores.length; i++)
        {
            if (listado_Profesores[i].getModuls().isFol())
            {
                System.out.println("El profesor de Fol es: " + listado_Profesores[i].nom + " " + listado_Profesores[i].dni);
            }
        }
        for (int r = 0; r < listado_Alumnos.length; r++)

            if (listado_Alumnos[r].getModuls().isFol())
            {
                System.out.println("alumno: " + listado_Alumnos[r].nom + " " + listado_Alumnos[r].dni);
            }


    }

    public void asignaturadbm()
    {
        for (int i = 0; i < listado_Profesores.length; i++)
        {
            if (listado_Profesores[i].getModuls().isBase_de_datos())
            {
                System.out.println("El profesor de Base de dades es: " + listado_Profesores[i].nom + " " + listado_Profesores[i].dni);
            }
        }
        for (int r = 0; r < listado_Alumnos.length; r++)

            if (listado_Alumnos[r].getModuls().isBase_de_datos())
            {
                System.out.println("alumno: " + listado_Alumnos[r].nom + " " + listado_Alumnos[r].dni);
            }


    }

    public void asignaturapro()
    {
        for (int i = 0; i < listado_Profesores.length; i++)
        {
            if (listado_Profesores[i].getModuls().isProgramacion())
            {
                System.out.println("El profesor de Programacio es: " + listado_Profesores[i].nom + " " + listado_Profesores[i].dni);
            }
        }
        for (int r = 0; r < listado_Alumnos.length; r++)

            if (listado_Alumnos[r].getModuls().isProgramacion())
            {
                System.out.println("alumno: " + listado_Alumnos[r].nom + " " + listado_Alumnos[r].dni);
            }


    }

    public void asignaturaent()
    {
        for (int i = 0; i < listado_Profesores.length; i++)
        {
            if (listado_Profesores[i].getModuls().isEntorns())
            {
                System.out.println("El profesor de Entorns es: " + listado_Profesores[i].nom + " " + listado_Profesores[i].dni);
            }
        }
        for (int r = 0; r < listado_Alumnos.length; r++)

            if (listado_Alumnos[r].getModuls().isEntorns())
            {
                System.out.println("alumno: " + listado_Alumnos[r].nom + " " + listado_Alumnos[r].dni);
            }


    }

    public void asignaturallengua()
    {
        for (int i = 0; i < listado_Profesores.length; i++)
        {
            if (listado_Profesores[i].getModuls().isLlenguatges())
            {
                System.out.println("El profesor de Llenguatges es: " + listado_Profesores[i].nom + " " + listado_Profesores[i].dni);
            }
        }
        for (int r = 0; r < listado_Alumnos.length; r++)

            if (listado_Alumnos[r].getModuls().isLlenguatges())
            {
                System.out.println("alumno: " + listado_Alumnos[r].nom + " " + listado_Alumnos[r].dni);
            }


    }
}


