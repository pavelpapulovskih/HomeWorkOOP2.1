import java.util.List;

public class GenealogyModelImpl<T extends Person> implements GenealogyModel<T> {
    private GenealogyTree<T> tree;

    @Override
    public List<T> getChildrenOfPerson(String name) {
        return tree.getChildrenOfPerson(name);
    }

    @Override
    public T findPersonByName(String name) {
        return tree.findPersonByName(name);
    }

    @Override
    public void addPerson(T person) {
        tree.addPerson(person);
    }

    @Override
    public void saveToDisk(String filePath) {
        GenealogyFileManager<T> fileManager = new GenealogyFileManager<>(filePath);
        fileManager.saveGenealogyTree(tree);
    }

    @Override
    public GenealogyTree<T> loadFromDisk(String filePath) {
        GenealogyFileManager<T> fileManager = new GenealogyFileManager<>(filePath);
        return fileManager.loadGenealogyTree();
    }
}