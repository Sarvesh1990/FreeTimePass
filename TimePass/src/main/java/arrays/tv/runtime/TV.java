package arrays.tv.runtime;

/**
 * Created by apple on 25/02/17.
 */
public class TV implements Comparable<TV>{
    private int start;
    private int end;

    public TV(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(TV o) {
        return (this.start) - o.start;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
