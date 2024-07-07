import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Genealogical {
    private String name;
    private String dateOfBirth;
    private String dateOfDeath;
    private String gender;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String dateOfBirth, String dateOfDeath, String gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public String getGender() {
        return gender;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public void addChild(Person child) {
        children.add(child);
    }
    public int getAge() {
        return 0; 
    }
    
    public int getAgeAtDeath() { 
        return 0; 
    }
    public boolean isParentOf(Person child) {   
        return child.getParents().contains(this);
    }
    public boolean isChildOf(Person parent) {
        return this.getParents().contains(parent);
    }
    
    public boolean isSiblingOf(Person sibling) {
   
        for (Person parent : this.getParents()) {
            if (sibling.getParents().contains(parent)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isParentOf(Genealogical member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isParentOf'");
    }

    @Override
    public boolean isChildOf(Genealogical member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isChildOf'");
    }

    @Override
    public boolean isSiblingOf(Genealogical member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSiblingOf'");
    }
}
// Принцип единственной ответственности (Single Responsibility Principle, SRP):
// Класс Person отвечает за хранение и управление данными, связанными с человеком, такими как имя, дата рождения, дата смерти, пол, родители и дети. .

// Принцип открытости/закрытости (Open/Closed Principle, OCP):
// Класс Person закрыт для модификации, но открыт для расширения. 

// Принцип подстановки Барбары Лисков (Liskov Substitution Principle, LSP):
// Класс Person не нарушает принцип LSP, так как он не содержит методов, которые могут быть переопределены в подклассах с нарушением ожидаемого поведения.

// Принцип разделения интерфейсов (Interface Segregation Principle, ISP):
// Класс Person содержит интерфейс Genealogical.

// Принцип инверсии зависимостей (Dependency Inversion Principle, DIP):
// Класс Person не зависит от высокоуровневых модулей.