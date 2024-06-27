import java.io.*;
import java.util.List;

public class GenealogyFileManager {
    private String filePath;

    public GenealogyFileManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveGenealogyTree(GenealogyTree tree) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(tree);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении генеалогического дерева: " + e.getMessage());
        }
    }

    public GenealogyTree loadGenealogyTree() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (GenealogyTree) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке генеалогического дерева: " + e.getMessage());
            return null;
        }
    }
}