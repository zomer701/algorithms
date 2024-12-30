package meta;

public class Leetcode_1701 {
    public static void main(String[] args) {
        int[][] data = {{1,2},{2,5},{4,3}};
        System.out.println(new Leetcode_1701().averageWaitingTime(data));
    }

    public double averageWaitingTime(int[][] customers) {
        int currenTime = 0;
        double waiteTime = 0;
        for (int[] customer: customers) {
            int arrival = customer[0];
            int cookTime = customer[1];

            if (arrival > currenTime) {
                currenTime = arrival;
            }

            currenTime += cookTime;
            waiteTime += currenTime - arrival;
        }
        return waiteTime / customers.length;
    }
}
