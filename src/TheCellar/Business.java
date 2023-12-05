package TheCellar;/*
 TheCellar.Business
#Name: string
#Money: int
#Steaks: int
#Quality: double
#Cleanliness: double
#Demand: double
#Debt: int
#CookingEquipment: TheCellar.Equipment
#Chefs: ArrayList<TheCellar.Chef>
#Cleaners: Array<TheCellar.Cleaner>
#Knives: TheCellar.Knife
#food: TheCellar.Food
#DaysOfFood: int
#DaysInDebt: int
+GetNetWorth(): int
+GetCustomerSatisfaction(): double
get&set for all fields

 */

import TheCellar.Foods.FoodScraps;

import java.util.ArrayList;

public class Business {
    protected String name;
    protected int money;
    protected int steaks;
    protected double quality; // range from 0-1 representing 0-100%
    protected double cleanliness; // range from 0-1 representing 0-100%
    protected double demand;
    protected int debt;
    protected Equipment cookingEquipment;
    protected ArrayList<Chef> chefs = new ArrayList<Chef>();
    protected ArrayList<Cleaner> cleaners = new ArrayList<Cleaner>();
    protected Knife knives;
    protected Food food = new FoodScraps();
    protected int daysOfFood;
    protected int daysInDebt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public int getSteaks() {
        return steaks;
    }

    public void setSteaks(int steaks) {
        this.steaks = steaks;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    // get net worth, factors in money, equipment, knives, and debt but not employees
    public int GetNetWorth() {
        int equipmentValue = cookingEquipment.getPrice();
        int knifeValue = knives.getPrice();

        return (money + equipmentValue + knifeValue) - debt;
    }

    public double GetCustomerSatisfaction() {
        // customer satisfaction is a range from 0-1 which is calculated using quality and cleanliness
        return (quality + cleanliness) / 2;
    }

    public void Update() {
        // foreach chef, update
        for (Chef chef : chefs) {
            // subtract price of chef from money
            money -= chef.getPrice();
        }

        // foreach cleaner, update
        for (Cleaner cleaner : cleaners) {
            // subtract price of cleaner from money
            money -= cleaner.getPrice();
        }

        // calculate profit
        int profit = (int) (steaks * food.getModifier() * GetCustomerSatisfaction());

        // if debt is greater than 0, increment days in debt
        if (debt > 0) {
            daysInDebt++;
        } else{
            daysInDebt = 0;
        }

        // if debt is greater than 0 and days in debt is greater than 4, game over
        if (debt > 0 && daysInDebt > 4) {
            // game over
            System.out.println("Game over!");
        }
    }
}
