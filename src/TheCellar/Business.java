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

import TheCellar.Items.Equipment.Hotplate;
import TheCellar.Items.Foods.FoodScraps;
import TheCellar.Items.Knives.PlasticKnives;

import java.io.Serializable;
import java.util.ArrayList;

public class Business implements Serializable {
    protected String name;
    protected int money;
    protected int steaks;
    protected double quality; // range from 0-1 representing 0-100%
    protected double cleanliness; // range from 0-1 representing 0-100%
    protected int debt;
    protected Equipment cookingEquipment = new Hotplate();
    protected ArrayList<Chef> chefs = new ArrayList<Chef>();
    protected ArrayList<Cleaner> cleaners = new ArrayList<Cleaner>();
    protected Knife knives = new PlasticKnives();
    protected Food food = new FoodScraps();
    protected int daysOfFood;
    protected int daysInDebt;
    protected int price;

    public void setDebt(int NewDebt) {
    	debt = NewDebt;
    }
    
    public int getDebt() {
    	return debt;
    }
    
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

    public void PurchaseFood(Food food) {
    	this.food = food;
        setMoney(money -= food.getPrice());
        this.daysOfFood = 7;
    }

    public void PurchaseEquipment(Equipment equipment) {
    	cookingEquipment = equipment;
        setMoney(money -= GetEquipmentPrice(equipment));
    }

    public void PurchaseKnife(Knife knife) {
    	knives = knife;
        setMoney(money -= knife.getPrice());
    }

    public void TakeOutLoan(int amount) {
    	debt += amount;
    	setMoney(money += amount);
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
        setMoney(money -= cleaner.getPrice());
    }

    public void HireChef(Chef chef) {
    	chefs.add(chef);
        setMoney(money -= chef.getPrice());
    }

    public void UpgradeEquipment(Equipment equipment) {
    	cookingEquipment = equipment;
        setMoney(money -= equipment.getPrice());
    }

    public void UpgradeKnife(Knife knife) {
    	knives = knife;
        setMoney(money -= knife.getPrice());
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

    public double getDemand() {

        // if clenliness is less than 0.1, demand is 0
        if (cleanliness < 0.1) {
            return 0;
        }

        // get all competition
        ArrayList<Business> competition = Main.game.getCompetitors(this);

        // get mean price of competition multiplied by customer satisfaction
        double meanPrice = 0;
        for (Business b : competition) {
            meanPrice += b.getPrice()*b.GetCustomerSatisfaction();
        }
        meanPrice /= competition.size();

        // get difference between mean price and our price
        double difference = meanPrice - getPrice();

        // get exponential fall off or rise
        double curve = 0.01*Math.pow(3, difference);

    	return curve;
    }


    public int getProfit() {
    	int profit = (int) (steaks * getDemand());
    	return profit;
    }

    public int getPrice() {
    	return price;
    }

    public void setMoney(int money) {
    	this.money = money;
    }

    public int getOptimalPrice() {
        int optimalPrice = (int) (food.getModifier() * Main.game.getGoingRate() * GetCustomerSatisfaction());
        return optimalPrice;
    }

    public void Update() {
        // calculate expenses
        int expenses = getExpenses();

        setMoney(money - expenses);
        // if money is less than 0, increment debt
        if (money < 0) {
            debt += money;
            setDebt(debt);
            setMoney(0);
        }

        // calculate profit
        int profit = getProfit();

        setMoney(money += profit);

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
