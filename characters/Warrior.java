package characters;

public class Warrior extends Character {

	public Warrior(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}

	@Override
	public void attack(Character target, Character friend, Character[] targets) { // heavy attack
		double damage = 7.57 * Math.pow(this.getAttackPower(), 0.6);
		System.out.println("| " + this.getName() + " lets out a fierce battle cry!                                               |");
		betweenTurns();
		if(hasStamina()) {
			System.out.println("| " + this.getName() + " charges at " + target.getName() + " with unstoppable force!                      |");
			betweenTurns();
			target.takeDamage(damage);
			System.out.println("| " + target.getName() + " reels from the mighty blow!                                               |");
			betweenTurns();
			setStamina(getStamina() - 40);
			System.out.println("| " + this.getName() + " shouts: 'Feel the power of my blade!'                                      |");
			System.out.println("| A thunderous Heavy Attack shakes the field!                                                        |");
			betweenTurns();
		} else {
			System.out.println("| " + this.getName() + " is out of stamina and drops to one knee, gasping for breath.                |");
			betweenTurns();
		}
	}




}