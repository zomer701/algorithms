import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters
{
    public int lengthOfLongestSubstring(String str) {

        Map<Character, Integer> data = new HashMap<>();

        int result = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {

            if (data.containsKey(str.charAt(i))) {
                start = Math.max(start, data.get(str.charAt(i)) + 1);
            }

            data.put(str.charAt(i), i);
            result = Math.max(result, i-start + 1);
        }

        return result;
    }
}
