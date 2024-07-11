import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;

public class GenealogyPresenterImpl<T extends Person> implements GenealogyPresenter<T> {
    private GenealogyModel<T> model;
    private GenealogyView view;

    public GenealogyPresenterImpl(GenealogyModel<T> model, GenealogyView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getChildrenOfPerson(String name) {
        List<T> children = model.getChildrenOfPerson(name);
        view.displayPersonList(children);
    }

    @Override
    public void sortPersonsByName() {
        List<T> people = model.getChildrenOfPerson(null);
        people.sort(Comparator.comparing(Person::getName));
        view.displayPersonList(people);
    }

    @Override
    public void sortPersonsByDateOfBirth() {
        List<T> people = model.getChildrenOfPerson(null);
        people.sort(Comparator.comparing(Person::getDateOfBirth));
        view.displayPersonList(people);
    }

    @Override
public void loadGenealogyTree(String filePath) {
    try (FileInputStream fileIn = new FileInputStream(filePath);
         ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
        GenealogyModel<T> loadedModel = (GenealogyModel<T>) objectIn.readObject();
        model = loadedModel; // Заменяем текущую модель загруженной моделью
        view.displaySuccessMessage("Генеалогическое дерево успешно загружено.");
    } catch (IOException | ClassNotFoundException e) {
        view.displaySuccessMessage("Ошибка при загрузке генеалогического дерева: " + e.getMessage());
    }
}

    @Override
public void saveGenealogyTree(String filePath) {
    try (FileOutputStream fileOut = new FileOutputStream(filePath);
         ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
        objectOut.writeObject(model);
         view.displaySuccessMessage("Генеалогическое дерево успешно сохранено.");
     } catch (IOException e) {
         view.displaySuccessMessage("Ошибка при сохранении генелогического древа: " + e.getMessage());
     }
}

    @Override
    public void findPersonByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPersonByName'");
    }

    @Override
    public void addPerson(T person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPerson'");
    }
}