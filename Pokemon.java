
public class Pokemon {
	public String type;
	public int health;
	public String name;
	public int defense;
	public int specAttackPower;
	public int attackPower;
	public String weakness;
	public String[] names = {"Destructo", "Charger", "Fuse Fire"};
	public int numDef;
	public int specMove;
	public int healUse;
	public Pokemon(String type, String name){
		this.type = type;
		this.health = 30;
		this.specAttackPower = 10;
		this.attackPower = 8;
		this.name = name;
		this.specMove =3;
		this.healUse = 2;
		this.numDef =  3;
	}
	public int takeDamage(int damage){
		int damageTaken = damage - this.defense;
		return damageTaken;
	}
	public int attack(Pokemon target, String attackType){
		int damageGiven = 0;
		if(attackType.equals("special attack")){
			this.specMove-=1;
			if(specMove>0){
				if(this.type.equals(target.weakness)){
					damageGiven = this.specAttackPower * 2;
					target.takeDamage(damageGiven);
				}else if(this.weakness.equals(target.type)){
					damageGiven = 0;
					target.takeDamage(damageGiven);
				}else{
					damageGiven = this.specAttackPower;
					target.takeDamage(damageGiven);
				}
			}else if(this.specMove <= 0){
				System.out.println(this.name + " is to tired to use a special move");
				damageGiven = 0;
			}
		}else{
			damageGiven = this.attackPower;
			target.takeDamage(damageGiven);
		}
		return damageGiven;
	}
	public int defend(){
		int raiseDefense;
		this.numDef-=1;
		if(numDef>0){
		raiseDefense = 3;
		this.defense+=raiseDefense;
		}else{
			raiseDefense = 0;
			System.out.println("Defense failed");
		}
		return raiseDefense;
	}
	public void heal(){
		if(this.healUse>0){
		this.health+=5;
		}else{
			System.out.println("Healing failed");
		}
	}
}
