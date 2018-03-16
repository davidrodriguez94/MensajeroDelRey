
/**
 * This class create the items for the rooms
 *
 * @author (David Rodriguez)
 * @version (14/03/2018)
 */
public class Item
{
    private String description;
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String description, int weight)
    {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Return the description of the item
     * @return The description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Return the weight of the item
     * @return The weight of the item
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Return the description of the items
     * @return The description of the items
     */
    public String getDescriptionItems()
    {
        return "The item is: " + description + " and their weight is " + weight;
    }
}