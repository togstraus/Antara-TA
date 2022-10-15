package model;

public class Kotik {
    private String name = "Kot";
    private int weight = 50;
    private int satiety = 10;
    private String meow = "Мя";
    private int prettiness = 10;
    private static int quantityObjects = 0;

    public Kotik() {
        this.name = name;
        this.weight = weight;
        this.satiety = satiety;
        this.meow = meow;
        this.prettiness = prettiness;
        quantityObjects++;
    }

    public Kotik(String name, int weight) {
        setName(name);
        setWeight(weight);
        this.satiety = satiety;
        this.prettiness = prettiness;
        this.meow = meow;
        quantityObjects++;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getPrettiness() {
        return prettiness;
    }

    public void setPrettiness(int prettiness) {
        this.prettiness = prettiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    public static int getQuantityObjects() {
        return quantityObjects;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    public boolean play() {
        if (satiety <= 0) {
            System.out.println(getName() + " голодный. Он не будет играть. ПОКОРМИТЕ КОТА!!!!");
            eat();
            return true;
        }
        satiety = satiety - 2;
        System.out.println(getName() + " поиграл. Сытость: " + getSatiety());
        return true;
    }

    public boolean sleep() {
        if (satiety <= 0) {
            System.out.println(getName() + " голодный. Он не будет спать. ПОКОРМИТЕ КОТА!!!!");
            eat();
            return true;
        }
        satiety = satiety - 5;
        System.out.println(getName() + " поспал. Сытость: " + getSatiety());
        return true;
    }

    public boolean chaseMouse() {
        if (satiety <= 0) {
            System.out.println(getName() + " голодный. Он не будет ловить мышь. ПОКОРМИТЕ КОТА!!!!");
            eat();
            return true;
        }
        satiety = satiety - 3;
        System.out.println(getName() + " ловил мышь. Сытость: " + getSatiety());
        return true;
    }

    public boolean sit() {
        if (satiety <= 0) {
            System.out.println(getName() + " голодный. Он не будет сидеть. ПОКОРМИТЕ КОТА!!!!");
            eat();
            return true;
        }
        satiety--;
        System.out.println(getName() + " сидел и смотрел в одну точку. Сытость: " + getSatiety());
        return true;
    }

    public boolean pullSofa() {
        if (satiety <= 0) {
            System.out.println(getName() + " голодный. Он не будет драть диван. ПОКОРМИТЕ КОТА!!!!");
            eat();
            return true;
        }
        satiety--;
        System.out.println(getName() + " ободрал диван снова. Сытость: " + getSatiety());
        return true;
    }

    public boolean eat() {
        eat("фрикасе из кролика", 8);
        return true;
    }

    public boolean eat(int foodSatiety) {
        satiety += foodSatiety;
        System.out.println(getName() + " покушал. Сытость: " + getSatiety());
        return true;
    }

    public boolean eat(String foodName, int foodSatiety) {
        satiety += foodSatiety;
        System.out.println(getName() + " покушал " + foodName + ". Сытость: " + getSatiety());
        return true;
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            int j = (int) (Math.random() * 6) + 1;
            switch (j) {
                case 1:
                    play();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    chaseMouse();
                    break;
                case 4:
                    sit();
                    break;
                case 5:
                    pullSofa();
                    break;
                case 6:
                    eat();
                    break;
            }
        }
    }
}
