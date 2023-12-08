package TheCellar;/*
TheCellar.Game class for all game data to be stored in.
This is seperated because it needs to be serialized and deserialized.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import TheCellar.AI.AI;

public class Game {
    public Business PlayerBusiness = new Business();
    public ArrayList<AI> AIBusinesses = new ArrayList<AI>();

    public int GameSpeed = 1000;
    public final int GameSpeedMax = 5000;
    public final int GameSpeedMin = 10;
    public int TotalTime = 0;
    public Timer timer = new Timer();
    public Random random = new Random();

    private int goingRate = 5; // going rate for a steak with 100% quality

    public Game() {
        Update();
    }

    public int getGoingRate() {
    	return goingRate;
    }

    public void SetGameSpeed(int speed) {
        GameSpeed = speed;
    }

    public void Update(){
        TotalTime++; // increment total time

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
    }
}
