import java.util.List;

public class Main {
    private static final String FILE_PATH = "genealogy.ser";

    public static void main(String[] args) {
        Person john = new Person("Джон", "01.01.1990", null, "Мужской");
        Person mary = new Person("Мэри", "02.02.1995", null, "Женский");
        Person peter = new Person("Питер", "03.03.2000", null, "Мужской");

        GenealogyModel<Person> model = new GenealogyModelImpl<>();
        GenealogyView view = new GenealogyViewImpl();
        GenealogyPresenter<Person> presenter = new GenealogyPresenterImpl<>(model, view);

        presenter.addPerson(john);
        presenter.addPerson(mary);
        presenter.addPerson(peter);

        presenter.getChildrenOfPerson("Джон");
      

        presenter.saveGenealogyTree(FILE_PATH);
        presenter.loadGenealogyTree(FILE_PATH);
    }
}