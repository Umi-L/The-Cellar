package TheCellar;/*
 TheCellar.Cleaner
#Price: int
#Modifier: int
get&set for all fields
 */

import TheCellar.Items.Cleaner.CleaningStaff;
import TheCellar.Items.Cleaner.CleaningRobots;
import TheCellar.Items.Cleaner.EcoFriendlyCleaningSupplies;
import TheCellar.Items.Cleaner.IndustrialGradeCleaningSupplies;




public class Cleaner {
	protected String name;
	protected int price;
	protected double modifier;

	public static final Cleaner[] CleanerTypes = {
			new CleaningStaff(),
			new CleaningRobots(),
			new EcoFriendlyCleaningSupplies(),
			new IndustrialGradeCleaningSupplies(),


	};

	public Cleaner(String name, int price, double modifier) {
		this.name = name;
		this.price = price;
		this.modifier = modifier;
		
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;

		}

		public int getPrice() {
			return price;

		}

		public void setPrice(int price) {
			this.price = price;

		}

		public double getModifier() {
			return modifier;

		}

		public void setModifier(int modifier) {
			this.modifier = modifier;
		}
	}
