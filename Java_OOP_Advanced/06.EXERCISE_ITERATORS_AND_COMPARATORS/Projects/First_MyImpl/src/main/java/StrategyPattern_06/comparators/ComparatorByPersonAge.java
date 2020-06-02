package StrategyPattern_06.comparators;

import StrategyPattern_06.Person;

import java.util.Comparator;

public class ComparatorByPersonAge implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
