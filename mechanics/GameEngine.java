package mechanics;

import characters.Character;

public class GameEngine{


    public void start(Character[] heroes, Character[] villains) {
        Battle battle = new Battle(heroes, villains);
        battle.startBattle();
        if (allDead(heroes)) {
            System.out.println("==========================================================================");
            System.out.println("| The villains stand victorious! Darkness claims the land...               |");
            System.out.println("==========================================================================");
        } else if (allDead(villains)) {
            System.out.println("==========================================================================");
            System.out.println("| The heroes triumph! Light returns to the world!                         |");
            System.out.println("==========================================================================");
        }
    }

    private boolean allDead(Character[] players){
        for(Character p : players){
            if(p.isAlive()) {
                return false;
            } 
        }
        return true;
    }
}
