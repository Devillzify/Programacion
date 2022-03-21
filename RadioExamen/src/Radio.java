public class Radio
{
    public static void main(String[] args)
    {
        Scannerutils sc = new Scannerutils();
        double frequencia = sc.showMessageAndGetDouble("Introduce la frequencia inicial de la radio");
        RadioFrequencia radioFrequencia = new RadioFrequencia(frequencia);
        int opcion = -1;

        do
        {
            opcion = sc.showMessageAndGetInt("Frequencia actual:" + radioFrequencia.getFreqActual() + " " + radioFrequencia.getNombreEmisoraActual() + "\n1- Cambiar Frequencia\n2- Guardar frequencia actual\n3- Ver emisoras\n0- Salir");
            switch (opcion)
            {
                case 1:
                    double nuevafrequencia = sc.showMessageAndGetDouble("introduce la frequencia");
                    radioFrequencia.setFrequencia(nuevafrequencia);
                    break;
                case 2:
                    String nombreEmisora = sc.showMessageAndGetEmisora("Introduce el nombre de la emisora que quieres guardar");
                    radioFrequencia.guardarEmisora(nombreEmisora);
                    break;
                case 3:
                    radioFrequencia.showEmisoras();
                    break;
                case 0:
                    System.exit(1);
            }
        }
        while(opcion != 0);
    }

    /* He tenido un supervisor durante este ejercicio que me ha ayudado, lo notaras porque el codigo es de una calidad muy superior a los demas,
    * aun asi he sacado la mayoria del projecto sin ayuda
   */
}
