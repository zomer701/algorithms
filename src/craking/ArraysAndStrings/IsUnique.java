package craking.ArraysAndStrings;

import java.util.Arrays;

public class IsUnique
{
    public static void main(String[] args) {
        System.out.println("isUnique = " + new IsUnique().isUnique("asdfg"));
    }

    public boolean isUnique(String data)
    {
        int MAX = 256;
        if (data.length() > MAX)
        {
            return false;
        }

        boolean[] chars = new boolean[MAX];
        Arrays.fill(chars, false);

        for (char value: data.toCharArray())
        {
            if (chars[value-'a']) {
                return false;
            }

            chars[value-'a'] = true;
        }

        return true;
    }
}
