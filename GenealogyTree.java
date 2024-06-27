import java.util.List;

class GenealogyTree {
    private Person root;

    public GenealogyTree(Person root) {
        this.root = root;
    }

    public List<Person> getChildrenOfPerson(String name) {
        return findPersonByName(name).getChildren();
    }

    private Person findPersonByName(String name) {
        return findPersonByNameHelper(root, name);
    }

    private Person findPersonByNameHelper(Person current, String name) {
        if (current.getName().equals(name)) {
            return current;
        }

        for (Person child : current.getChildren()) {
            Person result = findPersonByNameHelper(child, name);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}