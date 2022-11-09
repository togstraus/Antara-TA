package animals.Herbivore;

import animals.Animal;
import food.Food;
import food.Meat;

public abstract class Herbivore extends Animal {

    public boolean eat(Food food) { //boolean
        if (food instanceof Meat) {
            System.out.printf("%s скушал %s. \n", this.getName(), food.name);
            return true;
        } else {
            System.out.printf("%s не стал кушать %s. \n", this.getName(), food.name);
            return false;
        }
    }
}
