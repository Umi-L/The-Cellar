package TheCellar;/*
TheCellar.Game class for all game data to be stored in.
This is seperated because it needs to be serialized and deserialized.
 */

import java.io.Console;
import java.io.Serializable;
import java.util.*;

import TheCellar.AI.AI;
import TheCellar.GUI.ShopPage;



public class Game implements Serializable {
	public final int numAI = 6;

	public Business PlayerBusiness = new Business();
	public ArrayList<AI> AIBusinesses = new ArrayList<AI>();
    private ArrayList<AI> AIsToRemove = new ArrayList<AI>();

    public static Set<Object> purchasedUpgrades = new HashSet<>();

    public int GameSpeed = 4000;
    public final int GameSpeedMax = 5000;
    public final int GameSpeedMin = 100;
    public static final int MaxDebtDays = 7*4;
    public int period = 50;
    public int TotalTime = 0;
    public Timer timer = new Timer();
    public Random random = new Random();

    private boolean gameIsOver = false;

    public ArrayList<TickListener> tickListeners = new ArrayList<TickListener>();

    private int goingRate = 20; // going rate for a steak with 100% quality
    public static final int baseGoingRate = 40;
    public static final int fluctuation = 5;

    public Game() {
        PlayerBusiness.name = "You";

        timer.schedule(
            new java.util.TimerTask() {
                @Override
                public void run() {
                    Update();
                }
            },
            GameSpeed
        );
    }


    public void GenerateAI() {
        for (int i = 0; i < numAI; i++) {
            AI ai = AI.generateAI(i);
            AIBusinesses.add(ai);
        }
    }

    public void Tick(){
        for (TickListener listener : tickListeners) {
            listener.onTick();
        }
    }

    public void Pause() {
    	timer.cancel();
    }

    public void Resume() {
        timer = new Timer();

    	timer.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Update();
                    }
                },
                GameSpeed
        );
    }

    public int getGoingRate() {
    	return goingRate;
    }

    public void SetGameSpeed(int speed) {
        GameSpeed = speed;
    }

    public void GameOver() {
    	gameIsOver = true;
    }

    public void Update(){

        // if the game is over stop updating
        if (gameIsOver) {
            return;
        }

        TotalTime++; // increment total time

        // Calculate the sinusoid value using the Math.sin function
        double sinusoidValue = Math.sin(2 * Math.PI * TotalTime / period); // simulating seasonal changes

        // Alternate the variable value by the sinusoid
        goingRate = (int) (baseGoingRate + fluctuation * sinusoidValue);  // Adjust the scaling factor as needed

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

        // remove AIs that have lost
        for (AI ai : AIsToRemove) {
            AIBusinesses.remove(ai);
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

    public void RemoveAI(AI ai){
        AIsToRemove.add(ai);
    }
}
