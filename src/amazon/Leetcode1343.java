package amazon;

public class Leetcode1343 {
    public static void main(String[] args) {
        numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4);
    }

    public static void numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (j - i == k-1) {
                    int temp = 0;
                    for (int z = i; z <= j; z++) {
                        temp += arr[z];
                    }

                    if (temp / k >= threshold) {
                        count++;
                        //System.out.println(count);
                    }
                }
            }
            }

        System.out.println(count);
    }
}
