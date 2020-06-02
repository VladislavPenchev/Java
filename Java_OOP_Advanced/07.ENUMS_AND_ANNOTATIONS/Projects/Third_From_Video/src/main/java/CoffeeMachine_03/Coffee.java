package CoffeeMachine_03;

import CoffeeMachine_03.enums.CoffeeSize;
import CoffeeMachine_03.enums.CoffeeType;

public class Coffee {
    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    public int getPrice() {
        return this.coffeeSize.getPrice();
    }

    @Override
    public String toString() {
        return this.coffeeSize.toString() + " "+ this.coffeeType.toString();
    }
}
