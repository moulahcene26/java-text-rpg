package mechanics;

import characters.Character;

public class GameEngine{


    public void start(Character[] heroes, Character[] villains) {
        Battle battle = new Battle(heroes, villains);
        battle.startBattle();
        if (allDead(heroes)) {
            System.out.println("Villains WIN !");
        } else if (allDead(villains)) {
            System.out.println("Heroes WIN !");
            }
        }
    
    
    private boolean allDead(Character[] characters) {
            for (Character c : characters) {
                if (c.isAlive()) {
                    return false;
                }
            }
            return true;
        }
}
