package versions.v1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import enumeration.Action;
import versions.Player;
import versions.Score;

public class Client {
	public static void main(String[] args) throws RemoteException, InterruptedException, MalformedURLException, NotBoundException {
		Scanner  kb     = new Scanner(System.in);
		String   line;        //reponse du joueur
		Player   player;    // objet
		String   name;            // nom du joueur
		String   opponentName;  // nom de l'opposant
		int      id;            // id du joueur
		Score    r=null;                // résultat

		String url;
		// A COMPLETER

		//System.setSecurityManager(new RMISecurityManager());


		// 6. Obtention de la r?f?rence de l'objet distant
		//player = (Player) Naming.lookup("rmi://172.18.67.165/PFC");
		player = (Player) Naming.lookup("rmi://localhost/PFC");
		System.out.println("nom du joueur?");
		name = kb.nextLine();
		System.out.println("Reference player obtenu : rmi://localhost/PFC");


		// 7. Invocation de la m?thode sur l'objet distant
		id = player.hello(name);
		if (id!= -1) {
			while(r == null || r.getGameResult()==null) {
				System.out.println("Que voulez vous jouer?");
				line = kb.nextLine();
				switch (line) {
				case "PIERRE":
					r = player.play(id,Action.PIERRE);
					break;
				case "FEUILLE":
					r = player.play(id,Action.FEUILLE);
					break;
				case "CISEAUX":
					r = player.play(id,Action.CISEAUX);
					break;
				default:
					break;
				}
				// appeller la fonction play
				System.out.println(r.getAction()[0] + " / " + r.getAction()[1] + " - " + r.getResult());
			}
			System.out.println(r.getGameResult());

		}else System.out.println("Plus de place dans la file");
	}
}