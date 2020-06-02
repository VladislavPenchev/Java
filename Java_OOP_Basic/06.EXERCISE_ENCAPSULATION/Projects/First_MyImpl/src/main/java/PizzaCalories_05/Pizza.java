package PizzaCalories_05;

import PizzaCalories_05.dough.DoughEntity;
import PizzaCalories_05.topping.ToppingEntity;

import java.util.List;

public class Pizza {
    private String name;
    private DoughEntity dough;
    private List<ToppingEntity> toppingEntities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoughEntity getDough() {
        return dough;
    }

    public void setDough(DoughEntity dough) {
        this.dough = dough;
    }

    public List<ToppingEntity> getToppingEntities() {
        return toppingEntities;
    }

    public void setToppingEntities(List<ToppingEntity> toppingEntities) {
        this.toppingEntities = toppingEntities;
    }
}
