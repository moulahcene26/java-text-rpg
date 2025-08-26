package characters;

public class Warrior extends Character {

	public Warrior(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}

	@Override
	public void attack(Character target, Character friend, Character[] targets) { // heavy attack
		double damage = 7.57 * Math.pow(this.getAttackPower(), 0.6);
		if(hasStamina()) {
			target.takeDamage(damage);
			setStamina(getStamina() - 40);
		} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}




}