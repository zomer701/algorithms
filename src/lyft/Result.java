package lyft;

import java.util.ArrayList;

public  class Result {

    private ArrayList<Integer> results;
    private int nextPage;

    public Result(ArrayList<Integer> results, int nextPage) {
        this.results = results;
        this.nextPage = nextPage;
    }

    public ArrayList<Integer> getResults() {
        return this.results;
    }

    public int getNextPage() {
        return this.nextPage;
    }
}
