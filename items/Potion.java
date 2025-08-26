package items;
import characters.Character;

public class Potion{

    protected int strength;
    protected int regen;
    protected int resistance;
    protected int power;
    public Potion(int strength, int regen, int resistance, int power){
        this.strength = strength;
        this.regen = regen;
        this.resistance = resistance;
        this.power = power;
    }

    public void strengthPotion(Character user,int strength){
    System.out.println("| " + user.getName() + " drinks a Strength Potion. Power surges through their veins!           |");
    user.effAttack(strength);
    }

    public void regenPotion(Character user, int regen){
    System.out.println("| " + user.getName() + " drinks a Regeneration Potion. Wounds begin to close!                  |");
    user.effHealth(regen);
    }

    public void resPotion(Character user, int resistance){
    System.out.println("| " + user.getName() + " drinks a Resistance Potion. Their skin hardens like stone!             |");
    user.effDefence(resistance);
    }

    public void staPotion(Character user, int Stamina){
    System.out.println("| " + user.getName() + " drinks a Stamina Potion. Energy floods their body!                     |");
    user.rmStamina(-Stamina);
    }
    
}