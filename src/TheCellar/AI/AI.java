package TheCellar.AI;

import TheCellar.*;

public class AI extends Business implements Cloneable{

	int level; // level from 1 to 10, 1 being the lowest and 10 being the highest

	public void MakeDecision() {

		int random = Main.game.random.nextInt(10);

		// if we have no food
		if (daysOfFood == 0) {
			// make a food decision
			FoodDecision();
		}

		if (random <= 3) { // 30% chance to make a chef decision
			ChefDecision();
		}

		if (random <= 2) { // 20% chance to make a cleaner decision
			CleanerDecision();
		}

		EquipmentDecision();


		if (random <= level) { // this will make the AI more likely to change their pricing as the AI level increases
			// update pricing
			UpdatePricing();
		}
	}

	private void FoodDecision() {

		int random = Main.game.random.nextInt(10);

		Food selected = food;

		int expenses = getExpenses();
		int money = getMoney();
		int profit = getProfit();

		// calculate buffer, generally as the AI level increases, the buffer increases
		int buffer = 500/(random/5)*(level/2);

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

	private void UpdatePricing(){
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

		setPrice(optimalPrice + buffer); // price is modulated +/- buffer
	}

	private void ChefDecision(){

		// for every chef type
		for (int i = 0; i < Chef.ChefTypes.length; i++) {
			int random = Main.game.random.nextInt(10);

			int invertedAI = 10 - level;

			int offset = random/invertedAI;

			int offsetIndex = (i + offset)%Chef.ChefTypes.length;

			Chef currChef = Chef.ChefTypes[offsetIndex]; // as AI level increases, the chef types the AI can possibly pick becomes less random.

			// if we have enough money to buy the chef
			if (getMoney() > currChef.getPrice()) {
				// if we have no chefs
				if (chefs.isEmpty()) {
					// hire the chef
					HireChef(currChef);
					break;
				} else {
					if (level < 3){ // if low ai level we're stupid and ignore the simulation
						HireChef(currChef);
						break;
					} else{
						// simulate hiring the chef on the business
						AI temp = this.clone();
						temp.HireChef(currChef);

						// simulate AILevel/2 days
						for (int j = 0; j < level/2; j++) {
							temp.MakeDecision(); // MAY RECURSE!!!!
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

	private void EquipmentDecision(){
		// for every equipment type
		for (int i = 0; i < Equipment.EquipmentTypes.length; i++) {
			int random = Main.game.random.nextInt(10);

			int invertedAI = 10 - level;

			int offset = random/invertedAI;

			int offsetIndex = (i + offset)%Equipment.EquipmentTypes.length;

			Equipment currEquipment = Equipment.EquipmentTypes[offsetIndex]; // as AI level increases, the equipment types the AI can possibly pick becomes less random.

			// if we have enough money to buy the equipment and some random chance
			if (getMoney() > currEquipment.getPrice() && random < level) {
				// if we have no equipment
				if (cookingEquipment == null) {
					// buy the equipment
					PurchaseEquipment(currEquipment);
					break;
				} else {
					if (level < 3){ // if low ai level we're stupid and ignore the simulation
						PurchaseEquipment(currEquipment);
						break;
					} else{
						// simulate buying the equipment on the business
						AI temp = this.clone();
						temp.PurchaseEquipment(currEquipment);

						// simulate AILevel/2 days
						for (int j = 0; j < level/2; j++) {
							temp.MakeDecision(); // MAY RECURSE!!!!
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

	private void CleanerDecision() {
		int random = Main.game.random.nextInt(10);

		// if we have no cleaners and we have money
		if (getMoney() > 1000 && level < 3 && random < 3) {
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
		ai.setName("AI " + (level + 1));
		ai.level = level;

		// as AI level is higher start the AI with more stuff
		ai.setMoney(999999999); // give a ton of money to buy stuff initially

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

		// set AI money to ai level * 5000
		ai.setMoney(level * 5000);

		return ai;
	}
}
