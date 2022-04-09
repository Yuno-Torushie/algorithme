package model;

/**
 * Describes the monster.
 * 
 * @author Thomas
 *
 */
public class Monster implements Entity {

	private static final int DAMAGE = 10;

	private String name;
	private String description;
	private int hp;

	private Room roomLocation;

	/**
	 * Contructor of Monster.
	 * 
	 * @param aName
	 * @param aDescription
	 * @param someHP
	 */
	public Monster(String aName, String aDescription, int someHP) {
		super();
		this.name = aName;
		this.description = aDescription;
		this.hp = someHP;
	}

	/**
	 * Gets the monster's name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the monster's description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the monster's healt points.
	 * 
	 * @return hp
	 */
	public int getHP() {
		return hp;
	}

	// ROOM LOCATION

	/**
	 * Gets the room that the monster is assigned.
	 * 
	 * @return roomLocation
	 */
	public Room getRoomLocation() {
		return roomLocation;
	}

	/**
	 * Sets the room that the monster will be assigned in.
	 * 
	 * @param roomLocation
	 */
	public void setRoomLocation(Room roomLocation) {
		this.roomLocation = roomLocation;
	}

	/**
	 * Returns the monster's information.
	 * 
	 * @return (name, description, hp)
	 */
	@Override
	public String toString() {
		return name + " :\n  " + description + "\n  il a " + hp + " points de vie\n";
	}

	// COMBAT

	/**
	 * Gets the next monster's move in a fighting sequence.
	 * 
	 * @return true : attacking , false : not attacking
	 */
	public boolean isFightingNextMove() {
		// TRUE : FIGHT FALSE : REST
		double randomX = Math.random();
		return (randomX > 0.5);
	}

	/**
	 * Deals damage to the player thus reduces his health points.
	 */
	@Override
	public void attack(boolean isPlayerAttacking) {
		if (isPlayerAttacking) {
			getRoomLocation().getPlayer().reduceHPBy(DAMAGE);
		}
	}

	/**
	 * Gets the monster's damage.
	 * 
	 * @return DAMAGE
	 */
	public int getDamage() {
		return DAMAGE;
	}

	// IS ALIVE

	/**
	 * Tells about the life status of the monster.
	 * 
	 * @return true : alive , false : dead
	 */
	public boolean isAlive() {
		return hp > 0;
	}

	/**
	 * Reduces the monster's health points by an amount given in parameter.
	 */
	@Override
	public void reduceHPBy(int HPReduced) {
		hp = hp - HPReduced;
	}

	// SCREAM

	/**
	 * Gets the scream corresponding to the monster's next move (attack, not
	 * attack).
	 * 
	 * @param monsterIsAtacking
	 * @return res
	 */
	public String getScream(boolean monsterIsAtacking) {
		String res = "";
		if (monsterIsAtacking) {
			res = "Rrooaahh ! À l'attaque !\n";
		} else {
			res = "Hmm... je reste sur mes gardes\n";
		}
		return res;
	}

}
