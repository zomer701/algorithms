package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode66 {
    public static void main(String[] args) {
        System.out.print(plusOne(List.of(9,9,9)));
    }

    static  List<Integer> plusOne(List<Integer> data) {

        List<Integer> result = new ArrayList<>();

        int size = data.size()-1;
        int flag = 1;
        while (size >= 0) {
                int current = data.get(size) + flag;
                if (current == 10) {
                    flag = 1;
                    result.add(0);
                } else {
                    result.add(current);
                    flag = 0;
                }
                size--;
        }

        if (flag > 0) {
            result.add(1);
        }

        List<Integer> result2 = new ArrayList<>();
        size = result.size()-1;
       while (size >= 0) {
           result2.add(result.get(size));
           size--;
       }

        return result2;
    }
}
