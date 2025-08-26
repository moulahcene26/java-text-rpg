package mechanics;

import characters.Character;
import java.util.Arrays;
import utils.Randomizer;

public class Battle{

     private final Character[] heroes;
     private final Character[] villains;

    public Battle(Character[] heroes, Character[] villains){
        this.heroes = heroes;
        this.villains = villains;
    }

    public void startBattle(){
        System.out.println("Starting Battle !");
        while (!allDead(heroes) && !allDead(villains)) { 
            heroTurn();
            if(allDead(villains)) break;
            villainTurn();
        }
    }

    public boolean allDead(Character[] players){
        for(Character p : players){
            if(p.isAlive()) return false;
        }
        return true;
    }
    
    private void heroTurn(){
        Character h = chooseRandom(heroes);
        Character target = chooseRandom(villains);
        Character h2 = Arrays.stream(heroes).filter(hero -> !hero.equals(h)).findFirst().orElse(null);
        h.attack(target, h2, villains);
    }

    private void villainTurn(){
        Character v = chooseRandom(villains);
        Character target = chooseRandom(heroes);
        Character v2 = Arrays.stream(heroes).filter(hero -> !hero.equals(v)).findFirst().orElse(null);
        v.attack(target, v2, heroes);
    }

    private Character chooseRandom(Character[] players){
        return players[Randomizer.getRandomInt(0,1)];
    }
}