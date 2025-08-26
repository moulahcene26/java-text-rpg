import characters.Boss;
import characters.Lucifer;
import characters.Mage;
import characters.Warrior;
import mechanics.GameEngine;

public class Main{
    public static void main(String[] args){
        characters.Character[] heroes = {
            new Warrior("Warrior", 150, 150, 200, 120),
            new Mage("Mage", 80, 200,20,90,60,60)
        };

        characters.Character[] villains = {
            new Lucifer("Lucifer", 100, 100, 200, 50),
            new Boss("Copernilius", 200, 80,70,130)
        };


        GameEngine engine = new GameEngine();
        engine.start(heroes, villains);


    }
}