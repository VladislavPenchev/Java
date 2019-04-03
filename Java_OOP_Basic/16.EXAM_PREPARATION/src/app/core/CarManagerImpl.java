package app.core;

import app.contracts.Car;
import app.contracts.CarManager;
import app.contracts.Race;
import app.entities.Garage;
import app.entities.cars.PerformanceCar;
import app.entities.cars.ShowCar;
import app.entities.races.CasualRace;
import app.entities.races.DragRace;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManagerImpl implements CarManager {

    private static final String PERFORMANCE_CAR_TYPE = "Performance";
    private static final String SHOW_CAR_TYPE = "Show";
    private static final String CASUAL_RACE_TYPE = "Casual";
    private static final String DRAG_RACE_TYPE = "Drag";
    private static final String DRIFT_RACE_TYPE = "Drift";

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManagerImpl(){
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    @Override
    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){

        Car car = null;

        switch (type) {
            case PERFORMANCE_CAR_TYPE:
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case SHOW_CAR_TYPE:
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }

        if(car != null){
            this.cars.put(id, car);
        }

    }

    @Override
    public String check(int id){
        return this.cars.get(id).toString();
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool){

        Race race = null;

        switch(type){
            case CASUAL_RACE_TYPE:
                race = new CasualRace(length, route, prizePool);
                break;
            case DRAG_RACE_TYPE:
                race = new DragRace(length, route, prizePool);
                break;
            case DRIFT_RACE_TYPE:
                race = new DragRace(length, route, prizePool);
                break;
        }

        if(race != null){
            this.races.put(id,race);
        }
    }

    @Override
    public void participate(int carId, int raceId){

        Car car = this.cars.get(carId);

        if(this.garage.hasCar(car)){
            return;
        }

        Race race = this.races.get(raceId);

        race.addParticipant(car);
    }

    public String start(int id){
        return null;
    }

    @Override
    public void park(int id){
        Car car = this.cars.get(id);

        if(this.races.values()
                .stream()
                .anyMatch(race -> race.hasCar(car))){
            return;
        }

        this.garage.addInGarage(car);
    }
    @Override
    public void unpark(int id){
        Car car = this.cars.get(id);

        this.garage.removeFromGarage(car);
    }

    public void tune(int tuneIndex, String addOn){

    }


}
