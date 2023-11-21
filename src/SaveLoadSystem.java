import java.io.*;

public class SaveLoadSystem {
    // save file path
    private static final String path = "./save.sav"; // variable is final because it is a runtime constant

    // function to save a game object to the save file
    public static void saveGame(Game game) {
        // save game object to a file
        try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(path))) // create a new file output stream and object output stream
        {
            write.writeObject(game); // write game object to file. It's that easy!
        }
        catch(NotSerializableException nse) // catch any non-serializable exceptions (may occur if the class is recursive)
        {
            throw new RuntimeException("Game class is not serializable!" + nse.getMessage());
        }
        catch(IOException eio) // catch any IO exceptions (file not found, etc.
        {
            throw new RuntimeException("Error writing to file!" + eio.getMessage());
        }
    }

    public static Game loadGame(){
        // load Main.game from a file
        Game game = null;

        try(ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path)))
        {
            game = (Game) inFile.readObject();
            return game;
        }
        catch(ClassNotFoundException cnfe)
        {
            throw new RuntimeException("Game class not found!" + cnfe.getMessage()); // Should never appear because only the game class is being serialized to this file
        }
        catch(FileNotFoundException fnfe)
        {
            throw new RuntimeException("Save file not found!" + fnfe.getMessage()); // most likely save file not found
        }
        catch(IOException e) // catch any IO exceptions (file not found, etc.)
        {
            throw new RuntimeException("Error loading game!" + e.getMessage()); // most likely save file not found
        }

        // no return needed here because all exceptions will throw a runtime exception
    }
}
