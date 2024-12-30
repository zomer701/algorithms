package trello;

import java.util.Arrays;

//End all 0 to end
public class NullInEndOfArray {

    public static void main(String[] args) {
        int[] data = {2,1};
        nullInEnd(data);

        System.out.println(Arrays.toString(data));
    }

    private static void nullInEnd(int[] data) {
        int currentZero = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[currentZero] == 0 && data[i] != 0) {
                int temp = data[currentZero];
                data[currentZero] = data[i];
                data[i] = temp;
                currentZero ++;
            }

        }
    }
}
