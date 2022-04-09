package model;

/**
 * Initializes the rooms and its structure as well as its monsters.
 * 
 * @author thoma
 *
 */
public class Dungeon {

	private Room startingRoom;
	private Room endingRoom;

	/*
	 * Calls the initRooms method to create the Dungeon
	 */
	public Dungeon() {
		super();
		initRooms();
	}

	private void initRooms() {

		Room entry = new Room("L'entrée", "une petite pièce banale avec un paillasson \"Bienvenue\"");
		Room hall = new Room("Le hall", "un grand espace éclairé par un beau lustre");
		Room cave = new Room("La cave", "un sombre escalier vers une cave remplie d'araignées");
		Room armurerie = new Room("L'armurerie", "une pièce pleine à craquer d'armes et d'équipement");
		Room couloir = new Room("Le couloir", "un simple et long couloir avec la peinture qui part");
		Room cuisine = new Room("La cuisine", "la kouisine");
		Room chambre = new Room("La chambre", "une somptueuse chambre à couché");

		entry.setNorthRoom(hall);
		hall.setNorthRoom(armurerie);
		hall.setEastRoom(cave);
		armurerie.setEastRoom(couloir);
		couloir.setEastRoom(cuisine);
		cuisine.setSouthRoom(chambre);

		couloir.setMonster(new Monster("Bob razowski", "un petit monstre rond et tout vert", 30));
		chambre.setMonster(new Monster("Jacques Sullivan", "un grand monstre terrifiant poilu aux grandes dents", 60));

		startingRoom = entry;
		endingRoom = chambre;

	}

	/**
	 * Gets an object of type Room.
	 * 
	 * @return startingRoom the room the player will appear in
	 */
	public Room getStartingRoom() {
		return startingRoom;
	}

	/**
	 * Gets an object of type Room.
	 * 
	 * @return endingRom the room that leads the player to victory
	 */
	public Room getEndingRoom() {
		return endingRoom;
	}

}
