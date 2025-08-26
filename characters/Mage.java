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
			System.out.println("| " + this.getName() + " begins chanting, a green mist swirling around their hands!                  |");
			betweenTurns();
			if(hasStamina()) { if(magePoisonTime >= time){
				for (int i = time; i > 0; i--){
					target.takeDamage(damage);
					System.out.println("| " + target.getName() + " is enveloped in poison!                                                   |");
					betweenTurns();
				}
				magePoisonTime -= time;
				setStamina(getStamina() - 20);
				System.out.println("| The Mage has " + magePoisonTime + "s of poison time left.                                          |");
				System.out.println("| " + this.getName() + " cackles: 'Let the venom do its work!'                                       |");
				System.out.println("| Poison Attack unleashed!                                                                            |");
				betweenTurns();
			 } else {
				System.out.println("| The Mage has no poison left and the spell fizzles out.                                             |");
				betweenTurns();
			 }} else {
				System.out.println("| " + this.getName() + " is too exhausted to cast poison magic.                                      |");
				betweenTurns();
			}
		}

		public void mageFriendlyHeal(Character friend, int time){
			System.out.println("| " + this.getName() + " raises their staff, light radiating from their fingertips!                  |");
			betweenTurns();
			if(hasStamina()) { if(mageHealingTime >= time){
				for (int i = time; i > 0; i--){
					friend.setHealth(friend.getHealth() + 10);
					this.setHealth(this.getHealth() + 10);
					System.out.println("| " + friend.getName() + " is bathed in healing light!                                               |");
					betweenTurns();
				}
				mageHealingTime -= time;
				setStamina(getStamina() + 10);
				System.out.println("| The Mage has " + mageHealingTime + "s of healing time left.                                        |");
				System.out.println("| " + this.getName() + " proclaims: 'Rise, friend! The battle is not over!'                          |");
				System.out.println("| Friendly Heal performed!                                                                            |");
				betweenTurns();
			 } else {
				System.out.println("| The Mage has no Healing left and the magic fades.                                                  |");
				betweenTurns();
			 }
		} else {
			System.out.println("| " + this.getName() + " is too drained to heal anyone.                                              |");
			betweenTurns();
			}
		}
	@Override
	public void attack(Character target, Character friend, Character[] targets) { //choose between //mage should be 1, warrior 0
		int move = Randomizer.getRandomInt(0, 1);
		if(move == 1){
			this.mageAttackPoison(target, 10);
		} else {
			this.mageFriendlyHeal(friend, 5);
		}
    }

}