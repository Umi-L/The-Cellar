/*
 Business
#Name: string
#Money: int
#Steaks: int
#Quality: double
#Cleanliness: double
#Demand: double
#Debt: int
#CookingEquipment: Equipment
#Chefs: ArrayList<Chef>
#Cleaners: Array<Cleaner>
#Knives: Knife
#FoodType: Food
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
    protected double quality;
    protected double cleanliness;
    protected double demand;
    protected int debt;
    protected Equipment cookingEquipment;
    protected ArrayList<Chef> chefs;
    protected ArrayList<Cleaner> cleaners;
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

    public int GetNetWorth() {
        return money+debt; // TODO: add value of equipment, knives, food, etc.
    }

    public double GetCustomerSatisfaction() {
        // not implemented
        return 0.0;
    }
}
