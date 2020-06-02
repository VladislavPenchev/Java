package domain.cars;

public class ShowCarImpl extends BaseCar implements ShowCar {
    private static int DEFAULT_STARS = 0;

    private int stars;

    public ShowCarImpl(int id, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(id, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = DEFAULT_STARS;
    }

    @Override
    public void increaseStars(int tuneIndex) {
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        StringBuilder performanceCarInfo = new StringBuilder(super.toString());

        performanceCarInfo.append(System.lineSeparator())
                .append(String.format("%d *", this.stars));

        return performanceCarInfo.toString();
    }
}
