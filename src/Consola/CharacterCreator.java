package Consola;

public class CharacterCreator
{
    public static Character createNewCharacter()
    {
        String nombre = ScannerUtils.getStringShowingText("Introduce el nombre del personaje");
        Raza raza = showRacesAndPickOne();

        return new Character(raza,nombre,raza.getInitialStats());
    }

    private static Raza showRacesAndPickOne()
    {
        for (int i = 0; i < Constants.initialRaces.length; i++)
        {
            System.out.println((i+1) + " - " + Constants.initialRaces[i].getNombre());
        }

        int razaseleccionada = ScannerUtils.getIntShowingText("Selecciona una raza de la lista");

       return Constants.initialRaces[razaseleccionada - 1];
    }

    public static Character createNewEnemy()
    {
        int random = (int)Math.floor(Math.random() * (Constants.possibleEnemy.length));
        return Constants.possibleEnemy[random];
    }




}
