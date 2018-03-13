/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entradaPueblo, plazaPueblo, granjaOvejas, abrevadero, pocilga, posada, baños, habitacionPosadero, castillo, habitacionRey;

        // create the rooms
        entradaPueblo = new Room("at the entrance of the Goldshire village");
        plazaPueblo = new Room("in the main square of the village");
        granjaOvejas = new Room("in the sheep's farm. Why u seek the king here?");
        pocilga = new Room ("in the pigsty. U fall down and pigs eats u. U LOSE!!");
        abrevadero = new Room("in the trough. There's only sheeps and water...");
        posada = new Room("in the inn. Lot of beer and food.");
        baños = new Room ("in the bathroom of the inn. A strange wont let u go. U LOSE!!");
        habitacionPosadero = new Room("in the inn's rooms. Some drunk guys and some suggestive women");
        castillo = new Room("in the castle. 'Maybe' the king is here");
        habitacionRey = new Room("in the king's room. There's the king, finally! YOU WIN THE GAME!!!");

        // initialise room exits
        entradaPueblo.setExits("north", plazaPueblo);
        
        plazaPueblo.setExits("north", castillo);
        plazaPueblo.setExits("east", posada);
        plazaPueblo.setExits("west", granjaOvejas);
        plazaPueblo.setExits("south", entradaPueblo);
        
        granjaOvejas.setExits("south", abrevadero);
        granjaOvejas.setExits("southeast", pocilga);
        
        abrevadero.setExits("north", granjaOvejas);
        
        posada.setExits("north", habitacionPosadero);
        posada.setExits("southeast", baños);
        
        habitacionPosadero.setExits("northwest", castillo);
        habitacionPosadero.setExits("south", posada);
        
        castillo.setExits("north", habitacionRey);
        castillo.setExits("south", plazaPueblo);
        
        habitacionRey.setExits("south", castillo);

        currentRoom = entradaPueblo;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Goldshire village!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You must hurry, The King need it's message");
        System.out.println("as fast as u can.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Print out the location of the delivery courier
     */
    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());
        
        System.out.println();
    }

}