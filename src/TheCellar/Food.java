package TheCellar;/*
 TheCellar.Food (Abstract)
#Name: string
#Price: int
#Modifier: int
get&set for all fields

 */

import TheCellar.Items.Foods.FoodScraps;
import TheCellar.Items.Foods.WalmartFood;

public abstract class Food {
    public static final Food[] FoodTypes = {
            new FoodScraps(),
            new WalmartFood()
    };

    protected String name;
    protected int price;
    protected double modifier;

    protected Food(String name, int price, double modifier) {
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
