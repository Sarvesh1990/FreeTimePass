package arrays.sort.sort.by.value;

import java.util.Comparator;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public static Comparator<Person> PersonComp = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    };

    @Override
    public int compareTo(Person o) {
        if(o.getAge().compareTo(this.getAge()) != 0) {
            return o.getAge().compareTo(this.getAge());
        } else {
            return this.getName().compareTo(o.getName());
        }
    }
}
