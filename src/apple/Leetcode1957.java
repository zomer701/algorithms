package apple;

public class Leetcode1957 {
    public static void main(String[] args) {
        System.out.println(new Leetcode1957().makeFancyString("leeetcode"));
    }

    public String makeFancyString(String s) {

        char[] sArray = s.toCharArray();
        int count = 0;
        char prev = '-';

        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++){
              char current = sArray[i];
              if (current == prev) {
                  count++;
                  if (count >= 3) {
                      continue;
                  }
              } else {
                count = 1;
              }
            prev = current;
            builder.append(current);
        }



        return builder.toString();
    }
}
