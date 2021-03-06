package versions.v1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import enumeration.Action;
import enumeration.Result;
import versions.Player;
import versions.Score;
import versions.v3.PlayerDispenser;

//2. Implémentation de l'interface
public class PlayerImp extends UnicastRemoteObject implements Player {
	private static final long serialVersionUID = 1L;

	private static final int MAXTURNS = 3; // nombre maximum de tours

	private int turn = 0; // compteur de tours
	private PlayerDispenser dispenser = null; // distributeur d'url

	private String[] name = new String[2]; // noms des 2 joueurs
	private Action[] action = new Action[2]; // actions des 2 joueurs
	private Result[] result = new Result[2]; // résultats des 2 joueurs
	private int[] v = new int[2]; // nombre de victoires des 2 joueurs
	private int nbPlayers = 1; // nombre de joueurs identifiés

	/**
	 * @param dispenser cet objet est nécessaire pour informer le serveur de la
	 *                  nécessité de créer un nouvel objet Player
	 */
	public PlayerImp(PlayerDispenser dispenser) throws RemoteException {
		// A COMPLETER
		this.name[0] = "machine";
		this.v[0] = 0;
		this.v[1] = 0;

	}

	/**
	 * identification du joueur
	 * 
	 * @param name nom avec lequel le joueur s'identifie
	 * @return id avec lequel le joueur peut réaliser des actions
	 */
	public int hello(String name) throws RemoteException, InterruptedException {
		// A COMPLETER
		 if (this.name[0] == null) {
	            System.out.println("Joueur " + name + " identifi?");
	            this.name[0] = name;
	            wait();
	            return 0;
	        }
	            if (this.name[1] == null) {
	                System.out.println("Joueur " + name + " identifi?");
	                this.name[1] = name;
	                notify();
	                System.out.println("Jeu demarr? : " + this.name[0] + " vs " + this.name[1]);
	                return 1;

	        } else {
	            return -1;
	        }

	    }

	/**
	 * action du joueur
	 * @param id
	 * id du joueur
	 * @param action
	 * action du joueur
	 * @return
	 * résultat de l'action
	 */
	public Score play(int id, Action action) throws InterruptedException {
        // A COMPLETER
		this.action[id] = action;
        Score result;
        turn ++;
        this.action[0] = Action.fromInt(new Random().nextInt(3));
        System.out.println(this.name[id] + "->" + action.name());
        System.out.println(this.name[0] + " (" +  this.action[0].name() + ") vs "+ this.name[id]+ " ("+ this.action[id].name()+ ")");
        System.out.println(name[0] + " (" + gagner(this.action[0], action) + ") - " +  name[id] + " ("+ gagner(this.action[id], this.action[0]) + ")" );
        if(gagner(this.action[0], action).equals(Result.PERDU)) {
            this.result[0] = Result.PERDU;
            this.result[id] = Result.GAGNE;
            this.v[id]++;
        }else{
            if(!this.action[0].equals(action)) {
                this.result[0] = Result.GAGNE;
                this.result[id] = Result.PERDU;
                this.v[0]++;
            }
        }
        if(turn == MAXTURNS){
            if(this.v[0] == this.v[id]){
                System.out.println("NUL");
                result = new Score(this.action, this.result[id],Result.NUL);
            } else if (this.v[0] > this.v[id]){
                System.out.println("GAGNE -> "+this.name[0]);
                result = new Score(this.action, this.result[id],Result.PERDU);
            } else {
                System.out.println("GAGNE -> "+this.name[id]);
                result = new Score(this.action, this.result[id],Result.GAGNE);
            }
        } else result = new Score(this.action,this.result[id],null);
        return result;
    }
		


	public Result gagner(Action machine, Action joueur1) {

		if (machine.equals(joueur1)) {
			return Result.NUL;
		}
		if (machine.equals(Action.CISEAUX) && joueur1.equals(Action.FEUILLE)) {
			return Result.GAGNE;
		}
		if (machine.equals(Action.FEUILLE) && joueur1.equals(Action.PIERRE)) {
			return Result.GAGNE;
		}
		if (machine.equals(Action.PIERRE) && joueur1.equals(Action.CISEAUX)) {
			return Result.GAGNE;
		}

		return Result.PERDU;
	}

	/**
	 * obtention du nom du joueur opposant
	 * 
	 * @param id id du joueur
	 * @return le nom du joueur opposant
	 */
	public String getOpponentName(int id) throws RemoteException, InterruptedException {
		// A COMPLETER
			if (id == 1)return this.name[0];
			else return this.name[1];
	}

}