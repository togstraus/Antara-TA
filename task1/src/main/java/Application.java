import model.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik kot1 = new Kotik("Барсик", 25);
        Kotik kot2 = new Kotik();
        kot2.setKotik(10, "Чел", 34, "Меу");
        System.out.println("Кот " + kot2.getName() + " говорит '" +  kot2.getMeow() + "' и весит " + kot2.getWeight() + ".");
        kot1.liveAnotherDay();
        if (kot1.getMeow().equals(kot2.getMeow())){
            System.out.println("Коты говорят одинаково:" + kot1.getMeow());
        } else {
            System.out.println("Коты говорят по-разному. " + kot1.getName() + " говорит " + kot1.getMeow() + ", а " + kot2.getName() + " говорит " + kot2.getMeow() + ".");
        }
        System.out.println("Количество созданных объектов класса Котик: " + Kotik.getQuantityObjects());
    }
}