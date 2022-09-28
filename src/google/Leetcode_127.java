package google;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Leetcode_127 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_127().ladderLength("hot", "dog", Arrays.asList("hot","dog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        Set<String> visit = new HashSet<>();
        Queue<Pair<String, Set<String>>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, set));

        // COUNT NUMBER OF WORDS TRANSFORMED
        int count = 1;
        visit.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Set<String>> data = queue.poll();
                Set<String> currentList = data.getSecond();

                List<String> processWords = new ArrayList<>();
                for (String word: currentList) {
                    if (isOneEditAway(data.getFirst(), word)) {
                        if (word.equals(endWord)) {
                            return ++count;
                        }

                        if (!visit.contains(word)) {
                            processWords.add(word);
                            visit.add(word);
                        }
                    }
                }

                for (String word: processWords) {
                    Set<String> newWordSet = new HashSet<>(currentList);
                    newWordSet.remove(word);
                    queue.add(new Pair<>(word, newWordSet));
                }
            }
            count++;
        }
        return 0;
    }

    private boolean isOneEditAway(String w1, String w2) {
        boolean diffFound = false;
        for (int i = 0; i<Math.min(w1.length(), w2.length()); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (diffFound) {
                    return false;
                } else {
                    diffFound = true;
                }
            }
        }
        return true;
    }
}
