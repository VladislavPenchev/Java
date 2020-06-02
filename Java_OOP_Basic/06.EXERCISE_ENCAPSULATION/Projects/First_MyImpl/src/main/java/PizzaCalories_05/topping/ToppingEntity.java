package PizzaCalories_05.topping;

import PizzaCalories_05.Weight;

public class ToppingEntity extends Weight {
    private ToppingType type;

    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }
}
