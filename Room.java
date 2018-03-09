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
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room southEastExit;
    private Room northEastExit;
    private String exitDirection;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
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
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(southEast != null)
            southEastExit = southEast;
        if(northEast != null)
            northEastExit = northEast;
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
            roomToReturn = northExit;
        }
        if(exitDirection.equals("south")){
            roomToReturn = southExit;
        }
        if(exitDirection.equals("east")){
            roomToReturn = eastExit;
        }
        if(exitDirection.equals("west")){
            roomToReturn = westExit;
        }
        if(exitDirection.equals("southeast")){
            roomToReturn = southEastExit;
        }
        if(exitDirection.equals("northeast")){
            roomToReturn = northEastExit;
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
        
        if(northExit != null){
            exitDescription += "north ";
        }
        if(southExit != null){
            exitDescription += "south ";
        }
        if(eastExit != null){
            exitDescription += "east ";
        }
        if(westExit != null){
            exitDescription += "west ";
        }
        if(southEastExit != null){
            exitDescription += "southeast ";
        }
        if(northEastExit != null){
            exitDescription += "northeast ";
        }
        return exitDescription;
    }

}
