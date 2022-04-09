package model;

public class Player implements Entity {

	private static final int STARTING_HP = 70;
	private static final int STARTING_DAMAGE = 15;

	private Room currentLocation;
	private int hp;
	private int damage;
	private boolean inCombat;
	private Room previousLocation;

	/**
	 * Contructor of Player.
	 */
	public Player() {
		super();
		hp = STARTING_HP;
		damage = STARTING_DAMAGE;
		inCombat = false;
	}

	// GO TO

	/**
	 * Makes the player go west.
	 */
	public void goWest() {
		setPreviousLocation(currentLocation);
		currentLocation = currentLocation.getWestRoom();
		currentLocation.setPlayer(this);
	}

	/**
	 * Makes the player go north.
	 */
	public void goNorth() {
		setPreviousLocation(currentLocation);
		currentLocation = currentLocation.getNorthRoom();
		currentLocation.setPlayer(this);
	}

	/**
	 * Makes the player go est.
	 */
	public void goEast() {
		setPreviousLocation(currentLocation);
		currentLocation = currentLocation.getEastRoom();
		currentLocation.setPlayer(this);
	}

	/**
	 * Makes the player go south.
	 */
	public void goSouth() {
		setPreviousLocation(currentLocation);
		currentLocation = currentLocation.getSouthRoom();
		currentLocation.setPlayer(this);
	}

	// CURRENT LOCATION
	
	/**
	 * Gets the room the player is in currenlty.
	 * 
	 * @return currentLocation
	 */
	public Room getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * Sets the room parameter the current room.
	 * 
	 * @param currentLocation
	 */
	public void setCurrentLocation(Room currentLocation) {
		this.currentLocation = currentLocation;
	}

	// PREVIOUS LOCATION
	
	/**
	 * Gets the last room the player was in.
	 * 
	 * @return previousLocation
	 */
	public Room getPreviousLocation() {
		return previousLocation;
	}

	/**
	 * Sets the room parameter as the previous location.
	 * 
	 * @param previousLocation
	 */
	public void setPreviousLocation(Room previousLocation) {
		this.previousLocation = previousLocation;
	}

	// FUIR
	
	/**
	 * Makes the player do a U-turn and go back to his previous location.
	 */
	public void faireDemiTour() {
		if (getCurrentLocation().getWestRoom() == getPreviousLocation()) {
			goWest();
		} else if (getCurrentLocation().getNorthRoom() == getPreviousLocation()) {
			goNorth();
		} else if (getCurrentLocation().getEastRoom() == getPreviousLocation()) {
			goEast();
		} else if (getCurrentLocation().getSouthRoom() == getPreviousLocation()) {
			goSouth();
		}
	}

	// HEALTH
	
	/**
	 * Gets the player health points.
	 * 
	 * @return hp
	 */
	public int getHP() {
		return hp;
	}

	/**
	 * Tells about the life status of the player.
	 * 
	 * @return true : alive , false : dead
	 */
	public boolean isAlive() {
		return hp > 0;
	}

	// COMBAT
	
	/**
	 * Tells us if the player is currently fighting
	 * 
	 * @return true : in combat , false : not in combat
	 */
	public boolean isInCombat() {
		return inCombat;
	}

	/**
	 * Sets the player fight status.
	 * 
	 * @param inCombat
	 */
	public void setInCombat(boolean inCombat) {
		this.inCombat = inCombat;
	}

	/**
	 * Deals damage to the monster the player is fighting thus reduces his health points and gets his health points reduced too.
	 * 
	 * @param isMonsterAttacking
	 */
	@Override
	public void attack(boolean isMonsterAttacking) {

		// DEAL DAMAGE TO MONSTER
		getCurrentLocation().getMonster().reduceHPBy(damage);

		// GET DAMAGE DEALT BY MONSTER
		if (isMonsterAttacking) {
			this.reduceHPBy(getCurrentLocation().getMonster().getDamage());
		}
	}

	/**
	 * Parry an oncomming attack from a monster.
	 * 
	 * @param isMonsterAttacking
	 */
	public void parry(boolean isMonsterAttacking) {

		// GET DAMAGE INFLICTED HALFED BY 2
		if (isMonsterAttacking) {
			this.reduceHPBy(getCurrentLocation().getMonster().getDamage() / 2);
		}
	}

	/**
	 * Reduces the player's health points by the amount given in parameter.
	 * 
	 * @param HPReduced
	 */
	@Override
	public void reduceHPBy(int HPReduced) {
		hp = hp - HPReduced;
	}

	/**
	 * Gets the player's damage.
	 * 
	 * @return damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * Sets the player's damage.
	 * 
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * Gains half of the monster the player has just defeated as bonus damage.
	 * 
	 * @param monster
	 */
	public void stealStrenth(Monster monster) {
		this.damage = this.damage + (int) monster.getDamage() / 2;
	}

}
