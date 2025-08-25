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
        user.effAttack(strength);
    }

    public void regenPotion(Character user, int regen){
        user.effHealth(regen);
    }

    public void resPotion(Character user, int resistance){
        user.effDefence(resistance);
    }

    public void staPotion(Character user, int Stamina){
        user.rmStamina(-Stamina);
    }
    
}