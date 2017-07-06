import java.util.*;
public class Pokemon {
	public String type;
	public int health;
	public String name;
	public int defense;
	public int specAttackPower;
	public int attackPower;
	public int wins;
	public int level= wins/5;
	public String weakness;
	public String[] names = {"Destructo", "Charger", "Fuse Fire"};
	public Pokemon(String type, String name){
		this.type = type;
		this.health = 30;
		this.specAttackPower = 10;
		this.attackPower = 8;
		this.defense = 5;
		this.wins = 0;
		this.level = 0;
		this.name = name;
	}
	public int takeDamage(int damage){
		int damageTaken = damage - this.defense;
		return damageTaken;
	}
	public int attack(Pokemon target, String attackType){
		int damageGiven;
		if(attackType.equals("special attack")){
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
		}else{
			damageGiven = this.attackPower;
			target.takeDamage(damageGiven);
		}
		return damageGiven;
	}
	public int defend(){
		int raiseDefense = 3;
		this.defense+=raiseDefense;
		return raiseDefense;
	}
	public void heal(){
		this.health+=5;
	}
}
