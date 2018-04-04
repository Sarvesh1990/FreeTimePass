package iterators.NestedIterator;

import java.util.List;

public class NestedInteger {
    private Integer intValue;
    private List<NestedInteger> nestedIntegerList;

    public NestedInteger(int value) {
        intValue = value;
    }

    public NestedInteger(List<NestedInteger> nestedIntegerList) {
        this.nestedIntegerList = nestedIntegerList;
    }

    public Integer getInteger() {
        return intValue;
    }

    public boolean isInteger() {
        return intValue != null;
    }

    public List<NestedInteger> getNestedIntegerList() {
        return nestedIntegerList;
    }
}
