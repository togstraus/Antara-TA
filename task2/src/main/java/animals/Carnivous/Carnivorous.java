package animals.Carnivous;

import animals.Animal;
import food.Food;
import food.Grass;

public abstract class Carnivorous extends Animal {

    public boolean eat(Food food) { //boolean
        if (food instanceof Grass) {
            System.out.printf("%s скушал %s. \n", this.getName(), food.name);
            return true;
        } else {
            System.out.printf("%s не стал кушать %s. \n", this.getName(), food.name);
            return false;
        }
    }
}
