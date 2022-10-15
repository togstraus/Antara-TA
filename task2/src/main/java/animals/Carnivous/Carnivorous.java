package animals.Carnivous;

import animals.Animal;
import food.Food;
import food.Grass;
import model.WrongFoodException;

public abstract class Carnivorous extends Animal {

    public void eat(Food food) throws WrongFoodException { //boolean
        if (food instanceof Grass) {
            System.out.printf("%s скушал %s. \n", this.getName(), food.name);
        } else {
            throw new WrongFoodException(this.getName() + " не стало есть еду: " + food.name);
        }
    }
}
