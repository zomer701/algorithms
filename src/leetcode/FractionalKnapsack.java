package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int [] wt = {10, 40, 20, 30};
        int [] val = {60, 40, 100, 120};
        int capacity = 50;
        
        double maxValue = getMaxvalue(wt, val, capacity);
        System.out.println("M V " + maxValue);
    }

    private static double getMaxvalue(int[] wt, int[] val, int capacity) {
        Item[] items = new Item[wt.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(wt[i], val[i], i);
        }

        Arrays.sort(items, Comparator.comparing(o -> o.cost));

        double totalValue  = 0d;

        for (Item item: items) {
            int curWt = (int) item.wt;
            int curVal = (int) item.val;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            } else  {
                double fraction = (double) capacity/(double) curWt;
                totalValue += curVal * fraction;
                break;
            }

        }

        return totalValue;
    }

    static class Item {
        Double cost;
        double wt, val, ind;

        public Item(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;

            cost = (double) (val / wt);
        }
    }
}
