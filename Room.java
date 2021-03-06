import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

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
    private Item item;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @param item The item
     */
    public Room(String description) 
    {
        this.description = description;
        this.item = item;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    /**
     * Define the exits of this room.
     * @param direction The possible direction.
     * @param nextRoom The next room.
     */
    public void setExits(String direction, Room nextRoom){
        exits.put(direction, nextRoom);
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
     * @param direction The possible direction
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * Return a description of the room's exits.
     * Example: "Exists: north east west"
     * @return The description of the room's exits
     */
    public String getExitString()
    {
        Set<String> nameOfDirections = exits.keySet();
        String exitsDescription = "Exit: ";
        for(String direction: nameOfDirections){
            exitsDescription += direction + " ";
        }

        return exitsDescription;
    }

    /**
     * Add an item at the current room
     * @param item The item we want to add
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Return a long description of this room, of the form:
     * You are in the 'name of room'
     * Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String descripcionADevolver = "You are " + description + ".\n" + getExitString();
        if(items != null){
            for(Item item: items){
                descripcionADevolver+=  "\n" + item.getDescriptionItems();
            }
        }
        return descripcionADevolver;
    }
}
