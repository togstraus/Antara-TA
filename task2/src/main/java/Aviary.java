import animals.Animal;
import lombok.Getter;
import model.Size;

import java.util.HashSet;

@Getter
public class Aviary<T extends Animal> {

    private String name;
    private HashSet<T> aviary;
    private Size size;

    public Aviary(Size size) {
        this.aviary = new HashSet<>();
        this.size = size;
    }

    public void add(T animal) {
        if (animal.getSize().ordinal() >= this.size.ordinal()) {
            aviary.add(animal);
            System.out.printf("%s добавлен\n", animal.getName());
        } else {
            System.out.printf("%s не добавлен\n", animal.getName());
        }

    }
    public void remove(T animal) {
        aviary.remove(animal);
        System.out.printf("%s удален\n", animal.getName());
    }
    public T info(String name) {
        for (T animal : aviary) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }
}