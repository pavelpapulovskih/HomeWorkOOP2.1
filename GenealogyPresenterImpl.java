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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadGenealogyTree'");
    }

    @Override
    public void saveGenealogyTree(String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveGenealogyTree'");
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