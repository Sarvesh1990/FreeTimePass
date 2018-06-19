package iterators.NestedIterator;

import java.util.Iterator;

class PeekingIterator<T> implements Iterator<T> {

    T cache;
    Iterator<T> it;

    public PeekingIterator(Iterator<T> iterator) {
        // initialize any member here.
        this.cache = iterator.next();
        this.it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T res = cache;
        cache = it.hasNext() ? it.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext() || cache != null;
    }
}
