package characters;

public class Warrior extends Character {

	public Warrior(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}

	
	public void heavyattack(Character target) {
		if(hasStamina()) {
			target.takeDamage(30);
			setStamina(getStamina() - 40);
		} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}


}