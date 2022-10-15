package animals.Carnivous;

import animals.Actions.Swim;
import model.Size;

public class Fish extends Carnivorous implements Swim {
    public Fish(String name, Size size) {
        setName(name);
        setSize(size);
    }

    public void swim() {
        System.out.printf("%s плавает. \n", getName());
    }
}
