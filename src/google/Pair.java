package google;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(val, pair.val) && Objects.equals(val2, pair.val2);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "val=" + val +
                ", val2=" + val2 +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, val2);
    }
}
