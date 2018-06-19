package iterators.NestedIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator {
    private List<NestedInteger> nestedIntegerList;
    private Stack<PeekingIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedIntegerList) {
        this.nestedIntegerList = nestedIntegerList;
        this.stack = new Stack<PeekingIterator<NestedInteger>>();
        stack.push(new PeekingIterator<>(nestedIntegerList.iterator()));
    }

    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if(stack.peek().hasNext()) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    public int getNext() {
        while(!stack.peek().peek().isInteger()) {
            stack.push(new PeekingIterator<>(stack.peek().next().getNestedIntegerList().iterator()));
        }
        return stack.peek().next().getInteger();
    }
}
