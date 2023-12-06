package TheCellar.AI;

import TheCellar.Food;
import TheCellar.Main;
import TheCellar.Business;

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

	public void FoodDecision() {

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
}
