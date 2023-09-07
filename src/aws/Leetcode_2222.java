package aws;

public class Leetcode_2222 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_2222().numberOfWays("001101"));
    }

    public long numberOfWays(String s) {
        return dfs(s, 0, 0);
    }

    private long dfs(String s, int i, int i1) {
        return 0;
    }

}
