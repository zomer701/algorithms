import java.util.*;

public class FirstUniqueCharacterInString
{
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInString().firstUniqChar("dddccdbba"));
    }

    public int firstUniqChar(String s) {
        int result = -1;

        Map<Character, Integer> temp = new LinkedHashMap<>();
        for (int i = 0; i<s.length(); i++)
        {
            Character data = s.charAt(i);
            temp.put(data, temp.getOrDefault(data, 0) + 1);
        }

            for (int i = 0; i<s.length(); i++)
            {
                Character data = s.charAt(i);
                if (1 == temp.get(data))
                {
                    return i;
                }
            }

        return result;
    }
}
