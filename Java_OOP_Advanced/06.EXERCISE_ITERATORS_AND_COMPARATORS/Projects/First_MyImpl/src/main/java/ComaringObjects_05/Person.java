package ComaringObjects_05;

public class Person implements Comparable<Person>{
    private String name;
    private String town;
    private int age;

    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        int comparatorByName = this.name.compareTo(other.name);
        if(comparatorByName != 0) {
            return comparatorByName;
        }

        int comparatorByAge = this.age - other.age;
        if(comparatorByAge != 0) {
            return comparatorByAge;
        }
        return this.town.compareTo(other.town);
    }
}
