package app.contracts;

public interface Car {

    int getEnginePerformancePoints();

    int getOverallPerformancePoints();

    int getSuspensionPerformancePoints();

    String toString();

    void increaseHorsepower(int tuneIndex);

    void increaseSuspension(int tuneIndex);

    void tune(int tuneIndex, String addOn);

    //void tune(Object... params);
}
