package Model;

public class Door {
    private Room room1;
    private Room room2;
    
    public Door(final Room room1, final Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }
    
    public Room getRoom1() {
        return this.room1;
    }
    
    public Room getRoom2() {
        return this.room2;
    }
    
    public Room getOppositeRoom(final Room aRoom) throws DungeonBuildException {
        if (this.getRoom1().equals(aRoom)) {
            return this.getRoom2();
        }
        if (this.getRoom2().equals(aRoom)) {
            return this.getRoom1();
        }
        throw new DungeonBuildException("il y a un faille Spatio-Temporelle entre les 2 salles.");
    }
}
