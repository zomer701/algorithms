import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord
{
    public String mostCommonWord(String paragraph, String[] banners)
    {
        Map<String, Integer> data = new HashMap<>();
        int max = 0;
        String maxVal = "";

        Set<String> ban = new HashSet<>();
        for (String banner: banners) {
            ban.add(banner.toLowerCase());
        }

        StringBuilder buffer = new StringBuilder();

        int index = 0;
        while (index < paragraph.length())
        {
            char value = paragraph.charAt(index);

            if (Character.isLetter(value))
            {
                buffer.append(value);
            }
            else
            {
                String word = buffer.toString().toLowerCase();
                if (word.length() > 0 && !ban.contains(word))
                {
                    int val = data.getOrDefault(word, 0) + 1;
                    data.put(word, val);

                    if (val > max) {
                        max = val;
                        maxVal = word;
                    }
                }

                buffer = new StringBuilder();
            }

            index++;
        }

        String word = buffer.toString().toLowerCase();
        if (word.length() > 0 && !ban.contains(word))
        {
            int val = data.getOrDefault(word, 0) + 1;
            data.put(word, val);

            if (val > max) {
                max = val;
                maxVal = word;
            }
        }

        return maxVal;
    }
}
