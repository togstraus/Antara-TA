package animals;

import food.Food;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {


    private String name;

    public abstract boolean eat(Food food);

}
