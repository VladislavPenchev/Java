package CarShopExtend_fd_3;

import java.io.Serializable;

public class Seat implements Sellable, Serializable {

    private String countryProduced;
    private String model;
    private String color;
    private Integer hoursePower;
    private Double price;

    public Seat(String countryProduced, String model, Integer hoursePower, String color, Double price) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.hoursePower = hoursePower;
        this.price = price;
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
    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public Double getPrice() {
        return this.price;
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
