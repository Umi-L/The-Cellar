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
	protected int level;
	protected int random = ThreadLocalRandom.current().nextInt();

	public void MakeDecision() {

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
