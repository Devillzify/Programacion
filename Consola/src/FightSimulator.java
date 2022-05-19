

public class FightSimulator
{
    public static boolean simulateFight(Character miPj, Character enemy)
    {
        boolean victoria = false;


        if(enemy.getEstadisticas().getAtaque() < miPj.getEstadisticas().getAtaque()){
            victoria = true;
            System.out.println(miPj.getNombre() + " Ha ganado la pelea");
        }
        return victoria;
    }

    public static boolean tryToEscape(Character miPj, Character enemy){
        int random = (int)Math.floor(Math.random() * 100);
        if(random < 50){
            System.out.println("Has conseguido huir");
            return true;
        }
        else{
            System.out.println("No has podido huir");
            return simulateFight(miPj, enemy);

        }
    }

}
