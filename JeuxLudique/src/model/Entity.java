package model;

/**
 * Contains the methods that Player and Monster use.
 * 
 * @author Thomas
 *
 */
public interface Entity {

	/**
	 * Get the object health points.
	 * 
	 * @return health points as an integer
	 */
	public int getHP();

	/**
	 * Is responsible for the behavior of the object attacking.
	 * 
	 * @param isAttacking true if the enemy is attacking
	 */
	public void attack(boolean isAttacking);

	/**
	 * Lowers the health of the object.
	 * 
	 * @param HPReduced the amount of health points to take from the object
	 */
	public void reduceHPBy(int HPReduced);

}
