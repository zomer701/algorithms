package google;

public class Leetcode_11 {
    public static void main(String[] args) {
        int [] data = {1,8,6,2,5,4,8,3,7};

        System.out.println(new Leetcode_11().maxArea(data));
    }

    public int maxArea(int[] height) {
        int i = 0; int j = height.length-1;
        int maxarea = 0;
        while (i < j) {
            maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j-i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxarea;
    }
}
