
package characters;

import utils.Randomizer;

public class Boss extends Character {

	public Boss(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}

	
	public void specialAttack(Character[] targets){
		if(hasStamina()) { for (Character target : targets) {
			target.setHealth(target.getHealth() - 50);
		}
		setStamina(getStamina() - 50);
	} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}

	public void bossHeal(){
		if(hasStamina()) { 
			this.setHealth(this.getHealth() + 30);
			setStamina(getStamina() - 10);
		}  else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}

	@Override
	public void attack(Character target, Character friend, Character[] targets) { //choose between //mage should be 1, warrior 0
        int move = Randomizer.getRandomInt(0, 1);
		if(move == 1){
			this.specialAttack(targets);
		} else {
			this.bossHeal();
		}
    }

}