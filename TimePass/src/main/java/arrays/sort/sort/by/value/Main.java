package arrays.sort.sort.by.value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by sarvesh on 11/3/17.
 */
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Jake1", 21);
        Person person2 = new Person("Jake", 11);
        Person person3 = new Person("Jake2", 23);
        Person person4 = new Person("Jake3", 11);

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(person1);
        personArrayList.add(person2);
        personArrayList.add(person3);
        personArrayList.add(person4);

        sort(personArrayList);
    }

    private static void sort(ArrayList<Person> personArrayList) {
        Collections.sort(personArrayList, Person.PersonComp);
        for(int i = 0; i < personArrayList.size(); i++) {
            System.out.println(personArrayList.get(i).getName() + " " + personArrayList.get(i).getAge());
        }
    }

}
