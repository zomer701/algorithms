package netflix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leetcode127 {
    int result = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a set for quick lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // If the end word is not in the list, return 0

        // Initialize the BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // A set to keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1; // Start with the initial step

        // BFS loop
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of elements at the current level
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                // Try changing each character of the current word
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordChars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        char originalChar = wordChars[j];
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if (newWord.equals(endWord)) {
                            return steps + 1; // Found the shortest transformation
                        }

                        // If the new word is in the word set and not visited, add it to the queue
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }

                        wordChars[j] = originalChar; // Restore the original character
                    }
                }
            }
            steps++;
        }

        return 0; // No transformation found
    }

}
