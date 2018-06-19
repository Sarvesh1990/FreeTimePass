package javaconcepts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 30/03/17.
 */
public class InterLeaveIterator implements Iterator {
    public List<Iterator> iteratorList = new LinkedList<>();
    public int currentIteratorPosition = 0;


    public InterLeaveIterator(List<Iterator> iteratorList) {
        this.iteratorList = iteratorList;
    }

    @Override
    public boolean hasNext() {
        for(int i = 0; i < iteratorList.size(); i++) {
            if(iteratorList.get(i).hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        Iterator iterator = iteratorList.get(currentIteratorPosition);
        while (!iterator.hasNext()) {
            currentIteratorPosition++;
            if(currentIteratorPosition >= iteratorList.size()) {
                currentIteratorPosition = currentIteratorPosition % iteratorList.size();
            }
            iterator = iteratorList.get(currentIteratorPosition);
        }
        currentIteratorPosition++;
        if(currentIteratorPosition >= iteratorList.size()) {
            currentIteratorPosition = currentIteratorPosition % iteratorList.size();
        }
        return iterator.next();
    }

    public void iterate() {
        while (this.hasNext()) {
            System.out.println(this.next());
        }
    }
}
