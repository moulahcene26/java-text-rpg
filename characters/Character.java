package characters;


public abstract class Character {
    private  String name;
    private int health;
    private int stamina;
    private int attackPower;
    private int defence;


    public Character(String name, int health,
                    int stamina, int attackPower,
                    int defence)
    {
        this.name = name;
        this.health =health;
        this.stamina =stamina;
        this.attackPower =attackPower;
        this.defence =defence;        
    }

    
    public boolean isAlive() {
        return this.health > 0;
    }
    public boolean hasStamina() {
        return this.stamina > 0;
    }
    public void takeDamage(double damage) {
    int actualDamage = (int) (damage * Math.max(0.0, 1 - (double) getDefence()/100));
    setHealth(getHealth() - actualDamage);
    setDefence((int)(Math.max(0, getDefence() - damage/2)));
    System.out.println("| " + getName() + " suffers " + actualDamage + " damage! Their defense weakens.                  |");
    }
    public void rmStamina(int amount){
    setStamina(getStamina() - amount);
    System.out.println("| " + getName() + "'s stamina is now " + getStamina() + ".                                         |");
    }
    abstract public void attack(Character target, Character friend, Character[] targets);

    public void effAttack(int strength){
    setAttackPower(getAttackPower() + strength);
    System.out.println("| " + getName() + "'s attack power increases to " + getAttackPower() + ".                          |");
    }

    public void effDefence(int resistance){
    setDefence(getDefence() + resistance);
    System.out.println("| " + getName() + "'s defense rises to " + getDefence() + ".                                       |");
    }

    public void effHealth(int regen){
    setHealth(getHealth() + regen);
    System.out.println("| " + getName() + "'s health is restored to " + getHealth() + ".                                   |");
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina(){
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefence(){
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void betweenTurns() {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); 
    }}

}
