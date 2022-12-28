package aws;

public class Leetcode_42 {
    public static void main(String[] args) {
        int[] data = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new Leetcode_42().trap(data));
    }

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;

        int lMax = height[l];
        int rMax = height[r];

        int rest = 0;

        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(height[l], lMax);
                rest = rest + lMax - height[l];
            } else {
                r--;
                rMax = Math.max(height[r], rMax);
                rest = rest + rMax - height[r];
            }
        }

        return rest;
    }
}
