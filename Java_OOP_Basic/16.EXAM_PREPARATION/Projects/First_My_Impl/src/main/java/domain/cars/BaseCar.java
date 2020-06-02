package domain.cars;

public abstract class BaseCar implements Car{
    private int id;
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected BaseCar(int id, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public void tuneCar(int tuneIndex) {
        this.setHorsepower(this.getHorsepower() + tuneIndex);
        this.setSuspension(this.getSuspension() + (this.getSuspension() / 2));
    }

    @Override
    public String toString() {
        StringBuilder baseCarInfo = new StringBuilder();

        baseCarInfo.append(String.format("%s %s %d", this.brand, this.model, this.yearOfProduction))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s", this.horsepower, this.acceleration))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.suspension, this.durability));

        return baseCarInfo.toString();
    }
}
