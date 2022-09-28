package google;

public class Pair<T, T1> {
    T val;
    T1 val2;

    public Pair(T val, T1 val2) {
        this.val = val;
        this.val2 = val2;
    }

    public T getFirst() {
        return val;
    }

    public T1 getSecond() {
        return val2;
    }
}
