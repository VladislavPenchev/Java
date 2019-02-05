package CarSalesman_fd_7;

public class Car {
    private final String NOT_AVAILABLE = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;



    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
    }

    public Engine getEngine(){
        return this.engine;
    }

    public int getWeight(){
        return this.weight;
    }

    public String getcolor(){
        return this.color;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString() {

        return String.format("%s:\n%s:\nPower: %d\nDisplacement: %s",//\nEfficiency: %s\nWeight: %d\nColor: %d",
                model,
                engine.getModel(),
                getEngine().getPower(),
                engine.getDisplacement() == 0 ? NOT_AVAILABLE : engine.getDisplacement(),
                engine.getEfficiency(),equals(null) ? NOT_AVAILABLE : engine.getEfficiency()
                //weight == 0 ? "n/a" : weight,
                //color.equals(null) ? "n/a" : color
                );
    }
}
