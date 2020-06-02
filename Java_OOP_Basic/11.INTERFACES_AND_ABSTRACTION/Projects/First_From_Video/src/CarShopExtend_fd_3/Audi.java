package CarShopExtend_fd_3;

public class Audi implements Rentable {
    private String countryProduced;
    private String model;
    private String color;
    private Integer horsePower;
    private Integer minRenDay;
    private Double pricePerDay;

    public Audi(String countryProduced, String model, String color, Integer horsePower, Integer minRenDay, Double pricePerDay) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.minRenDay = minRenDay;
        this.pricePerDay = pricePerDay;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRenDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
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
        return this.horsePower;
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
