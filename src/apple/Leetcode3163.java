package apple;

public class Leetcode3163 {
    public static void main(String[] args) {
       // System.out.println("1 = " + "1a1b1c1d1e".equals(new Leetcode3163().compressedString("abcde")));
        System.out.println(new Leetcode3163().compressedString("aaaaaaaaay"));
       // System.out.println("2 = " + "aaaaaaaaaaaaaabb".equals(new Leetcode3163().compressedString("9a5a2b")));
    }

    public String compressedString(String word) {
        StringBuilder builder = new StringBuilder();

        int count = 0;
        char prev = '-';
        int index = 0;
        while (index < word.length()) {
            char current = word.charAt(index);

            if (prev == '-' || current == prev) {
                count++;
            } else {
                if (count > 0) {
                    builder.append(count).append(prev);
                }
                count = 1;
            }

            if (count == 9) {
                builder.append(9).append(current);
                count = 0;
            }

            prev = current;
            index++;
        }

        if (count > 0) {
            builder.append(count).append(word.charAt(word.length()-1));
        }


        return builder.toString();
    }
}
