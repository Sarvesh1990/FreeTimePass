package data.structures.nested.list;

import data.structures.NestedDS;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NestedDS> nestedDSList = new LinkedList<>();
        nestedDSList.add(new NestedDS(1));
        LinkedList<NestedDS> nestedDSLinkedList = new LinkedList<>();
        nestedDSLinkedList.add(new NestedDS(5));
        nestedDSList.add(new NestedDS(nestedDSLinkedList));

        NestedDS nestedDS = new NestedDS(nestedDSList);

    }
}
