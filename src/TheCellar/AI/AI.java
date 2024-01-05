package TheCellar.AI;

import TheCellar.*;
import TheCellar.Cleaner;

import java.io.Serializable;
import java.util.Random;

public class AI extends Business implements Cloneable, Serializable {

	int level; // level from 1 to 10, 1 being the lowest and 10 being the highest

	public void MakeDecision(boolean simulated) {

		int random = Main.game.random.nextInt(10)+1;

		// if we have no food
		if (daysOfFood == 0) {
			// make a food decision
			FoodDecision(simulated);
		}

		if (random <= 3) { // 30% chance to make a chef decision
			ChefDecision(simulated);
		}

		if (random <= 2) { // 20% chance to make a cleaner decision
			CleanerDecision(simulated);
		}

		if (random <= 1) { // 10% chance to make a knife decision
			KnifeDecision(simulated);
		}

		EquipmentDecision(simulated);

		// if days in debt is greater than 3 and we have money pay off loan
		if (daysInDebt > 3 && money > debt) {
			money -= debt;
			debt = 0;
		}


		if (random <= level) { // this will make the AI more likely to change their pricing as the AI level increases
			// update pricing
			UpdatePricing(simulated);
		}
	}

	@Override
	public void GameOver(){
		super.GameOver();

		Main.game.RemoveAI(this);
	}

	@Override
	public void Update() {
		super.Update();
		MakeDecision(false);
	}

	public void Update(boolean simulated){
		MakeDecision(simulated);
		super.Update();
	}

	private void FoodDecision(boolean simulated){

		int random = Main.game.random.nextInt(10)+1;

		Food selected = food;

		int expenses = getExpenses();
		int profit = getProfit();

		// calculate buffer, generally as the AI level increases, the buffer increases
		int buffer = 500/((random/5)+1)*((level/2)+1);

		// if we're broke and AI level is greater than 5 then the buffer shrinks
		if (money < buffer*5 && level > 5){
			buffer = 500/(random/5)*(level/4); // buffer is 1/4 of normal
		}

		// remove current food from expenses
		if (daysOfFood == 0){
			expenses -= food.getPrice();
		}

		// foreach food type in Food.FoodTypes
		for (Food currFood : Food.FoodTypes) {
			// if food price is some buffer away from money
			if (currFood.getPrice() < money - expenses + buffer + profit) {
				selected = currFood;
			} else{
				if (level < 3){ // if low ai level we're stupid and ignore the buffer
					selected = currFood;
					break;
				}
			}
		}

		PurchaseFood(selected);
	}

	public void UpdatePricing(boolean simulated){
		// get optimal price for steak at price
		int optimalPrice = getOptimalPrice();

		final int maxDiff = 10;

		// based on AI level get some randomness close to optimal price
		int random = Main.game.random.nextInt(maxDiff) - maxDiff/2;

		double inverseAI = 1.0/level;

		// make buffer larger as AI level is smaller
		int buffer = (int)(((double)random)*inverseAI); // buffer that tends to be larger as AI level is smaller

		// if we're broke and AI level is greater than 5 then the buffer shrinks
		if ((getExpenses() > getProfit()) && level > 5){
			buffer = (int)(((double)random)*inverseAI/2); // buffer is 1/2 of normal
		}

		int finalPrice = optimalPrice + buffer; // price is modulated +/- buffer

		if (finalPrice <= 0){
			finalPrice = 1;
		}

		System.out.println("AI " + level + " buffer " + buffer + " optimal " + optimalPrice);

		setPrice(finalPrice);
	}

	private void ChefDecision(boolean simulated){

		// for every chef type
		for (int i = 0; i < Chef.ChefTypes.length; i++) {
			int random = Main.game.random.nextInt(10)+1;

			int invertedAI = 10 - level;

			int offset = random/invertedAI;

			int offsetIndex = (i + offset)%Chef.ChefTypes.length;

			Chef currChef = Chef.ChefTypes[offsetIndex]; // as AI level increases, the chef types the AI can possibly pick becomes less random.

			// if we have enough money to buy the chef
			if (money > currChef.getPrice()) {
				// if we have no chefs
				if (chefs.isEmpty()) {
					// hire the chef
					HireChef(currChef);
					break;
				} else {
					if (level < 3){ // if low ai level we're stupid and ignore the simulation
						HireChef(currChef);
						break;
					} else if (!simulated){
						// simulate hiring the chef on the business
						AI temp = this.clone();
						temp.HireChef(currChef);

						// simulate AILevel/2 days
						for (int j = 0; j < level/2; j++) {
							temp.Update(true); // MAY RECURSE!!!!
						}

						// check if net worth is greater than current net worth
						if (temp.GetNetWorth() > GetNetWorth()) {
							// hire the chef
							HireChef(currChef);
							break;
						}
					}
				}
			}
		}
	}

