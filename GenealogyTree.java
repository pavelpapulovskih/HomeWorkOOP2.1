import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenealogyTree<T extends Person> implements Iterable<T>, Serializable {
    private T root;

    public GenealogyTree(T root) {
        this.root = root;
    }

    public List<T> getChildrenOfPerson(String name) {
        return (List<T>) findPersonByName(name).getChildren();
    }

    T findPersonByName(String name) {
        return findPersonByNameHelper(root, name);
    }

    private T findPersonByNameHelper(Person child2, String name) {
        if (child2.getName().equals(name)) {
            return (T) child2;
        }

        for (Person child : child2.getChildren()) {
            T result = findPersonByNameHelper(child, name);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenealogyTreeIterator<>(root);
    }

    private class GenealogyTreeIterator<T extends Person> implements Iterator<T>, Serializable {
        private List<T> people;

        public GenealogyTreeIterator(T root) {
            people = new ArrayList<>();
            traverse(root);
            people.sort(Comparator.comparing(Person::getName)); // Сортировка по имени
        }

        private void traverse(Person child2) {
            people.add((T) child2);
            for (Person child : child2.getChildren()) {
                traverse(child);
            }
        }

        @Override
        public boolean hasNext() {
            return !people.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return people.remove(0);
        }
    }

    public void addPerson(T person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPerson'");
    }
}