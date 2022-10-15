package animals.Herbivore;

import animals.Actions.Run;
import animals.Actions.Swim;
import animals.Actions.Voice;

public class Tiger extends Herbivore implements Voice, Run, Swim {

    public Tiger(String name) {
        setName(name);
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
