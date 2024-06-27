import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class GenealogyTree implements Iterable<Person> {
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

    @Override
    public Iterator<Person> iterator() {
        return new GenealogyTreeIterator(root);
    }

    private class GenealogyTreeIterator implements Iterator<Person> {
        private List<Person> people;

        public GenealogyTreeIterator(Person root) {
            people = new ArrayList<>();
            traverse(root);
            people.sort(Comparator.comparing(Person::getName)); // Сортировка по имени
        }

        private void traverse(Person person) {
            people.add(person);
            for (Person child : person.getChildren()) {
                traverse(child);
            }
        }

        @Override
        public boolean hasNext() {
            return !people.isEmpty();
        }

        @Override
        public Person next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return people.remove(0);
        }
    }
}