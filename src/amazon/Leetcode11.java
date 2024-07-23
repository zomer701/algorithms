package amazon;

public class Leetcode11 {
    public static void main(String[] args) {
        int [] data = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(data));
    }

    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;

        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * r-l);
            if (l <= height[r]-height[l]) {
                l++;
            } else {
                r--;
            }
        }

        return maxarea;
    }
}
