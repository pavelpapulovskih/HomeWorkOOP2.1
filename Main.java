import java.util.List;

public class Main {
    private static final String FILE_PATH = "genealogy_tree.ser";

    public static void main(String[] args) {
        Person john = new Person("John");
        Person mary = new Person("Mary");
        Person peter = new Person("Peter");

        john.addChild(mary);
        john.addChild(peter);

        GenealogyTree tree = new GenealogyTree(john);

        // Создаем экземпляр GenealogyFileManager
        GenealogyFileManager fileManager = new GenealogyFileManager(FILE_PATH);

        // Сохраняем генеалогическое дерево в файл
        fileManager.saveGenealogyTree(tree);

        // Загружаем генеалогическое дерево из файла
        GenealogyTree loadedTree = fileManager.loadGenealogyTree();

        if (loadedTree != null) {
            List<Person> johnChildren = loadedTree.getChildrenOfPerson("John");
            System.out.println("Children of John (loaded from file):");
            for (Person child : johnChildren) {
                System.out.println(child.getName());
            }
        }
    }
}