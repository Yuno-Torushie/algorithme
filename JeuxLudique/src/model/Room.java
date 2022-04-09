package model;

public class Room {

	// ATTRIBUTES
	private String name;
	private String description;
	private Room northRoom;
	private Room southRoom;
	private Room eastRoom;
	private Room westRoom;
	private Monster monster;
	private Player player;

	/**
	 * Constructor of Room.
	 * 
	 * @param aName
	 * @param aDesription
	 */
	public Room(String aName, String aDesription) {
		this.name = aName;
		this.description = aDesription;
	}

	// GETTERS
	
	/**
	 * Gets the name of the room.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the description of the room.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the monster located in the room.
	 * 
	 * @return monster
	 */
	public Monster getMonster() {
		return monster;
	}
	
	/**
	 * Gets the player located in the room currently.
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}

	// GET ROOM
	
	/**
	 * Get the room to the north of this room.
	 * 
	 * @return northRoom
	 */
	public Room getNorthRoom() {
		return this.northRoom;
	}

	/**
	 * Get the room to the south of this room.
	 * 
	 * @return southRoom
	 */
	public Room getSouthRoom() {
		return this.southRoom;
	}

	/**
	 * Get the room to the east of this room.
	 * 
	 * @return eastRoom
	 */
	public Room getEastRoom() {
		return this.eastRoom;
	}

	/**
	 * Get the room to the west of this room.
	 * 
	 * @return westRoom
	 */
	public Room getWestRoom() {
		return this.westRoom;
	}

	// SET ROOM
	
	/**
	 * Sets the Room parameter as the room the north.
	 * 
	 * @param aNorthRoom
	 */
	public void setNorthRoom(Room aNorthRoom) {
		this.northRoom = aNorthRoom;
		if (aNorthRoom.getSouthRoom() == null) {
			aNorthRoom.setSouthRoom(this);
		}
	}

	/**
	 * Sets the Room parameter as the room the south.
	 * 
	 * @param aSouthRoom
	 */
	public void setSouthRoom(Room aSouthRoom) {
		this.southRoom = aSouthRoom;
		if (aSouthRoom.getNorthRoom() == null) {
			aSouthRoom.setNorthRoom(this);
		}
	}

	/**
	 * Sets the Room parameter as the room the east.
	 * 
	 * @param aEastRoom
	 */
	public void setEastRoom(Room aEastRoom) {
		this.eastRoom = aEastRoom;
		if (aEastRoom.getWestRoom() == null) {
			aEastRoom.setWestRoom(this);
		}
	}

	/**
	 * Sets the Room parameter as the room the west.
	 * 
	 * @param aWestRoom
	 */
	public void setWestRoom(Room aWestRoom) {
		this.westRoom = aWestRoom;
		if (aWestRoom.getEastRoom() == null) {
			aWestRoom.setEastRoom(this);
		}
	}

	// SET MONSTER & PLAYER
	
	/**
	 * Sets the monster it is assigned.
	 * 
	 * @param monster
	 */
	public void setMonster(Monster monster) {
		this.monster = monster;
		monster.setRoomLocation(this);
	}
	
	/**
	 * Sets the player which has this room as his current room.
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	// TO STRING
	
	/**
	 * Returns the room's information.
	 * 
	 * @return res
	 */
	@Override
	public String toString() {
		String res = description + " :\n";

		if (this.northRoom != null) {
			res += "  North - " + this.northRoom.getName() + "\n";
		}
		if (this.southRoom != null) {
			res += "  South- " + this.southRoom.getName() + "\n";
		}
		if (this.eastRoom != null) {
			res += "  East - " + this.eastRoom.getName() + "\n";
		}
		if (this.westRoom != null) {
			res += "  West - " + this.westRoom.getName() + "\n";
		}
		if (this.monster != null && this.monster.isAlive()) {
			res += "\n" + "Un monstre ! " + this.monster + "\n";
		}

		return res;
	}

}
