import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] data = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(data);

        for (List<String> level: result)
        {
            System.out.print("[");
                for (String nextLevel: level)
                {
                    System.out.print(nextLevel + " ");
                }
            System.out.print("], ");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String value: strs) {
            String sortedValue = getSortAnagram(value);

            List<String> dddd = result.get(sortedValue);
            if (dddd == null) {
                List<String> list = new ArrayList<>();
                list.add(value);

                result.put(sortedValue, list);
            } else {
                dddd.add(value);
                result.put(sortedValue, dddd);
            }
        }
        return new ArrayList<>(result.values());
    }

    public String getSortAnagram(String val)
    {
        char[] chars = val.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
