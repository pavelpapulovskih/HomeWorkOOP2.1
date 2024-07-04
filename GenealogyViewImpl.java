import java.util.List;

public class GenealogyViewImpl implements GenealogyView {
    @Override
    public void displayPersonInfo(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Date of Birth: " + person.getDateOfBirth());
        System.out.println("Date of Death: " + person.getDateOfDeath());
        System.out.println("Gender: " + person.getGender());
    }

    @Override
    public void displayPersonList(List<? extends Person> people) {
        for (Person person : people) {
            displayPersonInfo(person);
            System.out.println();
        }
    }

    @Override
    public void showError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}