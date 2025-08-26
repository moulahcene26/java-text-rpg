package characters;

import utils.Randomizer;

public class Lucifer extends Character {

	public Lucifer(String name, int health, int stamina, int attackPower, int defence) {
		super(name, health, stamina, attackPower, defence);
	}


	
	public void satanAttack(Character[] targets) {
		
	System.out.println("| The air crackles with tension as the villains prepare to strike!                                   |");
		if(hasStamina()) {
			for(Character target : targets){
				betweenTurns();
		System.out.println("| " + this.getName() + " glares at " + target.getName() + ", draining their will to fight!                  |");
				target.rmStamina(90);
				betweenTurns();
		System.out.println("| " + target.getName() + " feels a wave of exhaustion!                                               |");
				setStamina(getStamina() - 50);
			}
			betweenTurns();
	    System.out.println("| " + this.getName() + " unleashes a sinister grin: 'Is that all you've got?'                        |");
	    betweenTurns();
		System.out.println("| A dark aura engulfs the battlefield as the SATAN attack is unleashed!                              |");
		} else {
			betweenTurns();
	    System.out.println("| " + this.getName()+" has ran out of Stamina and collapses to one knee.                             |");
		betweenTurns();
	}
	}


	public void deadHand(Character[] targets){
		double damage = 7.57 * Math.pow(this.getAttackPower(), 0.6);
		System.out.println("| " + this.getName() + " whispers an ancient incantation... the Protocol: dead hand is about to be activated! |");
		if(hasStamina()) {
			for(Character target : targets){
				betweenTurns();
				System.out.println("| A chilling wind sweeps the field as " + this.getName() + " targets " + target.getName() + "!         |");
				target.takeDamage(damage);
				betweenTurns();
				System.out.println("| " + target.getName() + " staggers from the blow, barely staying on their feet!                      |");
				this.setHealth(this.getHealth() - 99);
			}
			System.out.println("| The ground trembles beneath the force of the Protocol: dead hand!                                   |");
		} else {
			betweenTurns();
			System.out.println("| " + this.getName()+" has ran out of Stamina and the spell fizzles out.                             |");
		}
		betweenTurns();
		System.out.println("| " + this.getName()+" cackles: 'Your end is near!'                                                  |");
		betweenTurns();
		System.out.println("| Protocol: dead hand has been unleashed!                                                             |");
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