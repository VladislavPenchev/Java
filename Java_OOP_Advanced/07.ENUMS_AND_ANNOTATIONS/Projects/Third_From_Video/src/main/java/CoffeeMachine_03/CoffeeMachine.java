package CoffeeMachine_03;

import CodingTracker_05.Author;
import CoffeeMachine_03.enums.CoffeeSize;
import CoffeeMachine_03.enums.CoffeeType;
import CoffeeMachine_03.enums.Coin;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeeList;
    private int money;

    public CoffeeMachine() {
        coffeeList = new ArrayList<>();
    }

    @Author(name = "Ivo")
    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(Enum.valueOf(CoffeeSize.class, size.toUpperCase()), Enum.valueOf(CoffeeType.class, type.toUpperCase()));

        if(coffee.getPrice() <= this.money) {
            this.coffeeList.add(coffee);
            this.money = 0;
        }
    }

    @Author(name = "Pesho")
    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin.toUpperCase()).getValue();
    }

    @Author(name = "Gosho")
    public Iterable<Coffee> coffeesSold() {
        return this.coffeeList;
    }
}
