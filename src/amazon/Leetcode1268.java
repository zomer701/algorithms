package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1268 {


    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"} ;
        String searchWord = "mouse";

        System.out.print(suggestedProducts(products, searchWord));
    }
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);

        int l = 0;
        int r = products.length-1;

        for (int i = 0 ; i < searchWord.length(); i++) {
            char curr = searchWord.charAt(i);

            while (l <= r && (products[l].length() <=i || products[l].charAt(i) != curr)) {
                l+=1;
            }

            while (l <= r && (products[r].length() <=i || products[r].charAt(i) != curr)) {
                r-=1;
            }

            int left = r-l+1;
            add(left, result, products);
        }




       return result;


    }

    private static void add(int left, List<List<String>> result, String[] products) {
        if (left == 0) {
           return;
        }
        List<String>  data = new ArrayList<>();

        if (left == 1) {
            data.add(products[0]);

        }


        if (left == 2) {
            data.add(products[0]);
            data.add(products[1]);

        }


        if (left == 3) {
            data.add(products[0]);
            data.add(products[1]);
            data.add(products[2]);
        }

        result.add(data);
    }

    // Equivalent code for lower_bound in Java
    static int  lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while (i < j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(word) >= 0)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
    public static List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;

            // Get the starting index of word starting with `prefix`.
            start = lower_bound(products, bsStart, prefix);

            // Add empty vector to result.
            result.add(new ArrayList<>());

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                result.get(result.size() - 1).add(products[i]);
            }

            // Reduce the size of elements to binary search on since we know
            bsStart = Math.abs(start);
        }
        return result;
    }
}
