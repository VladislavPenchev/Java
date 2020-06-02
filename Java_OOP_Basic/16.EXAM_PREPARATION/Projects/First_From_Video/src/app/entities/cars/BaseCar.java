package app.entities.cars;

import app.contracts.Car;

public abstract class BaseCar implements Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected BaseCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    protected void setHorsepower(int horsepower){
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension){
        this.suspension = suspension;
    }


    @Override
    public void increaseHorsepower(int tuneIndex) {
        this.horsepower += tuneIndex;

    }

    @Override
    public void increaseSuspension(int tuneIndex) {
        this.suspension += tuneIndex;
    }

    @Override
    public int getOverallPerformancePoints(){
        return this.getEnginePerformancePoints() + this.getSuspensionPerformancePoints();
    }

    @Override
    public int getEnginePerformancePoints(){
        return this.horsepower / this.acceleration;
    }

    @Override
    public int getSuspensionPerformancePoints(){
        return this.suspension + this.durability;
    }


    @Override
    public String toString() {

        StringBuilder car = new StringBuilder();

        car.append(String.format("%d %s %d", this.brand, this.model, this.yearOfProduction))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s",this.horsepower, this.acceleration))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.suspension, this.durability))
                .append(System.lineSeparator());


        return car.toString()  ;
    }
}
