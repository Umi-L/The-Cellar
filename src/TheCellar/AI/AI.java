package TheCellar.AI;

import TheCellar.Main;
import TheCellar.Business;

/*
 TheCellar.AIBusiness extends TheCellar.Business
#level: int
+MakeDecision(): void
get&set for all fields

 */
public class AI extends Business {
	protected int nw = GetNetWorth();
	protected int money = getMoney();
	protected double cleanly = getCleanliness();
	protected int foodPrice = Main.game.getGoingRate();;

	public void MakeDecision() {
		if (cleanly <= 0.2) {
			
		}
	}
}
