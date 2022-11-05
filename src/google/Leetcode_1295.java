package google;

public class Leetcode_1295 {
    public static void main(String[] args) {
        int [] data = {555,12,482,1771};
        System.out.println(new Leetcode_1295().findNumbers(data));
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num: nums) {
            if (isDigit(num)) {
                result++;
            }
        }

        return result;
    }

    public boolean isDigit(int n){
        int c=0;
        while(n!=0){
            c++;
            n/=10;
        }
        return(c%2==0);
    }
}
