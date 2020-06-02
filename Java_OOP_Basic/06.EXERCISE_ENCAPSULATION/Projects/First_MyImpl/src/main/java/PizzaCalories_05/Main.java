package PizzaCalories_05;

import PizzaCalories_05.dough.DoughAddition;
import PizzaCalories_05.dough.DoughEntity;
import PizzaCalories_05.dough.DoughType;
import PizzaCalories_05.topping.ToppingEntity;
import PizzaCalories_05.topping.ToppingType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaInfo = input.readLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        String[] pizzaDoughInfo = input.readLine().split("\\s+");
        String doughType = pizzaDoughInfo[1];
        String doughBakingTechnique = pizzaDoughInfo[2];
        int doughWeightInGrams = Integer.parseInt(pizzaDoughInfo[3]);

        DoughEntity doughEntity = new DoughEntity();
        doughEntity.setWeight(doughWeightInGrams);
        doughEntity.setType(mapStringToDoughType(doughType));
        doughEntity.setAddition(mapStringToDoughAddition(doughBakingTechnique));

        List<ToppingEntity> toppingEntities = new ArrayList<>();

        String currentLine;
        while (!"END".equals(currentLine = input.readLine())) {
            String[] toppingsInfo = currentLine.split("\\s+");
            String flourType = toppingsInfo[1];
            int flourWeightInGrams = Integer.parseInt(toppingsInfo[2]);

            ToppingEntity toppingEntity = new ToppingEntity();
            toppingEntity.setWeight(flourWeightInGrams);
            toppingEntity.setType(mapStringToToppingType(flourType));
            toppingEntities.add(toppingEntity);
        }

        Pizza pizza = new Pizza();
        pizza.setName(pizzaName);
        pizza.setDough(doughEntity);
        pizza.setToppingEntities(toppingEntities);

        Double result = pizzaCalories(pizza);

        System.out.println(result);

    }

    private static DoughType mapStringToDoughType(String doughTypeStr) {
        return Arrays.stream(DoughType.values())
                .filter(dt -> dt.name().equals(doughTypeStr))
                .findFirst()
                .orElse(null);
    }

    private static DoughAddition mapStringToDoughAddition(String doughAddition) {
        return Arrays.stream(DoughAddition.values())
                .filter(di -> di.name().equals(doughAddition))
                .findFirst()
                .orElse(null);
    }

    private static ToppingType mapStringToToppingType(String toppingType) {
        return Arrays.stream(ToppingType.values())
                .filter(tt -> tt.name().equals(toppingType))
                .findFirst()
                .orElse(null);
    }

    private static Double pizzaCalories(Pizza pizza) {
        Double doughCalories = (2 * pizza.getDough().getWeight())
                * pizza.getDough().getType().getType()
                * pizza.getDough().getAddition().getAddition();

        Double toppingsCalories = 0.0;

        for (ToppingEntity toppingEntity : pizza.getToppingEntities()) {
            toppingsCalories += (2.0 * toppingEntity.getWeight()) * toppingEntity.getType().getType();
        }

        return toppingsCalories + doughCalories;
    }

}
