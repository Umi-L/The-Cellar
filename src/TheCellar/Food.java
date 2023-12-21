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

public abstract class Food implements Serializable {
    public static final Food[] FoodTypes = {
            new FoodScraps(),
            new WalmartFood(),
            new PremiumMeatSupplier(),
            new OrganicFarmPartnership(),
            new GourmetRecipeBook(),
            new SeasonalMenuUpdates()
            
    };

    protected String name;
    protected int price;
    protected double QualityModifier;
    protected int SteaksPerDayIncrease;

    protected Food(String name, int price, double modifier, int SteaksPerDayIncrease) {
        this.name = name;
        this.price = price;
        this.QualityModifier = modifier;
        this.SteaksPerDayIncrease = SteaksPerDayIncrease;
    }

    public int getSteaksPerDayIncrease() {
        return SteaksPerDayIncrease;
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

    public double getQualityModifier() {
        return QualityModifier;
    }

    public void setQualityModifier(int qualityModifier) {
        this.QualityModifier = qualityModifier;
    }
}
