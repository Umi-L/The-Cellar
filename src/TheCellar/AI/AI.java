package TheCellar.AI;

import java.util.concurrent.ThreadLocalRandom;

import TheCellar.Business;

/*
 TheCellar.AIBusiness extends TheCellar.Business
#level: int
+MakeDecision(): void
get&set for all fields

 */
public class AI extends Business {
	protected int level, money;
	protected int foodPrice;

	public void MakeDecision() {
		
	}
	
	public int food() {
		
		
		foodPrice = (int)Math.floor(Math.random() * (100 - 20 + 1) + 20);
		return foodPrice; 
	}

	public int getLevel() {
		return level;
	}
	
	public int getMoney() {
		return money;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
}
