package animals.Carnivous;

import animals.Actions.Swim;

public class Fish extends Carnivorous implements Swim {
    public Fish(String name) {
        setName(name);
    }

    public void swim() {
        System.out.printf("%s плавает. \n", getName());
    }
}
