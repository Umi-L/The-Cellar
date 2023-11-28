package TheCellar;/*
TheCellar.Game class for all game data to be stored in.
This is seperated because it needs to be serialized and deserialized.
 */

import java.util.ArrayList;

import TheCellar.AI.AI;

public class Game {
    public Business PlayerBusiness = new Business();
    public ArrayList<AI> AIBusinesses = new ArrayList<AI>();

    private int goingRate;

    public Game() {
    	goingRate = 5; // avg price of steak with quality of 50%
    }

    public int getGoingRate() {
    	return goingRate;
    }
}
