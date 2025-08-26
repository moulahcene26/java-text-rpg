package mechanics;

import characters.Character;

public class Battle{

     private Character[] heroes;
     private Character[] villains;

    public Battle(Character[] heroes, Character[] villains){
        this.heroes = heroes;
        this.villains = villains;
    }

    public void startBattle(){
        System.out.println("Starting Battle !");
        while (!allDead(heroes) && !allDead(villains)) { 
            
        }
    }

    private boolean allDead(Character[] players){
        for(Character p : players){
            if(p.isAlive()) return false;
        }
        return true;
    }

    private void heroTurn(){

    }

    private void villainTurn(){

    }
}