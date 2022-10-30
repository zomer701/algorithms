package lyft;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public  class Fetcher {
    private Solution.Client client;
    int page = 1;
    int itemPage = -1;
    int next = -1;
    List<Integer> items = new ArrayList<>();

    Fetcher(Solution.Client client) {
        this.client = client;

        Result clientResult = this.client.fetchPage(page);

        ArrayList<Integer> resultList = clientResult.getResults();
        int next = clientResult.getNextPage();
        this.next = next;

        if (page == 0 && next != -1) {
            itemPage = resultList.size();
        }

        items = resultList;
    }

    public ArrayList<Integer> fetch(int numResults) {

        ArrayList<Integer> result = new ArrayList<>();

        if (items != null && items.size() > 0) {
            for (int i = 0;i < Math.min(items.size(), numResults); i++) {
                result.add(items.get(i));
            }
        }

        if (result.size() < numResults && next > 0) {
            while (next > 0 && numResults < result.size()) {
                Result clientResult = this.client.fetchPage(page);
                this.next = clientResult.getNextPage();
                ArrayList<Integer> innerresult = clientResult.getResults();
                if (innerresult != null && innerresult.size() > 0) {
                    for (int i = 0; i < Math.max(innerresult.size(), numResults - result.size()); i++) {
                        if (result.size() == numResults) {
                            items.clear();
//                            items.add(innerresult.get());
                        } else {
                            if (result.size() < numResults) {
                                result.add(innerresult.get(i));
                            } else {

                                items.clear();
                            }
                        }

                    }

                }
                if (numResults > result.size()) {
                    page++;
                }
            }
        }


        return result;
    }

}
