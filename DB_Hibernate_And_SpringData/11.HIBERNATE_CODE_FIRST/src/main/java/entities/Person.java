package entities;

import javax.persistence.*;

@Entity(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    private int id;
    private String name;
    private int age;


    public Person() {

    }

    public Person(String name) {
        setName(name);
    }

    @Column(length = 50,
            nullable = false,
            unique = true)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
