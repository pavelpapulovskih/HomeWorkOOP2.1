import java.util.List;

public interface GenealogyModel<T extends Person> {
    List<T> getChildrenOfPerson(String name);
    T findPersonByName(String name);
    void addPerson(T person);
    void saveToDisk(String filePath);
    GenealogyTree<T> loadFromDisk(String filePath);
}