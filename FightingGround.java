import java.util.*;

public class FightingGround {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int moveChoice = 0;
		String[] attackTypes = {"attack", "special attack", "defend"};
		String[] names = {"Destructo", "Charger", "Fuse Fire"};
		String[] types = {"fire", "water", "grass", "dark", "psycic",  "metal"};
		Scanner keyboard = new Scanner(System.in);
		Random gen = new Random();
		System.out.println("Welcome to  Pokemon Battle Sim");
		boolean notValid = true;
		String typeChoice = "";
		while(notValid) {
			System.out.println("What type of pokemon do you want to be?");
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
		System.out.println("What would you like to name the pokemon.");
		String name = keyboard.nextLine();
		Pokemon pokemon1 = new Pokemon(typeChoice, name);
		System.out.println("So your pokemon's name is " + pokemon1.name + " and it is a " + pokemon1.type + " type");
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
		
		if(pokemon2.type.equals(types[0])){
			pokemon2.weakness = "water";
		}
		else if(pokemon2.type.equals(types[1])){
			pokemon2.weakness = "grass";
		}
		else if(pokemon2.type.equals(types[2])){
			pokemon2.weakness = "fire";
		}
		else if(pokemon2.type.equals(types[3])){
			pokemon2.weakness = "psycic";
		}
		else if(pokemon2.type.equals(types[4])){
			pokemon2.weakness = "dark";
		}
		else  if(pokemon2.type.equals(types[5])){
			pokemon2.weakness = "psycic";
		}
			
			while((pokemon1.health > 0) && (pokemon2.health > 0)) {
				System.out.println(pokemon1.name + " vs. " + pokemon2.name);
				System.out.println("1. Use a move");
				System.out.println("2. View stats");
				int fightChoice = keyboard.nextInt();
				if(fightChoice == 1){
					System.out.println("Your moves:");
					System.out.println("1. Normal Attack");
					System.out.println("2. Special Attack				Uses: " + pokemon1.specMove);
					System.out.println("3. Defend					Uses: " + pokemon1.numDef);
					System.out.println("4. Heal						Uses: " + pokemon1.healUse);
					moveChoice = keyboard.nextInt();
					if(moveChoice<3){
						int pokemon1Attack = pokemon1.attack(pokemon2, attackTypes[moveChoice-1]);
						if(pokemon1Attack>pokemon2.health/2){
						System.out.println(pokemon1.name+ "'s  attack is super effective");
						pokemon2.health -= pokemon1.attack(pokemon2, attackTypes[moveChoice-1]);
						System.out.println(pokemon2.name + " has " + pokemon2.health + " health left");
						}else if(pokemon1Attack < pokemon2.health/2){
							System.out.println(pokemon1.name+ "'s  attack is not very effective");
							pokemon2.health -= pokemon1.attack(pokemon2, attackTypes[moveChoice-1]);
							System.out.println(pokemon2.name + " has " + pokemon2.health + " health left");
						}
						
					
					
					}else if(moveChoice == 3){
						pokemon1.defend();
						System.out.println(pokemon1.name + "'s defense rose by "+ 3);
					}
					else if(moveChoice == 4){
						pokemon1.heal();
						System.out.println(pokemon1.name  + " healed 5 of its health back");
					}
					} else{
						System.out.println(pokemon1.name + " stats: health: " + pokemon1.health);
						System.out.println("Type: " + pokemon1.type);
						System.out.println("Attack: " + pokemon1.attackPower);
						System.out.println("Special Attack: " + pokemon1.specAttackPower);
						System.out.println("Defense: " + pokemon1.defense);
						System.out.println(pokemon2.name + " stats: health: " + pokemon1.health);
						System.out.println("Type:" + pokemon2.type);
						System.out.println("Attack: " + pokemon2.attackPower);
						System.out.println("Special Attack: " + pokemon2.specAttackPower);
						System.out.println("Defense: " + pokemon2.defense);
						
					}
				int attackTypeCPU = gen.nextInt(2);
				int pokemon2Attack = pokemon2.attack(pokemon1, attackTypes[attackTypeCPU]);
				pokemon1.health-=pokemon2Attack;
				System.out.println(pokemon2.name + " depleted " +  pokemon2Attack + " of you health");
				System.out.println(pokemon1.name + " has " + pokemon1.health +" left");
			}	
			if((pokemon2.health<=0)&&(pokemon1.health>0)){
				System.out.println("You won!");
			}else if(pokemon2.health>0){
			System.out.println("Game over");
			}else{
				System.out.println("Both pokemon defeated each other");
			}
			keyboard.close();
	}
			
	
}
