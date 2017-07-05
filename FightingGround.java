import java.util.*;

public class FightingGround {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Destructo", "Charger", "Fuse Fire"};
		String[] types = {"fire", "water", "grass", "dark", "psycic",  "metal"};
		Scanner keyboard = new Scanner(System.in);
		Random gen = new Random();
		boolean isAlive = true;
		System.out.println("Welcome to  Haritmon");
		System.out.println("What type haritmon do you want to be?");
		System.out.println("Types:");
		for(int i  = 0; i<types.length; i++){
			System.out.println(types[i]);
		}
		String typeChoice = keyboard.nextLine().toLowerCase();
		for(String choice : types){
			choice = typeChoice;
		}
		System.out.println("What would you like to name the haritmon.");
		String name = keyboard.nextLine();
		Pokemon pokemon1 = new Pokemon(typeChoice, name);
		Pokemon pokemon2 = new Pokemon(types[gen.nextInt(5)], names[gen.nextInt(2)]);
		if(pokemon1.level == 1){

			System.out.println("Fight your first battle aiganst the haritmon, "+ pokemon2.name);
			System.out.println("Your moves:");
	}
	}

}
