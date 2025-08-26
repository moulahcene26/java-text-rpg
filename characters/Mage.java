package characters;

import utils.Randomizer;


public class Mage extends Character {

	private int magePoisonTime;
	private int mageHealingTime;

	public Mage(String name, int health, int stamina, int attackPower, int defence, int magePoisonTime, int mageHealingTime) {
    	super(name, health, stamina, attackPower, defence);
    	this.magePoisonTime = magePoisonTime;
    	this.mageHealingTime = mageHealingTime;
	}


	

	public void mageAttackPoison(Character target, int time){
		double damage = 7.57 * Math.pow(this.getAttackPower(), 0.6);
		if(hasStamina()) { if(magePoisonTime >= time){
			for (int i = time; i > 0; i--){
				target.takeDamage(damage);
				System.out.println("Poisoned  !");
			}
			magePoisonTime -= time;
			setStamina(getStamina() - 20);
			System.out.println("The Mage has "+magePoisonTime+"s of poison time left");
		 } else {
			System.out.println("The Mage has no poison left");
		 }} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}

	public void mageFriendlyHeal(Character friend, int time){
		if(hasStamina()) { if(mageHealingTime >= time){
			for (int i = time; i > 0; i--){
				friend.setHealth(friend.getHealth() + 10);
				this.setHealth(this.getHealth() + 10);
				System.out.println("Healed!");
			}
			mageHealingTime -= time;
			setStamina(getStamina() + 10);
			System.out.println("The Mage has "+mageHealingTime+"s of healing time left");
		 } else {
			System.out.println("The Mage has no Healing left");
		 }
	} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}
	@Override
	public void attack(Character target, Character friend, Character[] targets) { //choose between //mage should be 1, warrior 0
        int move = Randomizer.getRandomInt(0, 1);
		if(move == 1){
			this.mageAttackPoison(target, 10);
		} else {
			this.mageFriendlyHeal(friend, 10);
		}
    }

}