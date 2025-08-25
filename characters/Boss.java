
package characters;

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


}