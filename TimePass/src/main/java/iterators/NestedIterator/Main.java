package iterators.NestedIterator;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NestedInteger> nestedIntegerList = new LinkedList<NestedInteger>();
        nestedIntegerList.add(new NestedInteger(1));
        nestedIntegerList.add(new NestedInteger(new LinkedList<NestedInteger>(){
            {
                add(new NestedInteger(2));
                add(new NestedInteger(3));
                add(new NestedInteger(new LinkedList<NestedInteger>(){
                    {
                        add(new NestedInteger(4));
                        add(new NestedInteger(new LinkedList<NestedInteger>(){
                            {
                                add(new NestedInteger(7));
                                add(new NestedInteger(8));
                            }
                        }));
                    }
                }));
                add(new NestedInteger(5));
            }
        }));
        nestedIntegerList.add(new NestedInteger(6));

        NestedIterator iterator = new NestedIterator(nestedIntegerList);

        while (iterator.hasNext()) {
            System.out.println(iterator.getNext());
        }

    }
}
