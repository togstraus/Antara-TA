package animals.Herbivore;

import animals.Actions.Run;
import animals.Actions.Swim;
import animals.Actions.Voice;
import model.Size;

public class Monkey extends Herbivore implements Voice, Run, Swim {
    public Monkey(String name, Size size) {
        setName(name);
        setSize(size);
    }

    public void swim() {
        System.out.printf("%s плавает. \n", getName());
    }

    public String getVoice() {
        return "Здравствуйте, сударь!";
    }

    public void run() {
        System.out.printf("%s бегает. \n", getName());
    }
}
