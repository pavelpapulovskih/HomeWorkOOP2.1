import java.util.List;

public class Main {
    private static final String FILE_PATH = "genealogy.ser";

    public static void main(String[] args) {
        Person john = new Person("Джон", "01.01.1990", null, "Мужской");
        Person mary = new Person("Мэри","02.02.1995", null, "Женский");
        Person peter = new Person("Питер", "03.03.2000", null, "Мужской");

        john.addChild(mary);
        john.addChild(peter);

        GenealogyTree<Person> tree = new GenealogyTree<>(john);

        List<Person> johnChildren = tree.getChildrenOfPerson("Джон");
        System.out.println("Дети Джона:");
        for (Person child : johnChildren) {
            System.out.println(child.getName());
            System.out.println(child.getDateOfBirth()); // Дата рожения
            System.out.println(child.getDateOfDeath()); // Дата смерти
            System.out.println(child.getGender()); // Пол
        }

        System.out.println("Все люди в генеалогическом древе:");
        for (Person person : tree) {
            System.out.println(person.getName());
            System.out.println(person.getDateOfBirth()); // Дата рождения
            System.out.println(person.getDateOfDeath()); // Дата смерти
            System.out.println(person.getGender()); // Пол
       }
   }
}