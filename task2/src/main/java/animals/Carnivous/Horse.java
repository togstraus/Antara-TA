package animals.Carnivous;

import animals.Actions.Run;
import animals.Actions.Swim;
import animals.Actions.Voice;
import model.Size;

public class Horse extends Carnivorous implements Voice, Run, Swim {

    public Horse(String name, Size size) {
        setName(name);
        setSize(size);
    }

    public String getVoice() {
        return "игого";
    }

    public void run() {
        System.out.printf("%s бегает. \n", getName());
    }

    public void swim() {
        System.out.printf("%s плавает. \n", getName());
    }
}
