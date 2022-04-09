package view;

public class Action {

	private char charToRead;
	private String message;
	private PossibleAction actionToDo;

	/**
	 * Constructor of Action.
	 * 
	 * @param charToRead
	 * @param message
	 * @param action
	 */
	public Action(char charToRead, String message, PossibleAction action) {
		super();
		this.charToRead = charToRead;
		this.message = message;
		this.actionToDo = action;
	}

	/**
	 * Gets the character to read.
	 * 
	 * @return charToRead
	 */
	public char getCharToRead() {
		return charToRead;
	}

	/**
	 * Gets the message.
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the possible player's actions.
	 * 
	 * @return actionToDo
	 */
	public PossibleAction getAction() {
		return actionToDo;
	}

}
