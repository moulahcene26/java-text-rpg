
package characters;

import utils.Randomizer;

public class Boss extends Character {

	public Boss(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}

	
	public void specialAttack(Character[] targets){
		System.out.println("| " + this.getName() + " towers over the battlefield, eyes glowing ominously!                        |");
		betweenTurns();
		if(hasStamina()) { for (Character target : targets) {
			System.out.println("| " + this.getName() + " extends a hand toward " + target.getName() + ", draining their life force!         |");
			target.setHealth(target.getHealth() - 50);
			betweenTurns();
		}
		setStamina(getStamina() - 50);
		System.out.println("| " + this.getName() + " bellows: 'You are powerless before me!'                                      |");
		System.out.println("| Special Move: The Drain unleashed!                                                                  |");
		betweenTurns();
	} else {
			System.out.println("| " + this.getName() + " is too weak to perform The Drain and stumbles.                              |");
			betweenTurns();
		}
	}

	public void bossHeal(){
		System.out.println("| " + this.getName() + " roars, summoning dark energy to heal wounds!                                |");
		betweenTurns();
		if(hasStamina()) { 
			this.setHealth(this.getHealth() + 30);
			setStamina(getStamina() - 10);
			System.out.println("| " + this.getName() + " regenerates with unnatural speed! Boss Heal successful!                     |");
			betweenTurns();
		}  else {
			System.out.println("| " + this.getName() + " is out of stamina and cannot heal.                                          |");
			betweenTurns();
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