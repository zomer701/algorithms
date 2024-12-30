package amazon;

public class Leetcode852 {
    public static void main(String[] args) {

    }

    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
