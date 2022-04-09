package Model;

import java.util.*;

public class Dungeon {
	
    private List<Room> rooms;
    private Room startingRoom;
    private Princess Yuno;
    
    public Dungeon() {
        this.rooms = new ArrayList<Room>();
        this.initRooms();
    }
    
    private void initRooms() {
        this.Yuno = new Princess("la magnifique Yuno, qui sait tous!");
        
        //PartieO
        final Room entry = new Room("L'entré du donjon.");
        final Room cross11 = new Room("un croisement avec des portes dans toutes les directions.");
        entry.setNorthRoom(cross11);
        
        //Partie1
        final Room roomT11 = new Room("une grande salle vide");
        final Room coridorH11 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room roomChest11 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        final Room roomChest12 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        roomT11.setSouthRoom(roomChest11);
        roomT11.setWestRoom(coridorH11);
        coridorH11.setWestRoom(roomChest12);

        
        //Partie2
        final Room roomL21 = new Room("une grande salle vide.");
        final Room roomL22 = new Room("une grande salle vide.");
        final Room roomChest21 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        roomL21.setSouthRoom(roomL22);
        roomL22.setEastRoom(roomChest21);
        
        //Partie3
        final Room cross31 = new Room("un croisement avec des portes dans toutes les directions.");
        final Room coridorH31 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room roomL31 = new Room("une petite salle.");
        final Room roomChest31 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        final Room coridorV31 = new Room("un couloir tout ce qu'il y a de plus banal.");
        cross31.setEastRoom(coridorH31);
        cross31.setNorthRoom(coridorV31);
        coridorH31.setEastRoom(roomL31);
        roomL31.setSouthRoom(roomChest31);
        
        //Partie4
        final Room coridorH41 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room coridorH42 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room roomChest41 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        coridorH41.setWestRoom(coridorH42);
        coridorH42.setWestRoom(roomChest41);

        //Partie5
        final Room coridorH51 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room coridorChest51 = new Room("un couloir mais il semble y avoir quelque chose dans la pièce.");
        coridorH51.setNorthRoom(coridorChest51);
        
        //Partie6
        final Room roomBoss = new Room("une salle massivement grande.");
        final Room roomPrincess = new Room("une petite salle cosy.");
        roomBoss.setNorthRoom(roomPrincess);
        roomPrincess.setElementInRoom((RoomWithSomething)this.Yuno);
        
        //Relation entre les Parties
        cross11.setWestRoom(roomT11);
        cross11.setEastRoom(roomL21);
        cross11.setNorthRoom(cross31);
        cross31.setWestRoom(coridorH41);
        coridorV31.setNorthRoom(coridorH51);
        coridorChest51.setNorthRoom(roomBoss);
        this.setStartingRoom(entry);
    }
    
    public Room getStartingRoom() {
        return this.startingRoom;
    }
    
    public void setStartingRoom(final Room startingRoom) {
        this.startingRoom = startingRoom;
    }
    
    public Princess getYuno() {
        return this.Yuno;
    }
}
