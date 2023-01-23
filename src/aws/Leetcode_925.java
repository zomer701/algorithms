package aws;

public class Leetcode_925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "abaleex"));
    }

    public  static boolean isLongPressedName(String name, String typed) {
        if (name == null || name.isEmpty() || typed == null || typed.isEmpty()) {
            return false;
        }

        int point = 0;
        int point2 = 0;

        while (point < name.length() && point2 < typed.length()) {
            if (name.charAt(point) == typed.charAt(point2)) {
                point++;
                point2++;
                continue;
            }

            if (point > 0 && name.charAt(point-1) == (typed.charAt(point2))) {
                point2++;
                continue;
            }

            return false;
        }

        while (point2 < typed.length()) {
            if (name.charAt(point-1) != typed.charAt(point2)) {
                return false;
            }

            point2++;
        }

        return point == name.length() && point2 == typed.length();
    }
}
