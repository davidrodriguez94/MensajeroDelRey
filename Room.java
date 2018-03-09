import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     * @param southEast The southeast exit.
     * @param northEast The northeast exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southEast, Room northEast) 
    {
        if(north != null)
            exits.put("north", north);
        if(east != null)
            exits.put("east", east);
        if(south != null)
            exits.put("south", south);
        if(west != null)
            exits.put("west", west);
        if(southEast != null)
            exits.put("southeast", southEast);
        if(northEast != null)
            exits.put("northeast", northEast);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Return the exists of the current room.
     * @return The exits of the current room
     */
    public Room getExit(String exitDirection)
    {
        Room roomToReturn = null;
        if(exitDirection.equals("north")){
            roomToReturn = exits.get("north");
        }
        if(exitDirection.equals("south")){
            roomToReturn = exits.get("south");
        }
        if(exitDirection.equals("east")){
            roomToReturn = exits.get("east");
        }
        if(exitDirection.equals("west")){
            roomToReturn = exits.get("west");
        }
        if(exitDirection.equals("southeast")){
            roomToReturn = exits.get("southeast");
        }
        if(exitDirection.equals("northeast")){
            roomToReturn = exits.get("northeast");
        }
        return roomToReturn;
    }

    /**
     * Return a description of the room's exits.
     * Example: "Exists: north east west"
     * @return The description of the room's exits
     */
    public String getExitString()
    {
        String exitDescription = "Exists: ";
        
        if(exits.get("north") != null){
            exitDescription += "north ";
        }
        if(exits.get("south") != null){
            exitDescription += "south ";
        }
        if(exits.get("east") != null){
            exitDescription += "east ";
        }
        if(exits.get("west") != null){
            exitDescription += "west ";
        }
        if(exits.get("southeast") != null){
            exitDescription += "southeast ";
        }
        if(exits.get("northeast") != null){
            exitDescription += "northeast ";
        }
        return exitDescription;
    }

}
