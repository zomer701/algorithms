package amazon;

public class Leetcode2490 {

    public static void main(String[] args) {

    }

    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");

        if (words[0].charAt(0) != words[words.length-1].charAt(words[words.length-1].length()-1)) {
            return false;
        }

        for (int i = 0; i < words.length-1 ; i ++) {
            String current = words[i];
            String next = words[i+1];
            if (current.charAt(current.length()-1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }
}
