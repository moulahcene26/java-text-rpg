package characters;

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
		if(hasStamina()) {
			for(Character target : targets){
				target.takeDamage(100);
				this.setHealth(this.getHealth() - 99);
			}} else {
			System.out.println(this.getName()+" has ran out of Stamina.");
		}
	}

	

	
}