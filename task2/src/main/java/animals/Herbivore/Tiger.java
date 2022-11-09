package animals.Herbivore;

import animals.Actions.Run;
import animals.Actions.Swim;
import animals.Actions.Voice;
import model.Size;

public class Tiger extends Herbivore implements Voice, Run, Swim {

    public Tiger(String name, Size size) {
        setName(name);
        setSize(size);
    }

    public void swim() {
        System.out.printf("%s плавает. \n", getName());
    }
    public String getVoice() {
        return "Мурмя";
    }
    public void run() {
        System.out.printf("%s несется. \n", getName());
    }
}
