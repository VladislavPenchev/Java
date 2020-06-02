package FragileBaseClass_04;

import java.util.Arrays;
import java.util.List;

public class Predator extends Animal{
    private int health;

    public void feed(Food food) {
        super.eat(food);
        this.health++;
    }

    @Override
    public void eatAll(Food[] food) {
        super.foodEaten.addAll(Arrays.asList(food));
    }

    public int getHealth() {
        return health;
    }
}
