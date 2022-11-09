package animals.Herbivore;

import animals.Actions.Fly;
import animals.Actions.Run;
import animals.Actions.Voice;
import model.Size;

public class Eagle extends Herbivore implements Fly, Voice, Run {
    public Eagle(String name, Size size) {
        setName(name);
        setSize(size);
    }

    public String getVoice() {
        return "курлык";
    }
    public void run() {
        System.out.printf("%s бегает. \n", getName());
    }
    public void fly() {
        System.out.printf("%s летает. \n", getName());
    }
}
