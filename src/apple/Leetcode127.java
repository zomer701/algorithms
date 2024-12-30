package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Leetcode127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(new Leetcode127().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.remove(beginWord);
        int result = deepSearch(beginWord, endWord, wordList, 1);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int deepSearch(String beginWord, String endWord, List<String> wordList, int count) {
        if (beginWord.equals(endWord)) {
            return count;
        }

        int min = Integer.MAX_VALUE;


            for (int j = 0; j < beginWord.length(); j++) {
                for (char i = 'a'; i <= 'z'; i++) {
                    String newWord = beginWord.substring(0, j) + i + beginWord.substring(j + 1, beginWord.length());
                    if (wordList.contains(newWord)) {
                        List<String> data = new ArrayList<>(wordList);
                        data.remove(newWord);
                        min = Math.min(deepSearch(newWord, endWord, data, count+1), min);
                    }
                }
          }

        return min;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // Convert word list to a set for fast lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // Early exit if endWord is not in the word list
        }

        // Initialize BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int transformations = 1; // BeginWord is counted as the first transformation

        // BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all words at the current transformation level
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();

                // Try changing each letter in the word
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    // Try all possible letters from 'a' to 'z' at position j
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) continue; // Skip if the letter is the same
                        chars[j] = c;
                        String newWord = new String(chars);

                        // If we reach endWord, return the number of transformations
                        if (newWord.equals(endWord)) {
                            return transformations + 1;
                        }

                        // If the new word is in the wordSet, add it to the queue and remove from set
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            transformations++;
        }

        // If no transformation sequence exists, return 0
        return 0;
    }
}
