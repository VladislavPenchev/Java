package RawData_fd_6;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed, int enginePower){
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public int getEnginePower(){
        return this.enginePower;
    }
}
