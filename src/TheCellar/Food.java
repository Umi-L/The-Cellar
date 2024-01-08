package TheCellar;/*
 TheCellar.Food (Abstract)
#Name: string
#Price: int
#Modifier: int
get&set for all fields

 */

import TheCellar.Items.Foods.FoodScraps;
import TheCellar.Items.Foods.WalmartFood;
import TheCellar.Items.Foods.PremiumMeatSupplier;
import TheCellar.Items.Foods.OrganicFarmPartnership;
import TheCellar.Items.Foods.GourmetRecipeBook;
import TheCellar.Items.Foods.SeasonalMenuUpdates;

import java.io.Serializable;

public abstract class Food extends Purchasable implements Serializable {
    public static final Food[] FoodTypes = {
            new FoodScraps(),
            new WalmartFood(),
            new PremiumMeatSupplier(),
            new OrganicFarmPartnership(),
            new GourmetRecipeBook(),
            new SeasonalMenuUpdates()
            
    };

    protected Food(String name, int price, double modifier, int SteaksPerDayIncrease) {
        this.name = name;
        this.price = price;
        this.qualityModifier = modifier;
        this.steaksPerDayIncrease = SteaksPerDayIncrease;
    }
}
