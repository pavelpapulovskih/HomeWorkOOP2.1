public interface Genealogical {
    int getAge();
    int getAgeAtDeath();
    boolean isParentOf(Genealogical member);
    boolean isChildOf(Genealogical member);
    boolean isSiblingOf(Genealogical member);
}