package leetcode;

public class Leetcode_2073 {
    public static void main(String[] args) {
        int [] data = {2,3,7};
        System.out.println(new Leetcode_2073().timeRequiredToBuy(data, 2));
    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;

        for (int i = 0; i<tickets.length; i++) {
            if (tickets[i] - tickets[k] <0) {
                total+=tickets[i];
            } else if(tickets[i] - tickets[k] >= 0 && i>k) {
                total+=tickets[k]-1;
            } else {
                total+=tickets[k];
            }
        }
        return total;
    }
}
