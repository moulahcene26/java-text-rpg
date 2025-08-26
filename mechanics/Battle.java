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
        betweenTurns();
        betweenTurns();
    System.out.println("==========================================================================");
    System.out.println("| The arena is shrouded in mist... Shadows writhe as the battle begins!  |");
    System.out.println("==========================================================================");
    betweenTurns();
        while (!allDead(heroes) && !allDead(villains)) { 
            System.out.println("\n| ~ A surge of hope flickers in the gloom. ~  Heroes Take the Turn!                |");
            betweenTurns();
            System.out.println("==========================================================================");
            betweenTurns();
            heroTurn();
            betweenTurns();
            if(allDead(villains)) break;
            System.out.println("\n| ~ The torches dim. A sinister chill descends. ~  Villains Take the Turn!         |");
            System.out.println("==========================================================================");
            villainTurn();
        }
        betweenTurns();
    }

    public boolean allDead(Character[] players){
        for(Character p : players){
            if(p.isAlive()) {
                return false;
            } else {
                betweenTurns();
                System.out.println("| X | " + p.getName() + " is claimed by the darkness! A hush falls over the blood-soaked ground. | ");
            }
        }
        return true;
    }
    
    private void heroTurn(){
    Character h = chooseRandomAlive(heroes);
    if (h == null) return;
    Character target = chooseRandomAlive(villains);
    if (target == null) return;
    Character h2 = Arrays.stream(heroes).filter(hero -> !hero.equals(h) && hero.isAlive()).findFirst().orElse(null);
    System.out.println("| " + h.getName() + " steps from the swirling fog, eyes burning with resolve...                         |");
    h.attack(target, h2, villains);
    betweenTurns();
    System.out.println("| " + h.getName() + " unleashes a radiant assault, steel flashing in the gloom!                        |");
    }

    private void villainTurn(){
    Character v = chooseRandomAlive(villains);
    if (v == null) return;
    Character target = chooseRandomAlive(heroes);
    if (target == null) return;
    Character v2 = Arrays.stream(heroes).filter(hero -> !hero.equals(v) && hero.isAlive()).findFirst().orElse(null);
    System.out.println("| " + v.getName() + " slithers from the darkness, a wicked grin carved across their face...             |");
    v.attack(target, v2, heroes);
    betweenTurns();
    System.out.println("| " + v.getName() + " delivers a cruel blow, the air thick with dread!                                 |");
    }
    private Character chooseRandomAlive(Character[] players){
        Character[] alive = Arrays.stream(players).filter(Character::isAlive).toArray(Character[]::new);
        if (alive.length == 0) return null;
        return alive[Randomizer.getRandomInt(0, alive.length-1)];
    }

    public void betweenTurns() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); 
    }
}
}