package lyft;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Client mockClient = new MockClient();

        Fetcher fetcher1 = new Fetcher(mockClient);
        testCase(1, fetcher1.fetch(5), makeRange(0, 5));
        testCase(2, fetcher1.fetch(2), makeRange(5, 7));
        testCase(3, fetcher1.fetch(7), makeRange(7, 14));
        testCase(4, fetcher1.fetch(103), makeRange(14, 103));
        testCase(5, fetcher1.fetch(10), makeRange(0, 0));

        Fetcher fetcher2 = new Fetcher(mockClient);
        testCase(6, fetcher2.fetch(200), makeRange(0, 103));
    }

    static void testCase(int caseNum, ArrayList<Integer> actual, ArrayList<Integer> expected) {
        if (actual.containsAll(expected) && expected.containsAll(actual)) {
            System.out.println("Test " + caseNum + " passed");
        } else {
            System.out.println("Test " + caseNum + " failed - expected: " + expected);
            System.out.println("actual: " + actual);
        }
    }


    /**
     * A third-party API that we're using has a paginated API. It returns results in chunks.
     * This is defined below on as Client.fetchPage()
     *
     * We don't think that API is very useful, and would like to implement a single function that
     * fetches n number of results from fetch page and abstracts away the pagination.
     *
     * Your task will be to implement Fetcher.fetch()
     */
    public static ArrayList<Integer> makeRange(int min, int max) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = min; i < max; i++) {
            results.add(i);
        }
        return results;
    }

    interface Client {

        /**
         * Return the next page of results. If page == 0, starts from the
         * beginning. Otherwise, fetches the next PAGE_SIZE records after the last page.
         * returns:
         *    {
         *       'results': [...],
         *       'nextPage': 3
         *    }
         */
        Result fetchPage(int page);
    }

}
