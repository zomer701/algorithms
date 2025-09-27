package apple;

public class Leetcode4 {
    public static void main(String[] args) {
        int [] nums1 = {1,3};

        int [] nums2 = {2};

        System.out.println(new Leetcode4().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a == null ? 0 : a.length, n = b == null ? 0 : b.length;
        if (m == 0) return medianOfOne(b);
        if (n == 0) return medianOfOne(a);

        int total = m + n;
        int target = total / 2;
        int i = 0, j = 0, idx = 0, prev = 0, curr = 0;

        while (idx <= target) {
            prev = curr;
            if (i < m && (j >= n || a[i] <= b[j])) {
                curr = a[i++];
            } else {
                curr = b[j++];
            }
            idx++;
        }

        if ((total & 1) == 1) return curr;
        return (prev + curr) / 2.0;
    }

    private double medianOfOne(int[] x) {
        if (x == null || x.length == 0) return 0.0;
        int len = x.length, mid = len / 2;
        return (len % 2 == 1) ? x[mid] : (x[mid - 1] + x[mid]) / 2.0;
    }
}
