package Model;

public abstract class RoomWithSomething {
  
	private String description;
    
    public RoomWithSomething(final String desc) {
        this.description = desc;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public String toString() {
        return this.getDescription();
    }
}
