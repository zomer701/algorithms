package amazon;

import java.util.List;

public class Leetcode139v2 {

    public static void main(String[] args) {
        System.out.print(wordBreak("leetcode", List.of("code", "leet")));
    }



    public static boolean wordBreak(String s, List<String> wordDict) {
       boolean[] tb = new boolean[s.length()+1];
       tb[0] = true;

       for (int i = 0; i <= s.length(); i++) {
           if (tb[i]) {
               String procced = s.substring(i);

               for (String word : wordDict) {
                   if (procced.startsWith(word)) {
                       tb[i + word.length()] = true;
                   }
               }
           }
       }

       return tb[s.length()];
    }

}
