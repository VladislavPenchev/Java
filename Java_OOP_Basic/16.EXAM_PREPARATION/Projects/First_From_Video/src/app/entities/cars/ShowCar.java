package app.entities.cars;

import java.util.Collection;

public class ShowCar extends BaseCar{

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {

        StringBuilder showCar = new StringBuilder(super.toString());

        showCar.append(String.format("%d *",this.stars));

        return showCar.toString();
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        this.stars += tuneIndex;
    }

    //    @Override
//    public void tune(Object... params) {
//        int tuneIndex = (int) params[0];
//        stars += tuneIndex;
//    }
}
