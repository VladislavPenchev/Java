package PizzaCalories_05.dough;

import PizzaCalories_05.Weight;

public class DoughEntity extends Weight {
    private DoughType type;
    private DoughAddition addition;

    public DoughType getType() {
        return type;
    }

    public void setType(DoughType type) {
        this.type = type;
    }

    public DoughAddition getAddition() {
        return addition;
    }

    public void setAddition(DoughAddition addition) {
        this.addition = addition;
    }
}
