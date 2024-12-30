package amazon;

public class Leetcode551 {
    public static void main(String[] args) {
        System.out.print(isAward("PPALLLP"));
    }

    static boolean isAward(String data) {

        int absentCount = 0;
        int lateCount = 0;

        for (int i = 0; i < data.length(); i++ ) {
            if (absentCount >= 2) {
                return false;
            }

            if (lateCount >= 3) {
                return false;
            }

            char current = data.charAt(i);

            if (current != 'L') {
                lateCount=0;

            }


            if (current == 'A') {
                absentCount++;
            }

            if (current == 'L') {
                lateCount++;
            }
        }

        return true;
    }
}
