package amazon;

import java.util.HashSet;
import java.util.Set;

public class Leetcode771 {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> memo = new HashSet<>();
        for (Character jew: jewels.toCharArray()) {
            memo.add(jew);
        }

        int count = 0;
        for (Character st: stones.toCharArray()) {
            if (memo.contains(st)) {
                count++;
            }
        }

        return count;
    }
}
