package elements.array;

public class PrintAllSubArray {

    public static void main(String[] args) {
        print(new int[]{1, 2 , 3});
    }

    private static void print(int [] data) {
        for (int i = 0; i<data.length; i++) {
            StringBuilder print = new StringBuilder();
            for (int j = i; j<data.length; j++) {
                System.out.println(print.append(data[j]));
            }
        }
    }
}
