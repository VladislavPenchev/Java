package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "students")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student extends Person{
    private int grade;

    public Student(){
        super();
    }

    public Student(String name, int grade) {
        super(name);
        setGrade(grade);
    }

    @Column(name = "grade")
    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
