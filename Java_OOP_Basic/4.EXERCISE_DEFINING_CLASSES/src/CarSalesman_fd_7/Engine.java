package CarSalesman_fd_7;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power){
        this.model = model;
        this.power = power;
    }

    public void setDisplacement(int displacement){
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency){
        this.efficiency = efficiency;
    }

}
