package PizzaCalories_05.dough;

public enum DoughAddition {

    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private Double addition;

    DoughAddition(Double addition) {
        this.addition = addition;
    }

    public Double getAddition() {
        return addition;
    }
}
