package lyft;

import java.util.ArrayList;

public class MockClient implements Solution.Client {

    private static final int MAX_RESULTS = 103;
    private static final int PAGE_SIZE = 10;

    public Result fetchPage(int page) {
        ArrayList<Integer> results = new ArrayList<Integer>();

        if (page * PAGE_SIZE > MAX_RESULTS) {
            return new Result(results, -1);
        }
        results = Solution.makeRange(page * PAGE_SIZE, Math.min(MAX_RESULTS, (page + 1) * PAGE_SIZE));
        return new Result(results, page + 1);
    }
}
