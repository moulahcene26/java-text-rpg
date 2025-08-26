package items;
import characters.Character;

public class Armor{

    protected int durability;
    protected int def;
    public Armor(int durability, int def){
        this.durability = durability;
        this.def = def;
    }

    public void genArmor(Character user, int durability, int def){
    System.out.println("==========================================================================");
    System.out.println("| " + user.getName() + " dons new armor. The metal gleams with ancient runes.                |");
    System.out.println("==========================================================================");
    user.effDefence(def);
    user.rmStamina(-durability);
    }
}