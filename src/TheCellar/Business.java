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
#FoodType: TheCellar.Food
#DaysOfFood: int
#DaysInDebt: int
+GetNetWorth(): int
+GetCustomerSatisfaction(): double
get&set for all fields

 */

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
    protected Food foodType;
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

    public void setMoney(int money) {
        this.money = money;
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

    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public Equipment getCookingEquipment() {
        return cookingEquipment;
    }

    public void setCookingEquipment(Equipment cookingEquipment) {
        this.cookingEquipment = cookingEquipment;
    }

    public ArrayList<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(ArrayList<Chef> chefs) {
        this.chefs = chefs;
    }

    public ArrayList<Cleaner> getCleaners() {
        return cleaners;
    }

    public void setCleaners(ArrayList<Cleaner> cleaners) {
        this.cleaners = cleaners;
    }

    public Knife getKnives() {
        return knives;
    }

    public void setKnives(Knife knives) {
        this.knives = knives;
    }

    public Food getFoodType() {
        return foodType;
    }

    public void setFoodType(Food foodType) {
        this.foodType = foodType;
    }

    public int getDaysOfFood() {
        return daysOfFood;
    }

    public void setDaysOfFood(int daysOfFood) {
        this.daysOfFood = daysOfFood;
    }

    public int getDaysInDebt() {
        return daysInDebt;
    }

    public void setDaysInDebt(int daysInDebt) {
        this.daysInDebt = daysInDebt;
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


    }
}
