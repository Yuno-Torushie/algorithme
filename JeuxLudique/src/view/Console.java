package view;

public class Console {

	/**
	 * Contructor of Console
	 */
	private Console() {
		super();
	}

	/**
	 * Displays a system information given in parameter.
	 * 
	 * @param s system information to display
	 */
	public static void systemeInfo(String s) {
		System.out.print("\n>>>\t" + s + "\n");
	}

	/**
	 * Displays a system information given in parameter and a carriage return.
	 * 
	 * @param s system information to display
	 */
	public static void systemeInfoln(String s) {
		systemeInfo(s + "\n");
	}

	/**
	 * Displays the string given in parameter.
	 * 
	 * @param s information to display
	 */
	public static void display(String s) {
		System.out.print(s);

		Interaction.pause(1);
		// Interaction.pause(0);
	}

	/**
	 * Displays carriage return and the string given in parameter.
	 * 
	 * @param s information to display
	 */
	public static void displayln(String s) {
		display("\n" + s);
	}
}
