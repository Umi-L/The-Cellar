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

import TheCellar.Items.Chefs.TeenChef;
import TheCellar.Items.Equipment.Hotplate;
import TheCellar.Items.Foods.FoodScraps;
import TheCellar.Items.Knives.PlasticKnives;

import java.io.Serializable;
import java.util.ArrayList;

public class Business implements Serializable {
    public String name;
    public long money;
    public int steaks;
    protected double quality; // range from 0-1 representing 0-100%
    protected double cleanliness; // range from 0-1 representing 0-100%
    public long debt;
    protected Equipment cookingEquipment = new Hotplate();
    protected ArrayList<Chef> chefs = new ArrayList<Chef>();
    protected ArrayList<Cleaner> cleaners = new ArrayList<Cleaner>();
    protected Knife knives = new PlasticKnives();
    protected Food food = new FoodScraps();
    protected int daysOfFood = 7;
    public int daysInDebt;
    protected int price;
    
    public Business() {
        // Set the starting net worth to $10,000
        this.money = 10000;

        this.chefs.add(new TeenChef());
        this.cleaners.add(new Cleaner());

        // start price as optimal price
        this.price = Game.baseGoingRate; // default price
    }

    // get net worth, factors in money, equipment, knives, and debt but not employees
    public long GetNetWorth() {
        int equipmentValue = cookingEquipment.getPrice();
        int knifeValue = knives.getPrice();

        return (money + equipmentValue + knifeValue) - debt;
    }

    public double GetCustomerSatisfaction() {
        // customer satisfaction is a range from 0-1 which is calculated using quality and cleanliness
        return (quality + cleanliness) / 2;
    }

    public void PurchaseFood(Food food) {
    	this.food = food;
        money -= food.getPrice();
        this.daysOfFood = 7;
    }

    public void PurchaseEquipment(Equipment equipment) {
    	cookingEquipment = equipment;
        money -= GetEquipmentPrice(equipment);
    }

    public void PurchaseKnife(Knife knife) {
    	knives = knife;
        money -= knife.getPrice();
    }

    public void TakeOutLoan(int amount) {
    	debt += amount;
    	money += amount;
    }

    public int GetEquipmentPrice(Equipment equipment) {
    	int price = equipment.getPrice();

    	// determine if we have prior equipment
        if (cookingEquipment != null) {
            int currIndex = GetEquipmentIndex(cookingEquipment);
            int newIndex = GetEquipmentIndex(equipment);

            // if new equipment is i+1 of current equipment, price is 1.5x
            if (newIndex == currIndex + 1) {
                price = equipment.getUpgradePrice();
            }
        }

        return price;
    }

