package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        LinkedList<Integer> newList = new LinkedList<>();

        new CoinChange().helper(11, newList);
    }
        static  int [] dataInit = {5,2,1};

    LinkedList<Integer> result;
    LinkedList<Integer> helper(int amount, LinkedList<Integer> data) {
        if (amount == 0) {
            return data;
        }

        if (amount < 0 || (result != null && data.size() > result.size())) {
            return new LinkedList<>();
        }

        LinkedList<Integer> result = new LinkedList<>(data);
        for (int val: dataInit) {
            LinkedList<Integer> current = new LinkedList<>(data);
            current.add(val);

            LinkedList<Integer> returnArray = helper(amount-val, current);
            if (!returnArray.isEmpty() && result.size() < returnArray.size()) {
                result = returnArray;
            }

            current.removeLast();
        }

        return result;
    }
}
