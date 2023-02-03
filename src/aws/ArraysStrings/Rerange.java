import java.util.Collections;
import java.util.List;

public class Rerange {
//b[0] < b[1] > b[2] < b[3]
    public static void rearrange(List<Integer> A) {
        for (int i = 1; i < A.size(); ++i) {
            if (((i % 2) == 0 && A.get(i - 1) < A.get(i))
                    || ((i % 2) != 0 && A.get(i - 1) > A.get(i))) {
                Collections.swap(A, i - 1, i);
            }
        }
    }
}