    protected static int GetEquipmentIndex(Equipment equipment) {
        	int index = 0;
        	for (int i = 0; i < Equipment.EquipmentTypes.length; i++) {
        		if (Equipment.EquipmentTypes[i].getName().equals(equipment.getName())) {
        			index = i;
        			break;
        		}
        	}
        	return index;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void HireCleaner(Cleaner cleaner) {
    	cleaners.add(cleaner);
        money -= cleaner.getPrice();
    }

    public void HireChef(Chef chef) {
    	chefs.add(chef);
        money -= chef.getPrice();
    }

    public void UpgradeEquipment(Equipment equipment) {
    	cookingEquipment = equipment;
        money -= equipment.getPrice();
    }

    public void UpgradeKnife(Knife knife) {
    	knives = knife;
        money -= knife.getPrice();
    }

    public int getExpenses() {
    	int expense = 0;

    	// foreach chef, add price to expense
    	for (Chef chef : chefs) {
    		expense += chef.getPrice();
    	}

    	// foreach cleaner, add price to expense
    	for (Cleaner cleaner : cleaners) {
    		expense += cleaner.getPrice();
    	}

    	// add food price to expenses if there is no food
        if (daysOfFood == 0) {
            expense += food.getPrice();
        }

    	return expense;
    }

    public double GetDemand() {

        // if clenliness is less than 0.1, demand is 0
        if (cleanliness < 0.1) {
            return 0;
        }

        // get all competition
        ArrayList<Business> competition = Main.game.getCompetitors(this);

        // get mean price of competition multiplied by customer satisfaction
        double meanPrice = 0;
        for (Business b : competition) {
            meanPrice += b.price*b.GetCustomerSatisfaction();
        }
        meanPrice /= competition.size();

        // get difference between mean price and our price
        double difference = meanPrice - price;

//        System.out.println("Difference: " + difference);

        // Tweak the curve parameters for a more gradual falloff
        double slope = 1.4;  // Adjust the slope for a more gradual falloff
        double midpoint = 0.5;  // Adjust the midpoint for fine-tuning

        // Apply logistic function to get the curve
        double curve = 1 / (1 + Math.exp(-slope * (difference - midpoint)));

        // Ensure the curve value is between 0 and 1
        curve = Math.max(0, Math.min(1, curve));

        return curve;
    }

    public int GetSteaksPerDay() {
        int steaks = 20; // base steaks per day

        // foreach chef, add steaks to steaks
        for (Chef chef : chefs) {
            steaks += chef.getSteaksPerDayIncrease();
        }

        // foreach food, add steaks to steaks
        steaks += food.getSteaksPerDayIncrease();

        // foreach Knife, add steaks to steaks
        steaks += knives.getSteaksPerDayIncrease();

        // foreach Equipment, add steaks to steaks
        steaks += cookingEquipment.getSteaksPerDayIncrease();

        return steaks;
    }

    public int getProfit() {
        steaks = GetSteaksPerDay();
    	int profit = (int) (steaks * GetDemand() * price);
    	return profit;
    }

    public int getOptimalPrice() {
        int optimalPrice = (int) (food.getQualityModifier() * Main.game.getGoingRate() * GetCustomerSatisfaction());
        return optimalPrice;
    }

    // returns true if debt is paid off
    public boolean PayDebt() {
    	// pay off as much as possible
        if (money > debt) {
            money -= debt;
            debt = 0;
            return true;
        } else {
            debt -= money;
            money = 0;
            return false;
        }
    }

    public void Update() {

        // update cleanliness
        cleanliness = 0;
        for (Cleaner cleaner : cleaners) {
            cleanliness += cleaner.getModifier();
        }

        // if cleanliness is greater than 1, set to 1
        if (cleanliness > 1) {
            cleanliness = 1;
        }

        // update quality
        quality = 0;
        for (Chef chef : chefs) {
            quality += chef.getModifier();
        }

        // calculate profit
        int profit = getProfit();

        money += profit;

        // calculate expenses
        int expenses = getExpenses();

        money -= expenses;
        // if money is less than 0, increment debt
        if (money < 0) {
            debt += Math.abs(money);
            money = 0;
        }

        // if debt is greater than 0, increment days in debt
        if (debt > 0) {
            daysInDebt++;
        } else{
            daysInDebt = 0;
        }

        // if debt is greater than 0 and days in debt is greater than 7, game over
        if (debt > 0 && daysInDebt > 7) {
            GameOver();
        }

        // log inventory and name
        System.out.println(name + " Inventory: " + GetInventory());
    }

    public void GameOver(){
        System.out.println("Game over! for " + name + "!");
    }

    public String GetInventory(){

        String allChefSteaksPerDay = "";
        for (Chef chef : chefs) {
            allChefSteaksPerDay += chef.getSteaksPerDayIncrease() + ", ";
        }

        return "Inventory: \n" +
                "Steaks: " + steaks + "\n" +
                "Quality: " + quality + "\n" +
                "Cleanliness: " + cleanliness + "\n" +
                "Days of Food: " + daysOfFood + "\n" +
                "Days in Debt: " + daysInDebt + "\n" +
                "Money: " + money + "\n" +
                "Debt: " + debt + "\n" +
                "Equipment: " + cookingEquipment.getName() + "\n" +
                "Knife: " + knives.getName() + "\n" +
                "Food: " + food.getName() + "\n" +
                "Chefs: " + chefs.size() + "\n" +
                "Cleaners: " + cleaners.size() + "\n" +
                "Chefs Steaks Per Day: " + allChefSteaksPerDay + "\n" +
                "Food Steaks Per Day: " + food.getSteaksPerDayIncrease() + "\n" +
                "Equipment Steaks Per Day: " + cookingEquipment.getSteaksPerDayIncrease() + "\n" +
                "Knife Steaks Per Day: " + knives.getSteaksPerDayIncrease() + "\n" +
                "Demand: " + GetDemand() + "\n" +
                "Profit: " + getProfit() + "\n" +
                "Price: " + price + "\n" +
                "Optimal Price: " + getOptimalPrice() + "\n" +
                "Net Worth: " + GetNetWorth() + "\n" +
                "Customer Satisfaction: " + GetCustomerSatisfaction() + "\n" +
                "Expenses: " + getExpenses() + "\n";

    }
}
