package TheCellar.AI;

import TheCellar.*;

/*
 TheCellar.AIBusiness extends TheCellar.Business
#level: int
+MakeDecision(): void
get&set for all fields

 */
public class AI extends Business {

	private boolean isBroke;

	int level; // level from 1 to 10, 1 being the lowest and 10 being the highest

	public void MakeDecision() {
		
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
		if (isBroke && level > 5){
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
					// if we have a chef
					if (chefs.size() == 1) {
						// if the chef is not the same type as the current chef
						if (chefs.get(0).getClass() != currChef.getClass()) {
							// hire the chef
							HireChef(currChef);
							break;
						}
					} else {
						// if we have more than one chef
						if (chefs.size() > 1) {
							// if the chef is not the same type as the current chef
							if (chefs.get(0).getClass() != currChef.getClass()) {
								// hire the chef
								HireChef(currChef);
								break;
							}
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
}
