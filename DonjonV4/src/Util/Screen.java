package Util;

public class Screen {
	
	public void welcomeMessage() {
        Console.affiche("Bienvenue dans le Donjon");
        Console.affiche("Votre but est de sauv� la fameuse et magnifique Princesse Yuno qui � �t� emprison�e.\n");
        Console.affiche("Votre but vous �chapper du Donjon en r�solvant les fameuse tables de math�matqiues");
	}
		  
	public void goodEnding() {
        Console.afficheln("F�licitations ! Vous avez Lib�r�s la princesse.\nVous pouvez d�sapr�sent en faire ce que vous voulez.");
        Console.affiche("F�licitations ! Vous avez r�ussi � vous �chapper du Donjon, Vous �tes maintenant Turbo-Fort dans les tables de Math�matiques");
		Console.afficheln("FIN !");
    }
	
	public void badEnding() {
        Console.afficheln("Game Over ! Vous �tes un vrai cancre.");
    }
	
	public void choix() {
        Console.info("\nQue choisissez-vous de faire ?");
	}
	
	public void goNorth() {
        Console.info("(N) Pour aller au NORD");
	}
	
	public void goSouth() {
        Console.info("(S) Pour aller au SUD");
	}
	
	public void goWest() {
        Console.info("(O) Pour aller � l'OUEST");
	}
	
	public void goEast() {
        Console.info("(E) Pour aller � l'EST");
	}
	
	public void free() {
        Console.info("(L) Pour lib�r� la Princesse.");
	}

}
