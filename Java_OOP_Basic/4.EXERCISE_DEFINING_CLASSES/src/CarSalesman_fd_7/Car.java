package CarSalesman_fd_7;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;



    public Car(String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setColor(String color){
        this.color = color;
    }

}
