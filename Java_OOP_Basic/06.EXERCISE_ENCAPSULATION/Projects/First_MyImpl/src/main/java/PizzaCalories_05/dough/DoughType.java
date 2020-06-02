package PizzaCalories_05.dough;

public enum DoughType {
    White(1.5),
    Wholegrain(1.0);

    private Double type;

    DoughType(Double type) {
        this.type = type;
    }

    public Double getType() {
        return type;
    }
}
