import java.util.List;

public class Main {
    private static final String FILE_PATH = "genealogy_tree.ser";

    public static void main(String[] args) {
        Person john = new Person("Джон");
        Person mary = new Person("Мэри");
        Person peter = new Person("Питер");

        john.addChild(mary);
        john.addChild(peter);

        GenealogyTree tree = new GenealogyTree(john);

        List<Person> johnChildren = tree.getChildrenOfPerson("Джон");
        System.out.println("Дети Джона:");
        for (Person child : johnChildren) {
            System.out.println(child.getName());
        }

        System.out.println("Все люди в генеалогическом древе:");
        for (Person person : tree) {
            System.out.println(person.getName());
        }
    }
}