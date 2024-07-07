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
// Принцип единственной ответственности (Single Responsibility Principle, SRP):
// Класс GenealogyTree отвечает за хранение и управление генеалогическим деревом, что является его единственной ответственностью.
// Класс GenealogyFileManager отвечает за сохранение и загрузку генеалогического дерева, что также является его единственной ответственностью.

// Принцип открытости/закрытости (Open/Closed Principle, OCP):
// Классы GenealogyTree и GenealogyFileManager закрыты для модификации, но открыты для расширения. 
// Использование обобщённого типа T extends Person в GenealogyTree и GenealogyFileManager позволяет работать с различными типами Person, не изменяя основной код.


// Принцип подстановки Лисков (Liskov Substitution Principle, LSP):
// Класс GenealogyTreeIterator реализует интерфейс Iterator<T>, что позволяет использовать его везде, где требуется итератор.
// Использование обобщённого типа T extends Person в GenealogyTree и GenealogyFileManager гарантирует, что любой тип, наследующий от Person, может быть использован в качестве T.


// Принцип разделения интерфейсов (Interface Segregation Principle, ISP):
// В коде есть интерфейсы GenealogyModel,GenealogyPresenter,GenealogyView


// Принцип инверсии зависимостей (Dependency Inversion Principle, DIP):
// Класс GenealogyFileManager зависит от абстракции GenealogyTree, а не от конкретной реализации. Это соответствует принципу DIP.
// Использование обобщённого типа T extends Person в GenealogyTree и GenealogyFileManager также способствует инверсии зависимостей.