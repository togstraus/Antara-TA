import animals.Actions.Swim;
import animals.Carnivous.Duck;
import animals.Carnivous.Fish;
import animals.Carnivous.Horse;
import animals.Herbivore.Eagle;
import animals.Herbivore.Monkey;
import animals.Herbivore.Tiger;
import animals.Worker;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) {
        Duck duck = new Duck("Уточка");
        Fish fish = new Fish("Немо");
        Horse horse = new Horse("Скакун");
        Eagle eagle = new Eagle("Арел");
        Monkey monkey = new Monkey("Олег");
        Tiger tiger = new Tiger("Тигра");
        Worker worker = new Worker();

        Food corn = new Grass("кукуруза");
        Food pork = new Meat("говядина");

        worker.feed(duck, pork);
        worker.feed(fish, corn);
        worker.feed(eagle, corn);
        worker.feed(tiger, pork);

        worker.getVoice(horse);
        worker.getVoice(monkey);
        worker.getVoice(duck);
        //worker.getVoice(fish);
        worker.getVoice(eagle);
        worker.getVoice(tiger);

        Swim[] pond = {duck, horse, tiger, monkey, fish};
        for (int i = 0; i < pond.length; i++) {
            pond[i].swim();
        }
    }
}
