package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_1087 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Leetcode_1087().expand("abcd")));
    }

    public String[] expand(String s)
    {
        // BFS
        Queue<String> q = new LinkedList();
        q.add("");
        int i = 0;
        while (i < s.length())
        {
            // get current node
            List<Character> curr = new ArrayList();
            if (s.charAt(i) == '{')
            {
                ++i;
                while (true)
                {
                    if (Character.isLetter(s.charAt(i))) {
                        curr.add(s.charAt(i));
                    }
                    ++i;
                    if (s.charAt(i) == '}')
                    {
                        ++i; // for '}'
                        break;
                    }
                    else
                    {
                        ++i; // comma
                    }
                }
            }
            else
            {
                if (Character.isLetter(s.charAt(i))) {
                    curr.add(s.charAt(i));
                }
                i++;
            }

            // update strings in q
            for (int j = q.size(); j > 0; --j)
            {
                String prefix = q.poll();
                for (char c : curr)
                {
                    q.add(prefix + c);
                }
            }
        }

        String[] r = new String[q.size()];
        for (i = 0; i < r.length; ++i)
        {
            r[i] = q.poll();
        }
        Arrays.sort(r);
        return r;
    }
}
