package data.structures;

import java.util.Comparator;

public class Test implements Comparator<Test> {
    public String name;
    public int value;

    public Test(){};

    public Test(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public int compare(Test o1, Test o2) {
        return o2.value - o1.value;
    }

    public int getValue() {
        return  value;
    }
}
