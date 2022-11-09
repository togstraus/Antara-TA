package animals;

import food.Food;
import lombok.Getter;
import lombok.Setter;
import model.Size;
import model.WrongFoodException;

@Getter
@Setter
public abstract class Animal{

    private String name;
    private Size size;

    public abstract void eat(Food food) throws WrongFoodException;
}