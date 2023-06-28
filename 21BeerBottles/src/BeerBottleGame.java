import java.util.Random;
import java.util.Scanner;

public class BeerBottleGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("There are 21 beer bottles...");
		System.out.println("There are 2 players - Computer and you.");
		System.out.println("At a time, each one can pick up any no. of bottles between 1 and 4 (inclusive)");
		System.out.println("Will you like to play first?");
		
		String first = null;
		first = input.next();
		
		int bottles = 21;
		Random rng = new Random();
		
		if (first.equals("Yes")) {
			while (bottles > 1) {
				System.out.println("How many you would like to pick up?");
				int choice = input.nextInt();
				while (choice < 1 || choice > 4) {
					System.out.println("Invalid input. Try again");
					choice = input.nextInt();
				}
				System.out.println("Computer has picked " + (5-choice));
				bottles -= 5;
				System.out.println("The bottles remaining are: " + bottles);
			}
			System.out.println("You will have to pick up the last..you are loser");
		} else {
			boolean lost = true;
			while (bottles > 1) {
				int remainder = bottles % 5;
				if (remainder == 1) {
					int randomNumber = rng.nextInt(3) + 1;
					System.out.println("Computer has picked " + randomNumber);
					bottles -= randomNumber;
					System.out.println("The bottles remaining are: " + bottles);
				} else {
					lost = false;
					int number = (remainder+4)%5;
					System.out.println("Computer has picked " + number);
					bottles -= number;
					System.out.println("The bottles remaining are: " + bottles);
					if (bottles == 1) {
						break;
					}
				}
				System.out.println("How many you would like to pick up?");
				int choice = input.nextInt();
				while (choice < 1 || choice > 4) {
					System.out.println("Invalid input. Try again");
					choice = input.nextInt();
				}	
				bottles -= choice;
			}
			if (lost) {
				System.out.println("I will have to pick up the last..you are winner");
			} else {
				System.out.println("You will have to pick up the last..you are loser");
			}
		}

	}

}
