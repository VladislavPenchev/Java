package CarShop_fd_2;

import java.io.Serializable;

public class Seat implements Car, Serializable {

    private String countryProduced;
    private String model;
    private String color;
    private Integer hoursePower;

    public Seat(String countryProduced, String model, Integer hoursePower, String color) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.hoursePower = hoursePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHoursePower() {
        return this.hoursePower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s is %s and have %d hourse powers",this.getModel(), this.getColor(), this.getHoursePower()))
        .append(System.lineSeparator())
        .append(String.format("This is %s produced in %s and have %d tires", this.getModel(), this.countryProduced, TIRES));

        return sb.toString();
    }
}
