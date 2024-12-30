package amazon;

public class Leetcode134 {
//gas = [1,2,3,4,5], cost = [3,4,5,1,2]

    //remind
    //


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for (int val : gas) {
            sumGas+= val;
        }

        int sumCost = 0;
        for (int val : cost) {
            sumCost+= val;
        }

        if (sumGas < sumCost) {
            return -1;
        }

        int gasL = gas.length;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gasL ; i++) {
            total += (gas[i] - cost[i]);
            while (total < 0) {

                total -= cost[i];
                start++;
            }
        }

        return start;
    }
}
