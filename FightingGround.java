import java.util.*;

public class FightingGround {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numDef = 0;
		int specMove = 0;
		int healUse = 0;
		String[] attackTypes = {"attack", "special attack", "defend"};
		String[] names = {"Destructo", "Charger", "Fuse Fire"};
		String[] types = {"fire", "water", "grass", "dark", "psycic",  "metal"};
		Scanner keyboard = new Scanner(System.in);
		Random gen = new Random();
		boolean isAlive = true;
		System.out.println("Welcome to  Haritmon");
		boolean notValid = true;
		String typeChoice = "";
		while(notValid) {
			System.out.println("What type haritmon do you want to be?");
			System.out.println("Types:");
			for(int i  = 0; i<types.length; i++){
				System.out.println(types[i]);
			}
			typeChoice = keyboard.nextLine().toLowerCase();
			for(String choice : types){
				if(choice.equals(typeChoice)) {
					notValid = false;
				}
				
			}
			if(notValid) {
				System.out.println("Type not valid");
			}
		}
		System.out.println("What would you like to name the haritmon.");
		String name = keyboard.nextLine();
		Pokemon pokemon1 = new Pokemon(typeChoice, name);
		Pokemon pokemon2 = new Pokemon(types[gen.nextInt(5)], names[gen.nextInt(2)]);
		if(pokemon1.type.equals(types[0])){
			pokemon1.weakness = "water";
		}
		else if(pokemon1.type.equals(types[1])){
			pokemon1.weakness = "grass";
		}
		else if(pokemon1.type.equals(types[2])){
			pokemon1.weakness = "fire";
		}
		else if(pokemon1.type.equals(types[3])){
			pokemon1.weakness = "psycic";
		}
		else if(pokemon1.type.equals(types[4])){
			pokemon1.weakness = "dark";
		}
		else  if(pokemon1.type.equals(types[5])){
			pokemon1.weakness = "psycic";
		}
			
			while((pokemon1.health > 0) && (pokemon2.health > 0)) {
				System.out.println("Fight your first battle aiganst the haritmon, "+ pokemon2.name);
				System.out.println("1. Use a move");
				System.out.println("2. View stats");
				int fightChoice = keyboard.nextInt();
				if(fightChoice == 1){
					System.out.println("Your moves:");
					System.out.println("1. Normal Attack");
					System.out.println("2. Special Attack");
					System.out.println("3. Defend");
					System.out.println("4. Heal");
					int moveChoice = keyboard.nextInt();
					if(moveChoice<=2){
						
						if(moveChoice-1==0){
							specMove=+1;
						}else if(moveChoice-1 == 2){
							numDef=+1;
						}
						if(numDef>5){
							System.out.println("Defense failed");
						}
						if(specMove>1){
							System.out.println("Pokemon is too tired");
							
						}
						pokemon1.attack(pokemon2, attackTypes[moveChoice-1]);
						if(pokemon1.attack(pokemon2, attackTypes[moveChoice-1])>pokemon2.health/2){
						System.out.println(pokemon1.name+ "'s  attack is super effective");
						}else if(pokemon1.attack(pokemon2, attackTypes[moveChoice-1]) < pokemon2.health/2){
							System.out.println(pokemon1.name+ "'s  attack is not very effective");
						}else if(pokemon1.attack(pokemon2, attackTypes[moveChoice-1]) < pokemon2.health/2){
							System.out.println(pokemon1.name+ "'s  attack had no effect");
						}
						pokemon2.health -= pokemon1.attack(pokemon2, attackTypes[moveChoice-1]);
						System.out.println(pokemon2.name + " has " + pokemon2.health + " health left");
					}else if(moveChoice==3){
						pokemon1.defend();
					}
					else 
					{
						pokemon1.heal();
						System.out.println(pokemon1.name + " healed back 5 of its health");
					}
					}else{
						System.out.println(pokemon1.name + " stats: health: " + pokemon1.health);
						System.out.println("Attack: " + pokemon1.attackPower);
						System.out.println("Special Attack: " + pokemon1.specAttackPower);
						System.out.println("Defense: " + pokemon1.defense);
						System.out.println(pokemon2.name + " stats: health: " + pokemon1.health);
						System.out.println("Attack: " + pokemon2.attackPower);
						System.out.println("Special Attack: " + pokemon2.specAttackPower);
						System.out.println("Defense: " + pokemon2.defense);
						
					}
				int attackTypeCPU = gen.nextInt(1);
				pokemon2.attack(pokemon1, attackTypes[attackTypeCPU]);
				pokemon1.health-=pokemon2.attack(pokemon1, attackTypes[attackTypeCPU]);
				System.out.println(pokemon2.name + " depleted " +  pokemon2.attack(pokemon1, attackTypes[attackTypeCPU]) + " of you health");
				System.out.println(pokemon1.name + " has " + pokemon1.health +" left");
			}	
			if(pokemon2.health<=0){
				System.out.println("You won!");
			}else{
			System.out.println("Game over");
			}
	}
	

}
