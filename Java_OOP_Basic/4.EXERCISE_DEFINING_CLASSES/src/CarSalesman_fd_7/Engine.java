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

    public String getModel(){
        return this.model;
    }

    public int getPower(){
        return this.power;
    }

    public int getDisplacement(){
        return this.displacement;
    }

    public String getEfficiency(){
        return this.efficiency;
    }

    public void setDisplacement(int displacement){
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency){
        this.efficiency = efficiency;
    }

}
