package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Interaction {

	private static Scanner entree = new Scanner(System.in);

	private static Set<Character> keys = new HashSet<>();

	/**
	 * Constructor of Interaction.
	 */
	private Interaction() {
		super();
	}

	/**
	 * Reads the next String input.
	 * 
	 * @return the String input
	 */
	public static String lireString() {
		return entree.nextLine();
	}
	
	/**
	 * Reads the next int input.
	 * 
	 * @return the String input
	 */
	public static int lireInt() {
		return entree.nextInt();
	}

	/**
	 * Sets a new instance of HashSet to keys. 
	 */
	public static void resetKeys() {
		keys = new HashSet<>();
	}

	/**
	 * Adds the caracter value of the parameter to keys.
	 * 
	 * @param c
	 */
	public static void acceptKey(char c) {
		keys.add(Character.valueOf(c));
	}

	/**
	 * Reads the action.
	 * 
	 * @return c
	 */
	public static char readAction() {
		char c;
		boolean out = false;
		do {
			Console.display(" => ");
			c = entree.next(".*").charAt(0);
			for (Character car : keys) {
				if (Character.toUpperCase(car) == Character.toUpperCase(c)) {
					out = true;
				}
			}
		} while (!out);
		entree.nextLine();
		return c;
	}

	/**
	 * Slows down the display rate in the console.
	 * 
	 * @param sec
	 */
	public static void pause(int sec) {
		try {
			Thread.sleep((long) (sec * 500));
		} catch (InterruptedException e) {
			Console.systemeInfoln("Exception");
			Thread.currentThread().interrupt();
		}
	}
}
