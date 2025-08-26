package characters;

import utils.Randomizer;

public class Lucifer extends Character {

	public Lucifer(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}


	
	public void satanAttack(Character[] targets) {
		
		if(hasStamina()) {
			for(Character target : targets){
				target.rmStamina(90);
				setStamina(getStamina() - 50);
			}} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}


	public void deadHand(Character[] targets){
		double damage = 7.57 * Math.pow(this.getAttackPower(), 0.6);
		if(hasStamina()) {
			for(Character target : targets){
				target.takeDamage(damage);
				this.setHealth(this.getHealth() - 99);
			}} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}

	@Override
	public void attack(Character target, Character friend, Character[] targets) { //choose between //mage should be 1, warrior 0
        int move = Randomizer.getRandomInt(0, 1);
		if(move == 1){
			this.satanAttack(targets);
		} else {
			this.deadHand(targets);
		}
    }

	
}