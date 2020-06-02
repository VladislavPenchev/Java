package PizzaCalories_fd_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dough {
    private static final List<String> FLOUR_TYPES = new ArrayList() {{
       add("White");
       add("Wholegrain");
    }};

    private static final List<String> BACKING_TECHNIQUES = new ArrayList()  {{
        add("Crispy");
        add("Chewy");
        add("Homemade");
    }};

    private static final Map<String, Double> DOUGH_MODIFIERS = new HashMap() {{
       put("White",1.5);
       put("Wholegrain", 1.0);
       put("Crispy", 0.9);
       put("Chewy", 1.1);
       put("Homemade", 1.0);
    }};

    private static final String INVALID_TYPE_DOUGH_EXECPTION_MESSAGE = "Invalid type of dough.";
    private static final String INVALID_WEIGHT_DOUGH_EXECPTION_MESSAGE = "Dough weight should be in the range [1..200].";

    private String flourType;
    private String backingTechnique;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBackingTechnique(backingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!FLOUR_TYPES.contains(flourType))
            throw new IllegalArgumentException(this.INVALID_TYPE_DOUGH_EXECPTION_MESSAGE);
        this.flourType = flourType;
    }

    private void setBackingTechnique(String backingTechnique) {
        if(!BACKING_TECHNIQUES.contains(backingTechnique))
            throw new IllegalArgumentException(this.INVALID_TYPE_DOUGH_EXECPTION_MESSAGE);
        this.backingTechnique = backingTechnique;
    }

    public void setWeight(double weight) {
        if(weight < 1 || weight > 200)
            throw new IllegalArgumentException(this.INVALID_WEIGHT_DOUGH_EXECPTION_MESSAGE);
        this.weight = weight;
    }

    public double calculateCalories(){
        return PizzaConstants.BASE_CALORIES
                * this.weight
                * DOUGH_MODIFIERS.get(this.flourType)
                * DOUGH_MODIFIERS.get(this.backingTechnique);
    }
}
