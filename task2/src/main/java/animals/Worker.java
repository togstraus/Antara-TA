package animals;

import animals.Actions.Voice;
import food.Food;

public class Worker {

    public void feed(Animal animal, Food food) {
        System.out.print("Работник покормил животное. ");
        animal.eat(food);
    }
    public void getVoice(Voice object) {
        if (object instanceof Animal animal) {
            System.out.println("Отдан приказ голос. Животное " + animal.getName() +
                    " говорит: " + object.getVoice());
        } else {
            System.out.println("Объект издает тишину.");
        }
    }
}
