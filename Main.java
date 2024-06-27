import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John");
        Person mary = new Person("Mary");
        Person peter = new Person("Peter");

        john.addChild(mary);
        john.addChild(peter);

        GenealogyTree tree = new GenealogyTree(john);

        List<Person> johnChildren = tree.getChildrenOfPerson("John");
        System.out.println("Children of John:");
        for (Person child : johnChildren) {
            System.out.println(child.getName());
        }
    }
}