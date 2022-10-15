package animals.Herbivore;

import animals.Actions.Run;
import animals.Actions.Swim;
import animals.Actions.Voice;

public class Monkey extends Herbivore implements Voice, Run, Swim {
    public Monkey(String name) {
        setName(name);
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
