import java.util.List;

public interface GenealogyView {
    void displayPersonInfo(Person person);
    void displayPersonList(List<? extends Person> people);
    void showError(String message);
}