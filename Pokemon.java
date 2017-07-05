import java.util.*;
public class Pokemon {
	public String type;
	public int health;
	public String name;
	public int defense;
	public int specAttackPower;
	public int wins;
	public int level= wins/5;
	public String[] moves = new String[4];
	public String[] names = {"Destructo", "Charger", "Fuse Fire"};
	public Pokemon(String type, String name){
		this.type = type;
		this.health = 100;
		this.specAttackPower = 10;
		this.defense = 5;
		this.wins = 0;
		this.level = 0;
		this.name = name;
	}
}
