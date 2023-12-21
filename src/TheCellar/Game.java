package TheCellar;/*
TheCellar.Game class for all game data to be stored in.
This is seperated because it needs to be serialized and deserialized.
 */

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import TheCellar.AI.AI;



public class Game implements Serializable {
    public final int numAI = 6;

    public Business PlayerBusiness = new Business();
    public ArrayList<AI> AIBusinesses = new ArrayList<AI>();

    public int GameSpeed = 1000;
    public final int GameSpeedMax = 5000;
    public final int GameSpeedMin = 10;
    public int period = 50;
    public int TotalTime = 0;
    public Timer timer = new Timer();
    public Random random = new Random();

    public ArrayList<TickListener> tickListeners = new ArrayList<TickListener>();

    private int goingRate = 5; // going rate for a steak with 100% quality

    public Game() {
        PlayerBusiness.setName("You");
        Update();
    }


    public void GenerateAI() {
        for (int i = 0; i < numAI; i++) {
            AI ai = AI.generateAI(i);
            AIBusinesses.add(ai);
        }
    }

    public int getGoingRate() {
    	return goingRate;
    }

    public void SetGameSpeed(int speed) {
        GameSpeed = speed;
    }

    public void Update(){

        TotalTime++; // increment total time

        // Calculate the sinusoid value using the Math.sin function
        double sinusoidValue = Math.sin(2 * Math.PI * TotalTime / period); // simulating seasonal changes

        // Alternate the variable value by the sinusoid
        goingRate = (int) (5 + 3 * sinusoidValue);  // Adjust the scaling factor as needed

        // after each period randomize period
        if (TotalTime % period == 0) {
            period = random.nextInt(-25, 25) + 50;
        }

        // update all businesses
        PlayerBusiness.Update();
        for (AI ai : AIBusinesses) {
            ai.Update();
        }

        // set timeout for next tick
        timer.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Update();
                    }
                },
                GameSpeed
        );

        // call tick listeners
        for (TickListener listener : tickListeners) {
            listener.onTick();
        }
    }

    public ArrayList<Business> getCompetitors(Business b){
        // for every business in the game if not the business passed in add to the array
        ArrayList<Business> businesses = new ArrayList<Business>();
        for (AI ai : AIBusinesses) {
            if (ai != b) {
                businesses.add(ai);
            }
        }
        if (PlayerBusiness != b) {
            businesses.add(PlayerBusiness);
        }
        return businesses;
    }

    public void JustLoaded(){
        timer = new Timer();
        random = new Random();
        tickListeners = new ArrayList<TickListener>();

        System.out.println("Game just loaded");
        System.out.println("Game speed: " + GameSpeed);
        System.out.println("Total time: " + TotalTime);

        Update();
    }

    public void addTickListener(TickListener listener) {
        tickListeners.add(listener);
    }

    public void removeTickListener(TickListener listener) {
        tickListeners.remove(listener);
    }
}
