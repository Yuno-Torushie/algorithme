package model;

/**
 * Centralizes the instances of the game's elements.
 * 
 * @author Thomas
 *
 */
public class GameModel {

	private Dungeon theDungeon;
	private Player thePlayer;

	/**
	 * Instantializes its attributes.
	 */
	public GameModel() {
		theDungeon = new Dungeon();
		thePlayer = new Player();
		thePlayer.setCurrentLocation(theDungeon.getStartingRoom());
	}

	/**
	 * Returns the player attribut.
	 * 
	 * @return thePlayer
	 */
	public Player getPlayer() {
		return thePlayer;
	}

	/**
	 * Returns the dungeon attribut.
	 * 
	 * @return theDungeon
	 */
	public Dungeon getDungeon() {
		return theDungeon;
	}

}
