package controller;

import java.util.ArrayList;
import java.util.List;

import model.GameModel;
import model.Monster;
import model.Player;
import model.Room;
import view.Action;
import view.Console;
import view.GameScreen;
import view.PossibleAction;

/**
 * 
 * Controls the behaviour of the game (the start, the change from room to room,
 * the combat sequences and end of the game).
 * 
 * @author Thomas
 *
 */
public class GameLogic {

	private static final boolean NO_MONSTER_DECISION = false;
	private GameModel gameModel;
	private GameScreen screen;

	private Player player;

	/**
	 * Assigns a GameModel and a GameScreen to the class attributes.
	 * 
	 * @param theRootModel the game model to use
	 * @param theRootView  the game screen to use
	 */
	public GameLogic(GameModel theRootModel, GameScreen theRootView) {
		gameModel = theRootModel;
		screen = theRootView;

		player = gameModel.getPlayer();
	}

	/**
	 * Loops until the player is dead or has won, enabling the player to move
	 * through rooms.
	 */
	public void start() {
		screen.welcomeMessage();

		while (!endOfTheGame()) {

			// DESCRIBE ROOM
			Console.displayln("<====================================================================>\n");
			if (player.getCurrentLocation().getMonster() != null
					&& player.getCurrentLocation().getMonster().isAlive()) {
				screen.describeMonster((String) ((Monster) player.getCurrentLocation().getMonster()).toString());

			} else {
				screen.describeCurrentRoom((String) ((Room) player.getCurrentLocation()).toString());
			}

			// GET CONTEXT & PROPOSE POSSIBLE ACTIONS
			List<Action> contextualPossibleActions = getContextualActions();
			screen.proposeAvailableActions(contextualPossibleActions);

			// GET ACTIONS & DO ACTION
			PossibleAction actionToDo = screen.readActionToDo(contextualPossibleActions);
			doAnAction(actionToDo, NO_MONSTER_DECISION);
		}
		if (player.isAlive()) {
			screen.goodEnding();
		} else {
			screen.badEnding();
		}
	}

	private void fightSequence() {

		player.setInCombat(true);

		screen.declareFightSequenec();

		Monster monster = player.getCurrentLocation().getMonster();

		// COMBAT EN TOUT A TOUR
		while (player.isAlive() && monster.isAlive()) {

			Console.displayln("-+------------------------------------+-\n");

			// DESCRIBE PLAYER AND MONSTER HP
			screen.fightHealthsState(player, monster);

			// DESCRIBE MOVE
			boolean monsterIsAttacking = monster.isFightingNextMove();
			screen.displayMove(monster, monsterIsAttacking);

			// GET CONTEXT AND PROPOSE ACTIONS
			List<Action> contextualPossibleActions = getContextualActions();
			screen.proposeAvailableActions(contextualPossibleActions);

			// GET ACTIONS & DO ACTION
			PossibleAction actionToDo = screen.readActionToDo(contextualPossibleActions);
			doAnAction(actionToDo, monsterIsAttacking);

			// DESCRIBE RESULT OF ACTIONS
			screen.postRound(player, actionToDo, monster, monsterIsAttacking);

		}
		if (player.isAlive()) {
			screen.wonFightTo(monster);
			player.stealStrenth(monster);
			player.setInCombat(false);
		} else {
			screen.lostFightTo(monster);
			player.setInCombat(false);
		}
	}

	/**
	 * Gets the player's options for his next move.
	 * 
	 * @return a list of objects of type Action
	 */
	public List<Action> getContextualActions() {

		List<Action> result = new ArrayList<>();

		// TEXT DIFFERENTES ACTIONS POSSIBLES
		if (player.isInCombat()) {
			result.add(new Action('A', "Attaquer", PossibleAction.ATTACK));
			result.add(new Action('P', "Parer", PossibleAction.PARRY));
		} else if (player.getCurrentLocation().getMonster() != null
				&& player.getCurrentLocation().getMonster().isAlive()) {
			result.add(new Action('C', "Combattre le monstre " + player.getCurrentLocation().getMonster().getName(),
					PossibleAction.FIGHT));
			result.add(new Action('F', "Fuir de la pi?ce", PossibleAction.FLEE));
		} else {
			if (player.getCurrentLocation().getWestRoom() != null) {
				result.add(new Action('O', "Aller vers l'ouest", PossibleAction.GOWEST));
			}
			if (player.getCurrentLocation().getEastRoom() != null) {
				result.add(new Action('E', "Aller vers l'est", PossibleAction.GOEAST));
			}
			if (player.getCurrentLocation().getNorthRoom() != null) {
				result.add(new Action('N', "Aller vers le nord", PossibleAction.GONORTH));
			}
			if (player.getCurrentLocation().getSouthRoom() != null) {
				result.add(new Action('S', "Aller vers le sud", PossibleAction.GOSOUTH));
			}
		}

		return result;
	}

	private void doAnAction(PossibleAction action, boolean monsterIsAttacking) {
		switch (action) {
		case GOWEST:
			player.goWest();
			break;
		case GOEAST:
			player.goEast();
			break;
		case GONORTH:
			player.goNorth();
			break;
		case GOSOUTH:
			player.goSouth();
			break;
		case FIGHT:
			fightSequence();
			break;
		case ATTACK:
			player.attack(monsterIsAttacking);
			break;
		case PARRY:
			player.parry(monsterIsAttacking);
			break;
		case FLEE:
			player.faireDemiTour();
			break;
		}

	}

	private boolean endOfTheGame() {
		boolean playerIsDead = !player.isAlive();
		boolean playerAtLastRoom = player.getCurrentLocation() == gameModel.getDungeon().getEndingRoom();
		boolean currentPlayerLocationHasNoMonster = player.getCurrentLocation().getMonster() == null || !player.getCurrentLocation().getMonster().isAlive();
		return playerIsDead || (playerAtLastRoom && currentPlayerLocationHasNoMonster);
	}

}
