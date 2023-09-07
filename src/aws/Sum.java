package aws;

import java.util.List;

public class Sum {
    public static void main(String[] args) {
        System.out.println(arraySum(List.of(1,2,3,4,5)));
    }

    public static int arraySum(List<Integer> numbers) {

        if (numbers == null) {
            return 0;
        }
        int sum = 0;

        for (int i = 0; i < numbers.size()/2; i++) {
            sum = sum + numbers.get(i) + numbers.get(numbers.size()-1-i);
        }

        if (numbers.size() % 2 != 0) {
            sum = sum + numbers.get(numbers.size()/2);
        }

        return sum;
    }

}
