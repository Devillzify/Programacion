

public class CreateNpc
{
    public static void main(String[] args)
    {
        Character miPj =  CharacterCreator.createNewCharacter();

        int userOption = -1;
        System.out.println("\n\nSe ha creado un nuevo Personaje\n" + miPj + "\n\n");
        do{
            Character enemy = CharacterCreator.createNewEnemy();
            userOption = ScannerUtils.getIntShowingText("Se ha encontrado un nuevo enemigo " + enemy.getNombre() + "\n\n1 - Luchar\n2 - Huir\n\n0 - Salir");
            boolean victoria = false;
            switch(userOption){
                case 1:
                    victoria = FightSimulator.simulateFight(miPj,enemy);
                    break;
                case 2:
                    victoria = FightSimulator.tryToEscape(miPj,enemy);
                    break;
                case 0:
                    System.exit(0);
            }
            if(!victoria){
                userOption = ScannerUtils.getIntShowingText("Has muerto\n\n1 - Continuar\n0 - Salir");
                if(userOption == 0){
                    System.exit(0);
                }
                System.out.println("\n\nHas revivido\n\n");
            }


        }while(userOption != 0);


    }
}
