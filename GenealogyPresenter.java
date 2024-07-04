public interface GenealogyPresenter<T extends Person> {
    void loadGenealogyTree(String filePath);
    void saveGenealogyTree(String filePath);
    void findPersonByName(String name);
    void getChildrenOfPerson(String name);
    void addPerson(T person);
    void sortPersonsByName();
    void sortPersonsByDateOfBirth();
}