package codigomorse;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Menu {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String m = new String();
		int menu = 0;
		
		do {
			
			try {
				showMenu();
				menu = input.nextInt();
				input.nextLine();
				switch(menu) {
				case 1:
					m = requestInput();
					System.out.printf("%nCoded Message: %s%n%n", Morse.toMorse(m));
					break;
				case 2:
					m = requestInput();
					System.out.printf("%nDecoded Message: %s%n%n", Morse.toEnglish(m));
					break;
				default:
					System.out.print((menu == 3) ? "\nClosing." : "\nEnter a valid number.");
				}
			}
			catch(NoSuchElementException elementException) {
				System.err.println("Invalid input. Try again.");
				input.nextLine();
			}
			
		} while(menu != 3);
	}
	
	public static String requestInput() {
		System.out.print("Insert a message: ");
		String s = input.nextLine();
		
		return s;
	}
	
	public static void showMenu() {
		System.out.printf("%s%n%s%n%s%n%s%n%s%n%n",
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
				"1 - Translate english to morse",
				"2 - Translate morse to english",
				"3 - Exit",
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}