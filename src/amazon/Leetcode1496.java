package amazon;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1496 {

    public static void main(String[] args) {
        System.out.println(isPathCrossing("S"));
    }

    public static boolean isPathCrossing(String path) {


        Set<String> memo = new HashSet<>();

        int x = 0;
        int y = 0;

        memo.add(x+"-"+y);
        for (int i = 0; i < path.length(); i++) {
            char current = path.charAt(i);
            if (current == 'N') {
                y += 1;
                if (memo.contains(x+"-"+y)) {
                    return true;
                }
                memo.add(x+"-"+y);

                continue;
            }
            if (current == 'S') {
                y -= 1;
                if (memo.contains(x+"-"+y)) {
                    return true;
                }
                memo.add(x+"-"+y);

                continue;
            }
            if (current == 'W') {
                x-= 1;
                if (memo.contains(x+"-"+y)) {
                    return true;
                }
                memo.add(x+"-"+y);
                continue;
            }
            if (current == 'E') {
                x += 1;
                if (memo.contains(x+"-"+y)) {
                    return true;
                }
                memo.add(x+"-"+y);
            }
        }

        return false;
    }
}