	private void EquipmentDecision(boolean simulated){
		// for every equipment type
		for (int i = 0; i < Equipment.EquipmentTypes.length; i++) {
			int random = Main.game.random.nextInt(10)+1;

			int invertedAI = 10 - level;

			int offset = random/invertedAI;

			int offsetIndex = (i + offset)%Equipment.EquipmentTypes.length;

			Equipment currEquipment = Equipment.EquipmentTypes[offsetIndex]; // as AI level increases, the equipment types the AI can possibly pick becomes less random.

			// if we have enough money to buy the equipment and some random chance
			if (money > currEquipment.getPrice() && random < level) {
				// if we have no equipment
				if (cookingEquipment == null) {
					// buy the equipment
					PurchaseEquipment(currEquipment);
					break;
				} else {
					if (level < 3){ // if low ai level we're stupid and ignore the simulation
						PurchaseEquipment(currEquipment);
						break;
					} else if (!simulated){
						// simulate buying the equipment on the business
						AI temp = this.clone();
						temp.PurchaseEquipment(currEquipment);

						// simulate AILevel/2 days
						for (int j = 0; j < level/2; j++) {
							temp.Update(true); // MAY RECURSE!!!!
						}

						// check if net worth is greater than current net worth
						if (temp.GetNetWorth() > GetNetWorth()) {
							// buy the equipment
							PurchaseEquipment(currEquipment);
							break;
						}
					}
				}
			}
		}
	}

	private void KnifeDecision(boolean simulated){
		// for every knife type
		for (int i = 0; i < Knife.KnifeTypes.length; i++){
			int random = Main.game.random.nextInt(10)+1;

			int invertedAI = 10 - level;

			int offset = random/invertedAI;

			int offsetIndex = (i + offset)%Knife.KnifeTypes.length;

			Knife currKnife = Knife.KnifeTypes[offsetIndex]; // as AI level increases, the knife types the AI can possibly pick becomes less random.

			// if we have enough money to buy the knife and some random chance
			if (money > currKnife.getPrice() && random < level) {
				// if we have no knife
				if (currKnife == null) {
					// buy the knife
					PurchaseKnife(currKnife);
					break;
				} else {
					if (level < 3){ // if low ai level we're stupid and ignore the simulation
						PurchaseKnife(currKnife);
						break;
					} else if (!simulated){
						// simulate buying the knife on the business
						AI temp = this.clone();
						temp.PurchaseKnife(currKnife);

						// simulate AILevel/2 days
						for (int j = 0; j < level/2; j++) {
							temp.Update(true); // MAY RECURSE!!!!
						}

						// check if net worth is greater than current net worth
						if (temp.GetNetWorth() > GetNetWorth()) {
							// buy the knife
							PurchaseKnife(currKnife);
							break;
						}
					}
				}
			}
		}
	}

	public void LoanDecision(boolean simulated) {
		int random = Main.game.random.nextInt(10)+1;

		// if we have no loans and we have money
		if (money < 100000 && level < 3) {
			// determine loan amount
			int loanAmount = 1000*(Main.game.random.nextInt(10)+1);

			// take out a loan
			TakeOutLoan(loanAmount);
		} else if (random < 3) {
			// determine loan amount
			int loanAmount = 1000*(Main.game.random.nextInt(10)+1);

			// take out a loan
			TakeOutLoan(loanAmount);
		}
	}

	private void CleanerDecision(boolean simulated) {
		int random = Main.game.random.nextInt(10)+1;

		// if we have no cleaners and we have money
		if (money > 1000 && level < 3 && random < 3) {
			// hire a cleaner
			HireCleaner(new Cleaner()); // TODO: Maybe make cleaners have different tiers like chefs?
		}
	}

    @Override
    public AI clone() {
        try {
            AI clone = (AI) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

	public static AI generateAI(int level) {
		AI ai = new AI();
		ai.name = "AI " + level;
		ai.level = level;

		// as AI level is higher start the AI with more stuff
		ai.money = 999999999; // give a ton of money to buy stuff initially

		if (level > 9) {
			ai.PurchaseEquipment(Equipment.EquipmentTypes[Equipment.EquipmentTypes.length - 2]);
			ai.PurchaseEquipment(Equipment.EquipmentTypes[Equipment.EquipmentTypes.length - 1]);
			ai.HireChef(Chef.ChefTypes[Chef.ChefTypes.length - 1]);
			ai.PurchaseFood(Food.FoodTypes[4]);
		} else if (level > 7) {
			ai.PurchaseEquipment(Equipment.EquipmentTypes[Equipment.EquipmentTypes.length - 2]);
			ai.HireChef(Chef.ChefTypes[Chef.ChefTypes.length - 2]);
			ai.PurchaseFood(Food.FoodTypes[3]);
		} else if (level > 5) {
			ai.PurchaseEquipment(Equipment.EquipmentTypes[Equipment.EquipmentTypes.length - 3]);
			ai.HireChef(Chef.ChefTypes[2]);
			ai.PurchaseFood(Food.FoodTypes[2]);
		} else if (level > 3) {
			ai.PurchaseEquipment(Equipment.EquipmentTypes[1]);
			ai.HireChef(Chef.ChefTypes[1]);
			ai.PurchaseFood(Food.FoodTypes[1]);
		} else if (level > 1) {
			ai.PurchaseEquipment(Equipment.EquipmentTypes[0]);
			ai.HireChef(Chef.ChefTypes[0]);
			ai.PurchaseFood(Food.FoodTypes[0]);
		}

		// hire level /2 cleaners
		for (int i = 0; i < level/2; i++) {
			ai.HireCleaner(new Cleaner());
		}

		// set AI money to ai level * some value
		ai.money = level * 10000L;

//		ai.setPrice(Main.game.getGoingRate());

		return ai;
	}
}
