package animals.Carnivous;

import animals.Actions.Fly;
import animals.Actions.Run;
import animals.Actions.Swim;
import animals.Actions.Voice;

public class Duck extends Carnivorous implements Fly, Run, Swim, Voice {

    public Duck(String name) {
        setName(name);
    }

    public void swim() {
        System.out.printf("%s плавает. \n", getName());
    }
    public String getVoice() {
        return "кря";
    }
    public void fly() {
        System.out.printf("%s летает. \n", getName());
    }
    public void run() {
        System.out.printf("%s бегает. \n", getName());
    }
}
