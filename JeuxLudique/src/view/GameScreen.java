package view;

import java.util.List;

import model.Monster;
import model.Player;

public class GameScreen {

	/**
	 * Displays the welcoming messages.
	 */
	public void welcomeMessage() {
		Console.displayln("Bienvenue dans le plus dangereux donjon des donjons !\n");
		Console.displayln("Oui, en fait, il n'y a pas de fin, de boss, de princesse à délivrer...\n");
		Console.displayln("Vous pouvez seulement vous promener...\n");
	}

	/**
	 * Displays the bad ending messages.
	 */
	public void badEnding() {
		Console.displayln("Busted ! You missed your mission.");
		Console.displayln("La princesse restera captive du méchant POO");
	}

	/**
	 * Displays the good ending messages.
	 */
	public void goodEnding() {
		Console.displayln("Bravo ! Vous avez conquis le donjon et battu ses villaines bêtes");
		Console.displayln("Rejouez s'il vous plaît");
	}

	/**
	 * Displays the current room description.
	 * 
	 * @param currentRoomDescription
	 */
	public void describeCurrentRoom(String currentRoomDescription) {
		Console.displayln("Vous êtes dans " + currentRoomDescription);
	}

	/**
	 * Displays the monster description.
	 * 
	 * @param monsterDescription
	 */
	public void describeMonster(String monsterDescription) {
		Console.displayln("Attention ! Il y a " + monsterDescription);
	}

	/**
	 * Displays the begining fight sequence messages.
	 */
	public void declareFightSequenec() {
		Console.displayln("         />_________________________________");
		Console.displayln("[########[]_________________________________>");
		Console.displayln("         \\>\n");
		Console.displayln("Vous êtes maintenant en phase de combat.");
		Console.displayln("Vous devez vous battre !\n");
	}

	/**
	 * Displays the monster the player is in combat with and his next move.
	 * 
	 * @param monster
	 * @param monsterIsAtacking
	 */
	public void displayMove(Monster monster, boolean monsterIsAtacking) {
		Console.displayln(monster.getName() + "  -  " + monster.getScream(monsterIsAtacking));
	}

	/**
	 * Displays the health points status of the player and the monster he is in combat with.
	 * 
	 * @param player
	 * @param monster
	 */
	public void fightHealthsState(Player player, Monster monster) {
		Console.displayln("Joueur : " + player.getHP() + " pv           " + monster.getHP() + " pv : "
				+ monster.getName() + "\n");
	}

	/**
	 * Displays the actions that took place within the past round.
	 * 
	 * @param player
	 * @param actionToDo
	 * @param monster
	 * @param monsterIsAttacking
	 */
	public void postRound(Player player, PossibleAction actionToDo, Monster monster, boolean monsterIsAttacking) {
		if (actionToDo == PossibleAction.ATTACK && monsterIsAttacking) {
			Console.displayln("Tu as frappé avec ton épée mais tu subis les dégats de son attaque.");
			Console.displayln("[ Joueur  <=  - " + monster.getDamage() + "       - " + player.getDamage() + "  => "
					+ monster.getName() + "]\n");
		} else if (actionToDo == PossibleAction.ATTACK && !monsterIsAttacking) {
			Console.displayln("Tu as pu blesser l'ennemi librement.");
			Console.displayln(
					"[ Joueur  <=  - 0" + "       - " + player.getDamage() + "  => " + monster.getName() + "]\n");
		} else if (actionToDo == PossibleAction.PARRY && monsterIsAttacking) {
			Console.displayln("Tu as parré l'attaque de " + monster.getName() + " et a divisé ses dégats par deux.");
			Console.displayln(
					"[ Joueur  <=  - " + monster.getDamage() / 2 + "       - " + "0  => " + monster.getName() + "]\n");
		} else if (actionToDo == PossibleAction.PARRY && !monsterIsAttacking) {
			Console.displayln(monster.getName() + " n'attaque pas mais restons prudents... ces bêtes sont rapides.\n");
			Console.displayln("[ Joueur  <=  - 0        - 0  => " + monster.getName() + "]");
		}
	}

	/**
	 * Displays the winning messages when the players defeats a monster. 
	 * 
	 * @param monster
	 */
	public void wonFightTo(Monster monster) {
		Console.displayln("Bravo champion ! Tu as vaincu" + monster.getName() + ".\n");
		Console.displayln(
				"Tu as bravement combattu et as donc gagné en force en remportant éternellement une partie de ses dégats.\n");
	}

	/**
	 * Displays the winning messages when the players loses to a monster. 
	 * 
	 * @param monster
	 */
	public void lostFightTo(Monster monster) {
		Console.displayln("Malheureusement tu n'es pas venu à bout de " + monster.getName() + "\n");
	}

	/**
	 * Displays the available actions to the player.
	 * 
	 * @param actions
	 */
	public void proposeAvailableActions(List<Action> actions) {
		for (Action a : actions) {
			Console.displayln("(" + a.getCharToRead() + ") " + a.getMessage() + "\n");
		}
	}

	/**
	 * Reads the String input in the console and returns the possible actions.
	 * 
	 * @param actions
	 * @return result
	 */
	public PossibleAction readActionToDo(List<Action> actions) {
		PossibleAction result = null;

		Interaction.resetKeys();
		for (Action a : actions) {
			Interaction.acceptKey(a.getCharToRead());
		}

		Console.systemeInfo("Votre choix ?");
		char rep = Interaction.readAction();

		for (Action a : actions) {
			if (Character.toLowerCase(rep) == Character.toLowerCase(a.getCharToRead())) {
				result = a.getAction();
				break;
			}
		}

		return result;
	}

}
