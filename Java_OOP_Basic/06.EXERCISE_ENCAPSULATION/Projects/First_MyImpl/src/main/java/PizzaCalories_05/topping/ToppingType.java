package PizzaCalories_05.topping;

public enum  ToppingType {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private Double type;

    ToppingType(Double type) {
        this.type = type;
    }

    public Double getType() {
        return type;
    }
}
