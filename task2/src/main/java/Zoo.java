import animals.Actions.Swim;
import animals.Animal;
import animals.Carnivous.Carnivorous;
import animals.Carnivous.Duck;
import animals.Carnivous.Fish;
import animals.Carnivous.Horse;
import animals.Herbivore.Eagle;
import animals.Herbivore.Herbivore;
import animals.Herbivore.Monkey;
import animals.Herbivore.Tiger;
import animals.Worker;
import food.Food;
import food.Grass;
import food.Meat;
import model.Size;
import model.WrongFoodException;

public class Zoo {
    public static void main(String[] args) throws WrongFoodException {
        Duck duck = new Duck("Уточка", Size.LOW);
        Fish fish = new Fish("Немо", Size.LOW);
        Horse horse = new Horse("Скакун", Size.LARGE);
        Eagle eagle = new Eagle("Арел", Size.MEDIUM);
        Monkey monkey = new Monkey("Олег", Size.MEDIUM);
        Tiger tiger = new Tiger("Тигра", Size.HIGH);
        Worker worker = new Worker();

        Food corn = new Grass("кукуруза");
        Food pork = new Meat("говядина");

        try {
            worker.feed(duck, pork);
        } catch (WrongFoodException e){
            System.out.println(e);
        }

        worker.feed(fish, corn);
        worker.feed(tiger, pork);

        try {
            worker.feed(eagle, corn);
        } catch (WrongFoodException e){
            System.out.println(e);
        }

        System.out.println();

        worker.getVoice(horse);
        worker.getVoice(monkey);
        worker.getVoice(duck);
        //worker.getVoice(fish);
        worker.getVoice(eagle);
        worker.getVoice(tiger);

        System.out.println();

        Swim[] pond = {duck, horse, tiger, monkey, fish};
        for (int i = 0; i < pond.length; i++) {
            pond[i].swim();
        }

        System.out.println();

        Aviary<Carnivorous> aviary1 = new Aviary<>(Size.LOW);
        aviary1.add(duck);
        aviary1.add(fish);
        aviary1.add(horse);

        System.out.println();

        System.out.println("Найден объект c именем: " + aviary1.info("Уточка").getName());

        System.out.println();

        Aviary<Herbivore> aviary2 = new Aviary<>(Size.MEDIUM);
        aviary2.add(tiger);
        aviary2.add(eagle);
        aviary2.add(monkey);
        aviary2.remove(eagle);

        System.out.printf("\n\nВ вольере находятся: \n");

        for (Animal x : aviary2.getAviary()) {
            System.out.println(x.getName());
        }
    }
}
