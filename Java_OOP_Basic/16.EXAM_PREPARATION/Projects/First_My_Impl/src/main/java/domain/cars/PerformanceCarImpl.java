package domain.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCarImpl extends BaseCar implements Performance {

    private List<String> addOns;

    public PerformanceCarImpl(int id, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(id, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            this.addOns = new ArrayList<>();
    }

    public void increaseHorsepower() {
        super.setHorsepower(this.getHorsepower() + (this.getHorsepower() / 2));
    }

    public void decreaseSuspension() {
        super.setSuspension(this.getSuspension() - (this.getSuspension() / 4));
    }

    @Override
    public void insertAddOns(String addOn) {
        this.addOns.add(addOn);
    }


    @Override
    public String toString() {
        StringBuilder showCarInfo = new StringBuilder(super.toString());

        showCarInfo.append(System.lineSeparator())
                .append(String.format("Add-ons: %s", String.join(", ", this.addOns)));

        return showCarInfo.toString();
    }

}
