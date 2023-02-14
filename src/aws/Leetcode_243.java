package aws;

public class Leetcode_243 {
    public static void main(String[] args) {

        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "makes";
        System.out.println(shortestDistance(wordsDict, word1, word2));
    }
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        Integer result = null;
        Integer point = null;
        Integer point2 = null;

        for (int i=0; i<wordsDict.length; i++) {
            String current = wordsDict[i];

            if (word1.equals(current)) {
                point = i;
            }

            if (word2.equals(current)) {
                point2 = i;
            }

            if (point != null && point2 != null) {
                int value = Math.abs(point2 - point);
                result = result == null ? value : Math.min(result, value);
            }

        }

        return result == null ? -1 : result;
    }
}
