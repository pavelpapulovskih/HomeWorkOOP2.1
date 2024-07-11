
import java.util.List;

public interface GenealogyView {
    void displayPersonInfo(Person person);
    void displayPersonList(List<? extends Person> people);
    void showError(String message);
    Person getPersonByName(String name);
    List<? extends Person> getPeopleByGender(String gender);
    void addNewPerson(Person person);
    void displaySuccessMessage(String string);
}