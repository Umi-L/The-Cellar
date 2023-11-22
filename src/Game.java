/*
Game class for all game data to be stored in.
This is seperated because it needs to be serialized and deserialized.
 */

import java.util.ArrayList;

public class Game {
    public Business PlayerBusiness = new Business();
    public ArrayList<AIBusiness> AIBusinesses = new ArrayList<AIBusiness>();
}
