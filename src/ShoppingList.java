import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Grand Circus Market! \n");

		String cont = "y";

		HashMap<String, Double> inventory = new HashMap<>();

		inventory = fillInventory(inventory);

		displayInventory(inventory);

		ArrayList<String> shoppingCart = new ArrayList<String>();

		while (cont.equalsIgnoreCase("y")) {

			System.out.println();
			String prompt = "Please type in the item you want: ";

			String userInput;
			System.out.println(prompt);
			userInput = scan.nextLine();
			
			if (inventory.containsKey(userInput)) { 
				System.out.println("Added " + userInput + ".");
				shoppingCart.add(userInput);
			} else {
				System.out.println("Sorry, we don't have that in stock.");
			}

			System.out.println("Add another item? (y/n): "); // if yes, repeat loop
			cont = scan.nextLine();
			if ((!cont.equalsIgnoreCase("y")) && (!cont.equalsIgnoreCase("n"))) {
				System.out.println("Please enter (y/n)!");
				cont = scan.nextLine();
			}
		}

		System.out.println("The average price is: $" + average(shoppingCart, inventory));
		System.out.println("The highest price is: $" + highest(shoppingCart, inventory));
		System.out.println("The lowest price is: $" + lowest(shoppingCart, inventory));

		System.out.println("Goodbye!");
		scan.close();

	}


	private static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {
		inventory.put("garlic", 1.99);
		inventory.put("broccoli", 2.99);
		inventory.put("one dozen eggs", 1.49);
		inventory.put("bananas", 3.49);
		inventory.put("tofu", 3.99);
		inventory.put("kale", 4.49);
		inventory.put("mangos", 4.99);
		inventory.put("kobe beef", 39.99);

		return inventory;
	}

	public static void displayInventory(HashMap<String, Double> inventory) {
		String format1 = "%-15s     %s%n";
		String format2 = "%-15s  $  %s%n";
		System.out.printf(format1, "Item", "Price");
		System.out.println("=========================");
		for (String item : inventory.keySet()) {
			System.out.printf(format2, item, inventory.get(item));
		}

	}

	// average method
	public static double average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double average = 0.0;
		double sum = 0.0;//the total price, added together
		int count = 0; //the number of individual items
		for ( String item : shoppingCart ) {
			sum += inventory.get(item);
			count++;
		}
		average = sum/count;
		return average;
	}

	// highest method
	public static double highest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double highest = 0.0;
		for (String item : shoppingCart) {
			if (highest < inventory.get(item)) {
				highest = inventory.get(item);
			}
		}
		return highest;
	}

	// lowest method
	public static double lowest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double lowest = -1.0;
		for (String item : shoppingCart) {
			if (lowest == -1.0) {
				lowest = inventory.get(item);
			}
			if (inventory.get(item) < lowest) {
				lowest = inventory.get(item);
			}
		}
		return lowest;
	}
}
