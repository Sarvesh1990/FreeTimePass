package data.structures;

import java.util.List;

public class NestedDS {
    public int value;
    public List<NestedDS> nestedList;

    public boolean isInteger;

    public NestedDS(int value) {
        this.value = value;
        isInteger = true;
    }

    public NestedDS(List<NestedDS> nestedList) {
        this.nestedList = nestedList;
    }


}
