package Model;

import Util.*;

import java.util.*;

public class Player {
	private static final int STARTING_HP = 200;

    private Room currentLocation;
    private Room previousLocation;
    private int hp;
    
    public Player() {
        this.hp = 200;
    }
    
    public Room getCurrentLocation() {
        return this.currentLocation;
    }
    
    public void setCurrentLocation(final Room currentLocation) {
        this.previousLocation = this.currentLocation;
        this.currentLocation = currentLocation;
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public boolean isAlive() {
        return this.hp > 0;
    }
    
    public void goNorth() {
        final Door door = this.currentLocation.getNorthDoor();
        try {
            this.setCurrentLocation(this.currentLocation.getNorthDoor().getOppositeRoom(this.currentLocation));
            Console.afficheln("Vous avez d?cider de passer par la porte NORD.");
            }
        catch (DungeonBuildException e) {
            e.printStackTrace();
        }
    }
    
    public void goSouth() {
        final Door door = this.currentLocation.getSouthDoor();
        try {
            this.setCurrentLocation(this.currentLocation.getSouthDoor().getOppositeRoom(this.currentLocation));
            Console.afficheln("Vous avez d?cider de passer par la porte SUD.");
        }
        catch (DungeonBuildException e) {
            e.printStackTrace();
        }
    }
    
    public void goWest() {
        final Door door = this.currentLocation.getWestDoor();
        try {
            this.setCurrentLocation(this.currentLocation.getWestDoor().getOppositeRoom(this.currentLocation));
            Console.afficheln("Vous avez d?cider de passer par la porte OUEST.");;
        }
        catch (DungeonBuildException e) {
            e.printStackTrace();
        }
    }
    
    public void goEast() {
        final Door door = this.currentLocation.getEastDoor();
        try {
            this.setCurrentLocation(this.currentLocation.getEastDoor().getOppositeRoom(this.currentLocation));
            Console.afficheln("Vous avez d?cider de passer par la porte EST.");
        }
        catch (DungeonBuildException e) {
            e.printStackTrace();
        }
    }
    
    public void free(final Princess princess) {
        princess.setFree(true);
        Console.afficheln("Vous lib?rez la Princesse");
        Console.afficheln("Vous ?tes maintenant r?uni et vous vous pr?cipitez vers le lit...");
    }
}
