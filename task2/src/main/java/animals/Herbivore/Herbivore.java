package animals.Herbivore;

import animals.Animal;
import food.Food;
import food.Meat;
import model.WrongFoodException;

public abstract class Herbivore extends Animal {

    public void eat(Food food) throws WrongFoodException { //boolean
        if (food instanceof Meat) {
            System.out.printf("%s скушал %s. \n", this.getName(), food.name);
        } else {
            throw new WrongFoodException(this.getName() + " не стало есть еду: " + food.name);
        }
    }
}
